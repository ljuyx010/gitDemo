package net.dpwl;

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
public class MyBaitsDemo {
    public static void main(String[] args) throws IOException {
        // 加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2.获取sqlSession对象，用它来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 执行sql语句
            User user = sqlSession.selectOne("test.selectUser", 1);
            // 打印结果
            System.out.println(user);
        } finally {
            // 关闭sqlSession
            sqlSession.close();
        }
    }
}
