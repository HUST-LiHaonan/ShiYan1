/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: TestServlet
 * Author:   mac
 * Date:     2018/11/22 10:46 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;


import beans.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/22
 * @since 1.0.0
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        //登录后会设置session 没有登录则user为空 提示要登录
        Student student = (Student)session.getAttribute("student");
        if(student==null){
            out.print("<script language='javascript'>alert('你还没有登录');" +
                    "window.location.href='index.jsp';</script>");
        }
        else {
            resp.sendRedirect("test.jsp");
        }
    }
}

