package com.filter;

//导入服务连接器包中的所有类
import javax.servlet.*;
//导入IO包中的IO异常类
import java.io.IOException;

//实现Filter接口的过滤器，过滤所有页面解决乱码问题
public class EncodingFilter implements Filter {
    //执行过滤器
    public EncodingFilter(){}

    //初始化:web服务器启动，就已经初始化了，随时等待过滤对象出现
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    //拦截请求并过滤
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //指定服务器响应给浏览器的编码utf-8
        request.setCharacterEncoding("utf-8");
        //指定服务器响应给浏览器的文件编码utf-8
        response.setContentType("text/html;charset=UTF-8");
        //把请求传回过滤链
        chain.doFilter(request, response);
    }

    //释放过滤器占用的资源
    @Override
    public void destroy() {}
}
