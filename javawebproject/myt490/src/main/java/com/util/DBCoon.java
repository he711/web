package com.util;

//导入JDBC数据库连接api包中所有类
import java.sql.*;

/*
* 数据库工具类
* 连接数据库
* 增删改查
* 执行SQL语句关查询
* 关闭数据库流
* 都是static靜态的方法
* */
public class DBCoon {
    //连接数据库的参数，指定要连接的是mysql,本地端口为3306，数据库名object，并设置连接时区，指定编码格式为UTF-8
    static String url = "jdbc:mysql://127.0.0.1:3306/object?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
    static String userName = "root";    //连接用户名
    static String password = "hekang237";   //连接密码

    //用于数据库连接
    static Connection connection = null;

    //用于执行sql语句
    static PreparedStatement preparedStatement = null;

    //保存执行sql后获得的结果集
    static ResultSet resultSet = null;

    //连接数据库
    public static void init() {
        //可能发生异常的语句
        try {
            //加载mysql数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库,参数，用户名，密码
            connection = DriverManager.getConnection(url, userName, password);
        //抛出异常
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    //查询数据(执行的sql语句（定义的sql语句在UserDaolmpl类中）, 接收任何类型的数组)
    public static ResultSet searchSql(String sql, Object[] args) {
        //可能发生异常的语句
        try {
            //执行sql语句
            preparedStatement = connection.prepareStatement(sql);

            //根据形参数组的长度徧环
            for (int i = 0; i < args.length; i++) {
                //为sql语句占位符赋值实参
                preparedStatement.setObject(i + 1, args[i]);
            }
            //保存数据库获取的数据
            resultSet = preparedStatement.executeQuery();
            //抛出异常
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //方法返回数据库中获取的数据
        return resultSet;
    }

    //增删改查(执行的sql语句, 接收任何类型的数组)
    public static int addUpdateDelete(String sql, Object[] args){
        //定义返回值初值（用来验证是否操作成功只会保存0（失败）和0以上的数值（成功））
        int i = 0;
        //捕抓可能出现的异常
        try {
            //执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            //根据形参数组的长度徧环
            for (int j = 0; j < args.length; j++){
                //为sql语句占位符赋值实参
                preparedStatement.setObject(j + 1, args[j]);
            }
            //变量i的更新赋值为,sql执行后指受影响的行数（返回一个整数）
            i = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //方法的返回值为变量i
        return i;
    }


    //查询全部信息(执行的sql语句)
    //ResultSet：保存数据库获取的数据
    public static ResultSet getUsers(String sql){
        //捕抓可能出现的异常
        try {
            //执行sql语句
            preparedStatement = connection.prepareStatement(sql);
            //保存数据库获取的数据
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //方法返回数据库中获取的数据
        return resultSet;
    }


    //关闭流
    public static void close() {
        //捕抓可能的异常
        try {
            //关闭读取数据库数据的流
            if (resultSet != null) {
                resultSet.close();
            }
            //关闭进行数据库sql操作的流
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            //关闭数据库连接流
            if (connection != null){
                connection.close();
            }
        //抛出异常
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
