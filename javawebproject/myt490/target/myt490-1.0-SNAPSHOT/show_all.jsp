<%--
  Created by IntelliJ IDEA.
  User: 23711
  Date: 2022/5/1
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 导入C标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <!-- 头部标题 -->
    <title>所有用户信息</title>
</head>
<body>
<!-- 主要内容 -->
<!-- 创建一个容器包含的是一个返回首页的超链接 -->
<div>
    <a href="login.jsp">返回首页</a>
</div>

<!--
定义一个表格布局，宽600，边框宽度1,单元格间距0，样式设置为海蓝色,所有元素居中
-->
<table width="600" border="1" cellpadding="0" style="background-color: aqua;margin: 0 auto">
    <!-- 表头创建,定义一行 -->
    <tr>
        <!-- 行中的表头名称 -->
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>密码</th>
        <th>家乡</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    <!-- c标签输出List中的元素 users对应ScarchAllServlet中传来的list,重命名为U,输出为键值方式 -->
    <c:forEach items="${users}" var="U" >
        <!-- 创建表单，指定数据是通过post方式传递到UpdateServlet进行处理  -->
        <form action="UpdateServlet" method="post">
            <!-- 表中的一行 -->
            <tr>
                <!-- 每个单元格,单元格格可输入文本，初始化打印U列表中的每个对应键的值  -->
                <td><input type="text" value="${U.id}" name="id"></td>
                <td><input type="text" value="${U.name}" name="name"></td>
                <td><input type="text" value="${U.sex}" name="sex"></td>
                <td><input type="text" value="${U.pwd}" name="pwd"></td>
                <td><input type="text" value="${U.home}" name="home"></td>
                <td><input type="text" value="${U.info}" name="info"></td>
                <!-- 一行中最后的是两个对一行数据进行的功能
                 对表中行进行删除，通过行中的id传递到DeleteServlet进行处理
                 一个按钮，将一行中的数据传递到UpdateServlet进行处理
                 -->
                <td><a href="DeleteServlet?id=${U.id}">删除</a> <input type="submit" value="更新"/></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>
