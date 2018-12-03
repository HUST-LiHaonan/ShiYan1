<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/26
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList <Student> studentArrayList = (ArrayList <Student>) session.getAttribute("studentArrayList");
%>
<html>
<head>
    <title>学生管理</title>
</head>
<body>
<center>
    <h1>学生信息</h1>
</center>
<table border="1" width="70%" align="center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>密码</th>
        <th colspan="2">操作</th>
    </tr>
    <%
        for (int i = 0; i < studentArrayList.size(); i++) {
            Student student = studentArrayList.get(i);
    %>
    <tr>
        <td><%=student.getId()%>
        </td>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getPsd()%>
        </td>
        <td><a href="/preEditServlet?id=<%=student.getId()%>">编辑</a>
        </td>
        <td><a href="/DeleteServlet?id=<%=student.getId()%>" onclick="return confirm('确定删除吗？')">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<center>
    <a href="admin_page.jsp">返回</a>
</center>
</body>
</html>
