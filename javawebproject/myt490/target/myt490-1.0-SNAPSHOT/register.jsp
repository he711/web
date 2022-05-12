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
    <title>注册</title>
</head>
<body>
<!-- 主要内容 -->
<!-- 创建一个容器，背影颜色浅蓝色，宽300像素，高330像素，所有元素居中 -->
<div style="background-color: aquamarine;width: 300px;height: 330px;margin: auto">
    <!-- 居中的标题3 -->
    <h3 style="text-align: center">Register</h3>
    <!-- 创建表单元素上内边距-700像素，通过post方式将数据传递到RegisterServlet处理 -->
    <form action="RegisterServlet" method="post" style="padding-top:-700px;">
        <!-- 容器样式高为40像素,上为0下为15像素 -->
        <div style="height: 40px;padding: 0 15px">
            <!-- 帐号输入框输入明文，不允许空,数据传递到name字段 -->
            账 号:<input name="name" type="text" required>
        </div>

        <div style="height: 40px;padding: 0 15px">
            <!-- 密码输入框输入密文，不允许空,数据传递到pwd字段 -->
            密 码:<input name="pwd" type="password" required>
        </div>
        <div style="height: 40px;padding: 0 15px">
            <!-- 两个单选按钮，默认选择男，数据传递到sex字段 -->
            性 别:<input type="radio" name="sex" value="男" checked>男
            <input type="radio" name="sex" value="女">女<br>
        </div>
        <div style="height: 40px;padding: 0 15px">
            <!-- 下拉框，默认选择选择北京，数据传递到home字段 -->
            家 乡:
            <select name="home">
                <option value="上海">上海</option>
                <option value="北京" selected>北京</option>
                <option value="纽约">纽约</option>
            </select>
        </div>
        <div style="height: 70px;padding: 0 15px">
            <!-- 文本框框，元素的输入文本的行数5，文本域的可视宽度30，数据传递到info字段 -->
            个人信息:<br>
            <textarea name="info" row="5" cols="30"></textarea>
            <br>
        </div>
        <div style="height: 40px;padding: 0 15px">
            <!-- 清空所有单元格的按钮，宽120像素 -->
            <input type="reset" value="重置" style="width: 120px">
            <!-- 将表格数据传递到RegisterServlet处理的按钮，宽120像素 -->
            <input type="submit" value="注册" style="width: 120px">
        </div>
    </form>
</div>
</body>
</html>
