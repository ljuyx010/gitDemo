package net.dpwl.webapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.dpwl.webapi.entity.User;
import net.dpwl.webapi.mapper.UserMapper;
import net.dpwl.webapi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public User getUserById(int id) {
        // 使用LambdaQueryWrapper构建查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, id);
        // 可以添加其他条件，比如只查询未删除的用户
        //wrapper.eq(User::getYz, 1);

        return this.getOne(wrapper);
    }
}
