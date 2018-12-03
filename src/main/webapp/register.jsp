<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/20
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <center>
    <form action="RegisterServlet" method="post">
        学号：<input type="text" name="id"/><br>
        姓名:<input type="text" name="name"/><br>
        密码:<input type="password" name="psd"/>
        <br><br>
        <button type="submit">注册</button>
        <button type="reset">重填</button>
    </form>
        <br><a href="index.jsp">返回</a>
    </center>
</body>
</html>
