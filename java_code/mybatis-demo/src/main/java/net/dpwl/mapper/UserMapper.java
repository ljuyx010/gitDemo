package net.dpwl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.dpwl.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/24 16:51
 */
public interface UserMapper extends BaseMapper<User> {
        /**
         * 根据id查询用户
         * @param id 用户id
         * @return 用户对象
         */
        User selectUser(Integer id);

        User selectUserByName(String name);
        List<User> selectAllUserByCondition(@Param("yz")int yz,@Param("name")String name,@Param("sex")int sex);
        List<User> selectByCondition(User user);
        List<User> selectByCondition(Map map);
        void addUser(User user);
        int updateUser(User user);
        void deleteByIds(@Param("ids") Integer[] ids);
}
