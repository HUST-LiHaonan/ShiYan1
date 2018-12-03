<%@ page import="beans.Student" %><%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/13
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在线测试</title>
<body>
<%
    Student student = (Student) session.getAttribute("student");
%>
欢迎:<%=student.getName()%>
<h3>在线测试题</h3>
<form action="SubmitServlet" method="post" onsubmit="return confirm('确定提交吗？')">
    第1题：湖北省会是
    <input type="text" name="q1"/>
    <br><br>
    第2题：宋朝开国皇帝是
    <br>
    <input type="radio" value="赵匡胤" name="q2">
    赵匡胤
    <input type="radio" value="朱元璋" name="q2">
    朱元璋
    <input type="radio" value="李渊" name="q2">
    李渊
    <br><br>
    第3题：四大名著有
    <br>
    <input type="checkbox" value="红楼梦" name="q3">
    红楼梦
    <input type="checkbox" value="水浒传" name="q3">
    水浒传
    <input type="checkbox" value="J2EE编程技术" name="q3">
    J2EE编程技术
    <br><br>
    <button type="submit">提交</button>
</form>


</body>
</html>
