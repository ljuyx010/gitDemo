import JDBCUtils.JDBCUtilsByDruid;
import com.mysql.jdbc.Statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/5 10:36
 */
public class JDBCUtilsByDruid_use {

    @SuppressWarnings({"all"})
    public static  void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
            String sql = "select * from common where title like ?";
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, "%孝感%");
            set = statement.executeQuery();
            while (set.next()) {
                System.out.println(set.getString("title"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(set, statement, connection);
        }
    }
}
