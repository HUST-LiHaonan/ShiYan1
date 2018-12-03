<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/13
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<center>
    <form action="LoginServlet" method="post">
        学号<input type="text" name="id"/>
        <br>
        密码<input type="password" name="psd"/>
        <br>
        <input type="radio" name="type" checked="checked" value="student"/>学生
        <input type="radio" name="type" value="admin"/>管理员
        <br>
        <%
            String err= (String)session.getAttribute("err");
            if(err!=null){
                out.print("<div style='color:red;'>"+err+"</div>");
                session.removeAttribute("err");//用完后清除掉
            }
        %>
        <button type="submit">登录</button>
        <button type="reset">重填</button>
    </form>
</center>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
