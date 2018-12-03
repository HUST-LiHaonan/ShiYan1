<%@ page import="beans.Student" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/26
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    Student student = (Student) session.getAttribute("preEdit");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑学生</title>
</head>
<body>
<form action="EditServlet" method="post">
    学号:<input type="text" value="<%=student.getId()%>" name="id"><br>
    姓名:<input type="text" value="<%=student.getName()%>" name="name"><br>
    密码:<input type="text" value="<%=student.getPsd()%>" name="psd"><br>
    <input type="submit" value="修改">
    <input type="reset" value="重置">
    <br>
</form>
<%
    String msg= (String)session.getAttribute("msg");
    if(msg!=null){
        out.print("<div style='color:red;'>"+msg+"</div>");
        session.removeAttribute("err");//用完后清除掉
    }
%>
<a href="student_managenment.jsp">返回</a>
</body>
</html>
