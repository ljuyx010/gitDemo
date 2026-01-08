package net.dpwl.webapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.dpwl.webapi.dto.PageDTO;
import net.dpwl.webapi.entity.User;
import net.dpwl.webapi.query.UserQuery;
import net.dpwl.webapi.vo.UserVO;

import java.util.List;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/31 13:38
 */
public interface UserService extends IService<User> {
    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户信息
     */
    User getUserById(int id);

    List<User> queryUsers(String nickname, Integer sex, Integer yz, String tel);

    PageDTO<UserVO> queryUsersPage(UserQuery query);
}
