<%--
  Created by IntelliJ IDEA.
  User: 23711
  Date: 2022/4/30
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML声名 -->
<html>
<!-- 头部信息 -->
<head>
    <!-- 页面标题 -->
    <title>登陆</title>
</head>
<!-- 主要内容 -->
<body>
    <!--
    定义一个容器
    背影颜色白色
    宽300像素高200像素
    设置文本等一些内联对像居中
    设置块元素（或与之类似的元素）的居中
     -->
    <div style="background-color: aliceblue;width: 300px; height: 200px; text-align: center; margin: auto">
        <!-- 标题3 -->
        <h3>登陆</h3>
        <!--
        创建表单
        当提交表单时向后端的LoginServlet发送数据
        发送的方式post提交数据
        并使表单居中
        -->
        <form action="LoginServlet" method="post" style="margin: 0 auto;">
            <!-- 帐号输入设置明文输入，标签名称为name -->
            帐号:<input type="text" name="name"><br><br>
            <!-- 密码输入设置密文输入，标签名称为pwd-->
            密码:<input type="password" name="pwd"><br><br>
            <!-- 创建一个重置按钮，用于清空所有的输入,宽100象素 -->
            <input type="reset" value="重置" style="width: 100px">
            <!-- 创建一个登陆按钮，用于将输入的数据传送到后端认证,宽100象素 -->
            <input type="submit" value="登陆" name="" style="width: 100px">
        <br>
        </form>
    <br>
        <!-- 超链接点击跳转到register.jsp页面 -->
        <a href="register.jsp">新用户注册</a>
    </div>
</body>
</html>
