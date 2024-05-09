import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ProjectName: JDBC
 * @Package: PACKAGE_NAME
 * @ClassName: JDBCDemo4
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/9 18:53
 * @Version: 1.0
 */
public class JDBCDemo4 {
    public static void main(String[] args) throws SQLException {

        //1.创建数据源
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/yxb?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        Connection connection = dataSource.getConnection();


        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
           int id =  resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("id = " + id +",name = " + name);
        }
        //5.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}