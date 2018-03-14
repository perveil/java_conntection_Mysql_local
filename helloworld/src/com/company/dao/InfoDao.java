package com.company.dao;

import com.company.util.JdbcUtil;
import com.company.entity.Info;

import java.sql.*;

public class InfoDao {

    public void add(Info info) throws Exception {
        Connection conn = JdbcUtil.getConnection();

        String sql = "insert into info values(?,?)";
        //PreparedStatement 实例包含了 已经编译好的sql语句，sql语句可能包含一个或者两个值，这些未被明确指定，而是被？ 占位符
        //代替，之后执行的sql语句要用setXX方法对值进行写入
        String name=info.getName();
     if (!find(name)){
         try {
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             //实例化对象进行预编译sql语言
             //preparedStatement 是statement接口的子接口，属于预处理操作，preparedStatement在操作时预先在数据表中准备好了一句sqlu语句，
             //但是此sql语句的具体内容暂时不设置。而是之后在进行设置
             preparedStatement.setString(1,info.getName());
             preparedStatement.setString(2,info.getPassword());
             preparedStatement.execute();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }else{
         System.out.printf("相同的人出现两次");
     }

    }
    public void  selectAll() throws SQLException {
        Connection conn=JdbcUtil.getConnection();
        String sql= "select * from info";
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString("name")+" "+rs.getString("password"));
        }

    }
    public boolean find(String name) throws Exception{

        Connection conn=JdbcUtil.getConnection();
        String sql = "select password from info where name=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()){
               // System.out.print("找到了"+rs.getString("password"));
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String name) throws Exception{

        Connection conn=JdbcUtil.getConnection();
        String sql = "delete from info where name=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            int rs=preparedStatement.executeUpdate();
            if (rs>=1) {
                System.out.println(rs);
                System.out.printf("delete successed");
                return true;

            }else{
                System.out.printf("delete failure");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    public boolean update(Info info) throws Exception{
        Connection conn=JdbcUtil.getConnection();
        String sql = "update info SET name=?,password=? WHERE name=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,info.getName());
            preparedStatement.setString(2,info.getPassword());
            preparedStatement.setString(3,info.getName());
            int rs=preparedStatement.executeUpdate();
            if (rs>=1) {
                System.out.println(rs);
                System.out.printf("update successed");
                return true;

            }else{
                System.out.printf("update failure");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


}
