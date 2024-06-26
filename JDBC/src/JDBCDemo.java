import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @ProjectName: JDBC
 * @Package: PACKAGE_NAME
 * @ClassName: JDBCDemo
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/8 20:30
 * @Version: 1.0
 */


public class JDBCDemo {
    public static void main(String[] args) throws SQLException {
        //接下来通过JDBC进行一个简单的插入操作
        //JDBC代码写起来,对于初学者来说,有一点繁琐
        //步骤很多

        Scanner scanner = new Scanner(System.in);
        //1.创建"数据源"
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/yxb?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2.和数据库进行连接
        Connection connection = dataSource.getConnection();

        //3.构造数据库的 sql 语句
        System.out.println("请输入你的学号:");
        int id =scanner.nextInt();
        System.out.println("请输入你的姓名");
        String name = scanner.next();
        //String sql = "insert into test values(1,'张三')";
        String sql = "insert into student values(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);

        //4.执行 sql,把刚才解析好的语句发给数据库服务器
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);

        //5.释放资源
        preparedStatement.close();
        connection.close();

    }
}