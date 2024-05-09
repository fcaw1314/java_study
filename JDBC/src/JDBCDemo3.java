import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @ProjectName: JDBC
 * @Package: PACKAGE_NAME
 * @ClassName: JDBCDemo3
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/9 18:44
 * @Version: 1.0
 */
public class JDBCDemo3 {
    public static void main(String[] args) throws SQLException {
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/yxb?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        Connection connection = dataSource.getConnection();
        String sql = "delete from student where name = '王大锤'";
        PreparedStatement statement = connection.prepareStatement(sql);


        //4.执行 sql,把刚才解析好的语句发给数据库服务器
        int n = statement.executeUpdate();
        System.out.println("n = " + n);

        //5.释放资源
        statement.close();
        connection.close();

    }
}