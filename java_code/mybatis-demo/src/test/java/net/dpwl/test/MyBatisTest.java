package net.dpwl.test;

import net.dpwl.mapper.UserMapper;
import net.dpwl.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/26 10:25
 */
public class MyBatisTest {
    @Test
    public void testSelectByName() throws IOException {
        // 1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取sqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //设置自动提交
        // 3.获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 4.执行方法
        User user = userMapper.selectUserByName("法");
        System.out.println(user);
    }
}
