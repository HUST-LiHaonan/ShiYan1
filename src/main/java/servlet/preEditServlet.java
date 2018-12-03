/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: preEditServlet
 * Author:   mac
 * Date:     2018/11/26 9:30 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;

import beans.Student;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/26
 * @since 1.0.0
 */
@WebServlet("/preEditServlet")
public class preEditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        HttpSession session = req.getSession();
        Student student = new StudentDao().findStudent(id);
        session.setAttribute("preEdit",student);
        resp.sendRedirect("edit.jsp");
    }
}

