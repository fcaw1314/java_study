import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ProjectName: JDBC
 * @Package: PACKAGE_NAME
 * @ClassName: JDBCDemo2
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/9 15:05
 * @Version: 1.0
 */
public class JDBCDemo2 {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/yxb?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2.和数据库进行连接
        Connection connection = dataSource.getConnection();

        //3.构造数据库的 sql 语句

        String sql = "update student set name = '王大锤' where id = 3";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        //4.执行 sql,把刚才解析好的语句发给数据库服务器
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);

        //5.释放资源
        preparedStatement.close();
        connection.close();
    }
}