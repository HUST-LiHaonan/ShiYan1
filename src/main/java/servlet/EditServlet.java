/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: EditServlet
 * Author:   mac
 * Date:     2018/11/26 9:50 PM
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
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        StudentDao studentDao = new StudentDao();
        Student old_student = (Student) session.getAttribute("preEdit");
        Student new_student = new Student();
        new_student.setId(req.getParameter("id"));
        new_student.setName(req.getParameter("name"));
        new_student.setPsd(req.getParameter("psd"));
        boolean flag = false;
        PrintWriter out = resp.getWriter();

        //不更改学号
        if(old_student.getId().equals(new_student.getId())){
            flag=studentDao.updateStudent(new_student,new_student.getId());
        }
        //修改学号
        else {
            flag=studentDao.deleteStudent(old_student)&&studentDao.addStudent(new_student);
        }

        if(flag==false){
            String msg = "修改错误!";
            session.setAttribute("msg",msg);
            resp.sendRedirect("edit.jsp");
        }else {
            ArrayList<Student> studentArrayList = new StudentDao().findAll();
            session.removeAttribute("studentArrayList");
            session.setAttribute("studentArrayList",studentArrayList);
            out.print("<script language='javascript'>alert('修改成功');" +
                    "window.location.href='student_managenment.jsp';</script>");
        }
    }
}

