package com.dao;

//导入实体类
import com.entiy.User;
//导入数据库工具类
import com.util.DBCoon;
//导入数据库连接操作包
import java.sql.*;
//导入java列表类
import java.util.List;
//导入java动态列表，与普通列表的区别就是它是没有固定大小的限制，可以添加或删除元素。
import java.util.ArrayList;

/*
 * @author 23711
 */ //实现数据库数据操作接口的类
public class UserDaolmpl implements UserDao {
    //定义一个全局静态的布尔类型变量，初始化为false假,标志验证
    static boolean flag = false;
    //定义一个全局静态的字符串类型变量，用来定义所需的sql语句
    static String sql = null;

    //实现获取前端登陆页面输入的用户名与密码验证密码,验证结果返回布尔类型
    //验证登陆
    @Override
    public boolean login(String name, String pwd) {
        //捕抓异常
        try {
            //连接数据库（具体看DBCoon类中的代码）
            DBCoon.init();
            //定义SQL语句：查询user表中数据，根据name字段与pwd字段查询行
            sql = "select * from user where name = ? and pwd = ?";

            //定义一个局部列表（可保存任何类型），赋值形参获取的变量数据
            Object[] args = {name, pwd};

            //声名一个保存数据库数据的对象，赋值为数据库中查询数据方法赋值sql语句与查询条件列表后的返回值
            //保存sql语句查询数据库后的所有数据
            ResultSet rs = DBCoon.searchSql(sql, args);

            //遍历数据库中获得的数据
            while (rs.next()) {
                //判断获得的数据中是否与参数变量name和pwd中的数据一样
                if (rs.getString("name").equals(name) && rs.getString("pwd").equals(pwd)) {
                    //一样时标志变量赋值为true真
                    flag = true;
                }
            }
        //抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        //最后
        } finally {
            //关闭流
            DBCoon.close();
        }
        //返回标志变量的值
        return flag;
    }

    //实现获取注册页面输入的数据，封装成User对象，返回的结果为布尔类型
    //注册
    @Override
    public boolean register(User user) {
        //捕抓异常
        try {
            //连接数据库
            DBCoon.init();
            //定义sql语句,向user表中的name,pwd,sex,home,info字段中插入数据
            sql = "INSERT INTO user(name, pwd, sex, home, info) values(?, ?, ?, ?, ?)";
            //定义一个局部列表，赋值形参对象中的数据
            Object[] args = {user.getName(), user.getPwd(), user.getSex(), user.getHome(), user.getInfo()};
            //定义一个整数据变量，初始化为数据库sql执行后指受影响的行数（返回一个整数），返回0为执行失败
            int i = DBCoon.addUpdateDelete(sql, args);
            //判断变量的值大于0时
            if (i > 0) {
                //标志变量更新为true真
                flag = true;
            }
        //抛出异常
        } catch (Exception e){
            e.printStackTrace();
        //最后
        } finally {
            //关闭流
            DBCoon.close();
        }
        //返回标志变量的值
        return flag;
    }

    //实现获取数据库中user表中所有数据，返回一个列表
    //获取表中所有数据
    @Override
    public List<User> searchAll() {
        //定义一个动态列表，就是不限长度的
        List<User> list = new ArrayList<>();
        //捕抓异常
        try {
            //连接数据库
            DBCoon.init();
            //定义sql语句,查询user表中的所有数据
            sql = "select * from user";
            //声名一个保存数据库中查询到所有的数据的对象，赋值的是数据库执行sql语句中查询到的数据
            ResultSet rs = DBCoon.getUsers(sql);
            //数据库中保存的数据通过User实体类实例化后依次循环添加到动态列表中
            while (rs.next()) {
                //创建一个实体类对象
                User user = new User();
                //实例化数据库中获取的数据
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setHome(rs.getString("home"));
                user.setInfo(rs.getString("info"));
                //数据添加动态列表中,对象user包含了实例化后的数据
                list.add(user);
            }
        //抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        //最后
        } finally {
            //关闭流
            DBCoon.close();
        }
        //返回保存数据后的动态列表
        return list;
    }

    //实现根据显示所有用户页面中对应输入的内容更新用户信息
    //更新数据表
    @Override
    public boolean update(int id, String name, String pwd, String sex, String home, String info) {
        // 捕抓异常
        try {
            //连接数据库
            DBCoon.init();
            //定义sql语句,更新user表中的name,pwd,sex,hoe,info字段的数据，根据id来操作
            sql = "update user set name=?, pwd=?, sex=?, home=?, info=? where id=?";
            //定义一个局部列表，赋值形参获取的变量数据
            Object[] args = {name, pwd, sex, home, info, id};
            //定义一个整数据变量，初始化为数据库sql执行后指受影响的行数（返回一个整数），返回0为执行失败
            int i = DBCoon.addUpdateDelete(sql, args);
            //判断变量i的值大于0时，执行以下语句
            if (i > 0) {
                //标志变量更新为true真
                flag = true;
            }
        //抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        // 最后
        } finally {
            //关闭流
            DBCoon.close();
        }
        // 返回标志变量的值
        return flag;
    }

    //实现根据显示所有用户页面中选中的id删除指定的用户，返回布尔类型
    //删除表中的数据
    @Override
    public boolean delete(int id) {
        //捕抓异常
        try {
            //连接数据库
            DBCoon.init();
            //定义sql语句,删除user表中指定id的一行数据
            sql = "delete from user where id = ?";
            //定义一个局部列表，赋值形参获取的变量数据
            Object[] args = {id};
            //定义一个整数据变量，初始化为数据库sql执行后指受影响的行数（返回一个整数），返回0为执行失败
            int i = DBCoon.addUpdateDelete(sql, args);
            //判断变量i的值大于0时，执行以下语句
            if (i > 0) {
                //标志变量更新为true真
                flag = true;
            }
        // 抛出异常
        } catch (Exception e) {
            e.printStackTrace();
        // 最后
        } finally {
            //关闭流
            DBCoon.close();
        }
        //返回标志变量的值
        return flag;
    }
}
