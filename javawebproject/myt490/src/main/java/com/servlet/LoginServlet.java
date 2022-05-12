package com.servlet;
//导入数据库数据操作包中所有的类
import com.dao.*;
//导入服务连接器中的所有的类
import javax.servlet.*;
//导入服务连接器中http包的所有的类
import javax.servlet.http.*;
//导入IO包中的IO异常类
import java.io.IOException;

//登陆验证类继承了 HTTP通信协议(一个无状态协议)的HttpServlet类。
public class LoginServlet extends HttpServlet {
    /*
     *利用get方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求传回doGet方法
        doPost(request, response);
    }


    /*
    *利用post方式
    * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
    *HttpServletResponse对象生成响应结果
    * */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpServletRequest
        //创建字符串变量，初始化为前端页面传来的数据，指定接收name为name和pwd标签的数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao = new UserDaolmpl();
        //判断通过数据操作类中login方法判断登陆页面传来的数据是否与数据库中的数据匹配
        //login方法具体在dao包中UserDaolmpl类查看
        if (userDao.login(name, pwd)) {
            //返回前端页面的信息，第一个参数与success.jsp中的${name}是匹配的，数据是通过这个表达示传递
            request.setAttribute("name", name + "登陆成功");
            //使用请求转发，跳转到success.jsp登陆成功页面显示
            request.getRequestDispatcher("success.jsp").forward(request, response);
        //如果不正确
        } else {
            //跳转到error.jsp错误页面
            response.sendRedirect("error.jsp");
        }
    }
}
