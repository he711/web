package com.servlet;

//导入数据库数据操作包中所有的类
import com.dao.*;
//导入实体类
import com.entiy.User;

//导入服务连接器中的所有的类
import javax.servlet.*;
//导入服务连接器中http包的所有的类
import javax.servlet.http.*;
//导入IO包中的IO异常类
import java.io.IOException;
//导入java中的列表类
import java.util.List;

//显示所有类继承了 HTTP通信协议(一个无状态协议)的HttpServlet类。
public class SearchAllServlet extends HttpServlet {
    /*
     *利用get方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求传回doGet方法
        //doGet(request, response);
        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao= new UserDaolmpl();
        //新建列表对象赋值为数据库中查询到的数据
        List<User> list = userDao.searchAll();
        //HttpServletRequest
        //返回前端页面的信息，第一个参数与showall.jsp中的${list}是匹配的，数据是通过这个表达示传递
        request.setAttribute("users", list);
        //使用请求转发，跳转到showAll.jsp登陆成功页面显示
        request.getRequestDispatcher("show_all.jsp").forward(request, response);
    }

    /*
     *利用post方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao= new UserDaolmpl();
        //新建列表对象赋值为数据库中查询到的数据
        List<User> list = userDao.searchAll();
        //HttpServletRequest
        //返回前端页面的信息，第一个参数与showall.jsp中的${list}是匹配的，数据是通过这个表达示传递
        req.setAttribute("users", list);
        //使用请求转发，跳转到showAll.jsp登陆成功页面显示
        req.getRequestDispatcher("show_all.jsp").forward(req, resp);

    }
}
