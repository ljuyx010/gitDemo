package net.dpwl;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/24 11:40
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            // 加载驱动
            System.out.println("正在加载驱动...");
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立连接
            System.out.println("正在建立连接...");
            String url = "jdbc:mysql://localhost:3306/myyunmengfayuan?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
            String username = "root";
            String password = "H3u94c94kod0UjGuNmkfmqw0JMJRMF";

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功：" + conn);

            // 测试查询
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dp_user WHERE id = 1");
            if (rs.next()) {
                System.out.println("查询成功：id=" + rs.getInt("id") + ", nickname=" + rs.getString("nickname"));
            }

            // 关闭资源
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("JDBC测试失败：");
            e.printStackTrace();
        }
    }
}