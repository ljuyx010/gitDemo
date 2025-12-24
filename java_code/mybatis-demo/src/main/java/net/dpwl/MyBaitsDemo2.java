package net.dpwl;

import net.dpwl.mapper.UserMapper;
import net.dpwl.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/24 16:03
 */
// mapper 代理方式开发
public class MyBaitsDemo2 {
    public static void main(String[] args) throws IOException {
        // 加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取sqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 使用mapper代理方式开发，不需要写sql语句,要先获取usermapper对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.selectUser(1);
            // 打印结果
            System.out.println(user);
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
