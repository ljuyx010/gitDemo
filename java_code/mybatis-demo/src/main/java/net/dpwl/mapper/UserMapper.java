package net.dpwl.mapper;

import net.dpwl.pojo.User;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/24 16:51
 */
public interface UserMapper {
        /**
         * 根据id查询用户
         * @param id 用户id
         * @return 用户对象
         */
        User selectUser(Integer id);
}
