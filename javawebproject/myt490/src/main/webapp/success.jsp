<%--
  Created by IntelliJ IDEA.
  User: 23711
  Date: 2022/5/1
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 头部标题 -->
    <title>成功</title>
</head>
<body>
    <!-- 使用el表达式获取request域里的属性 -->
    ${name}
    <br> <!-- 换行 -->
    <!-- 点击超链接跳转到SearchAllServlet显示所有用户的页面 -->
    <a href="SearchAllServlet" method="post">显示所有用户</a>
</body>
</html>
