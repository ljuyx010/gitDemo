package net.dpwl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDruidMybatisTest {
    public static void main(String[] args) {
        try {
            // 加载Spring配置文件
            System.out.println("正在加载Spring配置文件...");
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

            // 获取UserMapper对象
            System.out.println("正在获取UserMapper...");
            UserMapper userMapper = context.getBean(UserMapper.class);

            // 执行查询
            System.out.println("正在执行数据库查询...");
            User user = userMapper.selectUser(1);
            System.out.println("查询结果：" + user);

        } catch (Exception e) {
            System.err.println("Spring应用错误：");
            e.printStackTrace();
        }
    }
}
