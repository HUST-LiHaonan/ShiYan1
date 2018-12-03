<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/13
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>

<%!int pageCount = 0;%>
<% if(session.isNew())
    pageCount++;
%>
<center>
    <p>Copyright 李浩楠 2018 | 访问次数：<%=pageCount%></p>
</center>
</body>


</html>
