/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: DeleteServlet
 * Author:   mac
 * Date:     2018/11/26 10:19 PM
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
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/26
 * @since 1.0.0
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.findStudent(req.getParameter("id"));
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        //删除成功
        if(studentDao.deleteStudent(student)){
            ArrayList<Student> studentArrayList = new StudentDao().findAll();
            session.removeAttribute("studentArrayList");
            session.setAttribute("studentArrayList",studentArrayList);
            out.print("<script language='javascript'>alert('删除成功');" +
                    "window.location.href='student_managenment.jsp';</script>");
        }
        else {
            ArrayList<Student> studentArrayList = new StudentDao().findAll();
            session.removeAttribute("studentArrayList");
            session.setAttribute("studentArrayList",studentArrayList);
            out.print("<script language='javascript'>alert('修改失败');" +
                    "window.location.href='student_managenment.jsp';</script>");
        }

    }
}

