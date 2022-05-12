package com.servlet;

//导入数据库数据操作包中所有的类
import com.dao.*;
import com.entiy.User;


//导入服务连接器中的所有的类
import javax.servlet.*;
//导入服务连接器中http包的所有的类
import javax.servlet.http.*;
//导入IO包中的IO异常类
import java.io.IOException;
import java.util.List;

//删除操作类继承了 HTTP通信协议(一个无状态协议)的HttpServlet类。
public class DeleteServlet extends HttpServlet {
    /*
     *利用get方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //请求传回doGet方法
//        doGet(request, response);
        //声明一个整数变量赋值为前端页面中返回的数据并转换数值类型
        int userID = Integer.parseInt(request.getParameter("id"));

        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao= new UserDaolmpl();

        //判断数据库操作是否成功
        if (userDao.delete(userID)) {
            //删除成功转发到SearchAllServlet上
            request.getRequestDispatcher("SearchAllServlet").forward(request, response);
            //如果失败
        } else {
            //跳转到错误页面
            response.sendRedirect("error.jsp");
        }
    }

    /*
     *利用post方式
     * HttpServletRequest检索HTML表单所提交的数据或URL上的查询字符串
     *HttpServletResponse对象生成响应结果
     * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //声明一个整数变量赋值为前端页面中返回的数据并转换数值类型
        int userID = Integer.parseInt(req.getParameter("id"));

        //采用接口回调新建一个数据库数据操作对象
        UserDao userDao= new UserDaolmpl();

        //判断数据库操作是否成功
        if (userDao.delete(userID)) {
            //删除成功转发到SearchAllServlet上
            req.getRequestDispatcher("SearchAllServlet").forward(req, resp);
        //如果失败
        } else {
            //跳转到错误页面
            resp.sendRedirect("error.jsp");
        }
    }
}
