import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

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
        //1.创建"数据源"
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/yxb?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("123456");

        //2.和数据库进行连接
        dataSource.getConnection();



    }
}