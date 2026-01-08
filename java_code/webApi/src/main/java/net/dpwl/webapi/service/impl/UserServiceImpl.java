package net.dpwl.webapi.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import net.dpwl.webapi.dto.PageDTO;
import net.dpwl.webapi.entity.Article;
import net.dpwl.webapi.entity.User;
import net.dpwl.webapi.mapper.UserMapper;
import net.dpwl.webapi.query.UserQuery;
import net.dpwl.webapi.service.UserService;
import net.dpwl.webapi.vo.ArticleVO;
import net.dpwl.webapi.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private PageDTO pageDTO;

    @Override
    public User getUserById(int id) {
        // 使用LambdaQueryWrapper构建查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, id);
        // 可以添加其他条件，比如只查询未删除的用户
        //wrapper.eq(User::getYz, 1);

        return this.getOne(wrapper);
    }

    @Override
    public List<User> queryUsers(String nickname, Integer sex, Integer yz, String tel) {
        // 使用lambdaQuery()方法构建多重查询条件
        return lambdaQuery()
                .ge(yz != null, User::getYz, yz)
                .like(nickname != null, User::getNickname, nickname)
                .eq(sex != null, User::getSex, sex)
                .like(tel != null, User::getTel, tel)
                .list();
    }

    @Override
    public PageDTO<UserVO> queryUsersPage(UserQuery query) {
        // 1. 构建分页条件
        // 1.1 分页条件
        Page<User> page = query.toMpPage();
        // 2. 分页查询
        Page<User> p = lambdaQuery().ge(User::getYz, query.getYz())
                .like(query.getNickname() != null, User::getNickname, query.getNickname())
                .eq(query.getSex() != null, User::getSex, query.getSex())
                .like(query.getTel() != null, User::getTel, query.getTel())
                .page(page);

        // 4. 返回分页结果
        //return pageDTO.of(p, UserVO.class);
        // 使用函数式接口转换分页数据
        return pageDTO.of(p, user -> {
            UserVO userVO = BeanUtil.copyProperties(user, UserVO.class);
            // 可以做特殊处理，比如只显示名字的部分
            userVO.setName(userVO.getName().substring(0, 1) + "**");
            return userVO;
        });
    }

    public void queryUserAndArticleById(Integer id) {
        User user = getUserById(id);
        if (user != null) {
            throw new RuntimeException("用户不存在");
        }
        // 查询相关的文章
        List<Article> articles = Db.lambdaQuery(Article.class).eq(Article::getUid, id).list();
    }

    public List<UserVO> queryUserAndArticleByIds(List<Integer> ids) {
        // 1.查询用户 使用Service接口的listByIds方法
        List<User> users = listByIds(ids);
        if (CollUtil.isEmpty(users)) {
            //throw new RuntimeException("用户不存在");
            return Collections.emptyList();
        }
        // 2.查询文章
        // 2.1获取用户id集合(通过流，搜集User::getId转成list)
        List<Integer> userIds = users.stream().map(User::getId).collect(Collectors.toList());
        // 2.2查询相关的文章 使用Db静态方法不需要注入 Article的service依赖
        List<Article> articles = Db.lambdaQuery(Article.class).in(Article::getUid, userIds).list();
        // 2.3 转换文章vo
        List<ArticleVO> articleVOList = BeanUtil.copyToList(articles,ArticleVO.class);
        Map<Integer,List<ArticleVO>> articleMap = new HashMap<>();
        // 健壮性处理，判断articleVOList非空才能转vo，否则会报错
        if(CollUtil.isNotEmpty(articleVOList)){
            //2.4 梳理文章集合（分组），分类整理，相同用户的文章放入一个集合（组）中
            articleMap = articleVOList.stream().collect(Collectors.groupingBy(ArticleVO::getUid));
        }
        // 3.转vo返回
        List<UserVO> list = new ArrayList<>(users.size());
        for(User user: users){
            // 3.1转换user的po为vo
            UserVO vo = BeanUtil.copyProperties(user,UserVO.class);
            // 3.2转换articleVO
            vo.setArticle(articleMap.get(user.getId()));
            list.add(vo);
        }
        return list;
    }

}
