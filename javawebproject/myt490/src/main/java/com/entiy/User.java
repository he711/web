package com.entiy;

//实体类
//对应数据库中的user表属性
public class User {
    //私有变量
    //整数据型变量
    public int id;
    //字符串型变量
    public String name;    //姓名
    public String pwd;     //密码
    public String sex;     //性别
    public String home;    //家乡
    public String info;    //备注

    //数据实例化
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    //获取数据
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public String getHome() {
        return home;
    }

    public String getInfo() {
        return info;
    }
}
