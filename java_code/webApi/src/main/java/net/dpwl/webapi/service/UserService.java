package net.dpwl.webapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.dpwl.webapi.entity.User;

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
}
