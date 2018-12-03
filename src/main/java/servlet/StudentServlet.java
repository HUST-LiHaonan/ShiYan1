/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: StudentServlet
 * Author:   mac
 * Date:     2018/11/26 8:59 PM
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
import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/26
 * @since 1.0.0
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> studentArrayList = studentDao.findAll();
        session.setAttribute("studentArrayList",studentArrayList);
        resp.sendRedirect("student_managenment.jsp");
    }
}

