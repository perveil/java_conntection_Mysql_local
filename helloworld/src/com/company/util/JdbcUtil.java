package com.company.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {


   private static final String username="root";

   private static final String password = "root";

   private static final String url = "jdbc:mysql://127.0.0.1:3306/user?useSSL=false";

   private static Connection connection = null;

   static{ //static数据初始化，在对象初始化的时候自动链接mysql数据库
       try {
           Class.forName("com.mysql.jdbc.Driver"); //加载驱动，CLass.Forname()
           connection = DriverManager.getConnection(url,username,password);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }
   //open the connection
    public static Connection getConnection(){
       return connection;
    }
    //close the connection
    public static void close(PreparedStatement prepareStatement,Connection conn) throws Exception{
        if (prepareStatement!=null){
            prepareStatement.close();
            if (conn == null) {
                conn.close();
            }
        }
    }

}
