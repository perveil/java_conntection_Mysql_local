package com.company;

import com.company.dao.InfoDao;
import com.company.entity.Info;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Info info = new Info("叶子","as");
        Info info2=new Info("jack" ,"asdasd");
        InfoDao infoDao = new InfoDao();
        //infoDao.add(info);
//        infoDao.add(info2);
        infoDao.selectAll();
        //System.out.println(infoDao.find("王瑞睿"));
//        Info updateinfo=new Info("jack" ,"ruirui");
//        infoDao.update(updateinfo);

    }
}
//
//create table info(
//        `name` varchar(60) not null,
//        `password` varchar(60) not null
//)engine=InnoDB default charset=utf8;
// 建立表的时候必须指定编码的形式