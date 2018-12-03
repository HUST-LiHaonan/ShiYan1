<%@ page import="beans.ScoreList" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2018/11/26
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取成绩表单
    ArrayList <ScoreList> scoreLists = (ArrayList <ScoreList>) session.getAttribute("scoreLists");
%>
<html>
<head>
    <title>成绩查询</title>
</head>
<body>
<center>
    <h1>成绩单</h1>
</center>
<table border="1" width="70%" align="center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩 <a href="AscendServlet">升序</a> <a href="DescendServlet">降序</a></th>
    </tr>
    <%
        for (int i = 0; i < scoreLists.size(); i++) {
            ScoreList score = scoreLists.get(i);
    %>
    <tr>
        <td><%=score.getId()%>
        </td>
        <td><%=score.getName()%>
        </td>
        <td><%=score.getScore()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<center>
    <form action="QueryServlet" method="post" title="查询">
        <p>
            按名称查询：<input type="text" name="name">
        </p>
        <p>
            按成绩区间查询:<input type="text" name="low">
            -
            <input type="text" name="high">
        </p>
        <button type="submit">查询</button>
        <button type="reset">重置</button>
    </form>
    <br>
    <a href="admin_page.jsp">返回</a>
</center>
</body>
</html>
