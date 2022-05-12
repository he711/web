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

//更新用户信息类 继承了 HTTP通信协议(一个无状态协议)的HttpServlet类。
public class UpdateServlet extends HttpServlet{
    /*
     *利用get方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求传回doGet方法
        doGet(request, response);
    }

    /*
     *利用post方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //声明一个整数变量赋值为前端页面中返回的数据并转换数值类型
        int userId = Integer.parseInt(req.getParameter("id"));
        //创建字符串变量，初始化为前端页面传来的数据
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String home = req.getParameter("home");
        String info = req.getParameter("info");

        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao= new UserDaolmpl();

        //判断数据库的更新操作是否成功
        if (userDao.update(userId, name, pwd, sex, home, info)) {
            //更新成功转发到SearchAllServlet上
            req.getRequestDispatcher("SearchAllServlet").forward(req, resp);
        //如果失败
        } else {
            //跳转到错误页面
            resp.sendRedirect("error.jsp");
        }
    }
}
