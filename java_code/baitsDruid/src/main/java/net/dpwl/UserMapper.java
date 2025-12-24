package net.dpwl;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/23 13:47
 */
@Mapper
public interface UserMapper {
    User selectUser(int id);
}