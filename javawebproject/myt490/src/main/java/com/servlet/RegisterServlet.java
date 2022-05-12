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

/**
 * @author 23711
 */
//注册类继承了 HTTP通信协议(一个无状态协议)的HttpServlet类。
public class RegisterServlet extends HttpServlet{
    /*
     *利用get方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /*
     *利用post方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpServletRequest
        //创建字符串变量，初始化为前端页面传来的数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");

        //声名一个实体类对象
        User user = new User();

        //实例化前端传递过来的数据
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(sex);
        user.setHome(home);
        user.setInfo(info);

        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao = new UserDaolmpl();
        //判断通过数据操作类中register方法判断数据数据插入数据库user表中是否成功
        if (userDao.register(user)) {
            //返回前端页面的信息，第一个参数与success.jsp中的${name}是匹配的，数据是通过这个表达示传递
            req.setAttribute("name", name + "注册成功");
            //使用请求转发，跳转到success.jsp登陆成功页面显示
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        //如果不正确
        } else {
            //跳转到error.jsp错误页面
            resp.sendRedirect("error.jsp");
        }
    }
}
