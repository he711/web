package com.dao;

//导入实体类
import com.entiy.User;
//导入java的列表类
import  java.util.List;

/**
 * @author 23711
 */ //数据库数据操作接口
public interface UserDao {
    //获取前端登陆页面输入的用户名与密码验证密码,验证结果返回布尔类型
    public boolean login(String name, String pwd);

    //获取注册页面输入的数据，封装成User对象，返回的结果为布尔类型
    public boolean register(User user);

    //获取数据库中user表中所有数据，返回一个列表
    public List<User> searchAll();

    //根据显示所有用户页面中对应输入的内容更新用户信息
    public boolean update(int id, String name, String pwd, String sex, String home, String info);

    //根据显示所有用户页面中选中的id删除指定的用户，返回布尔类型
    public boolean delete(int id);

}
