/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: RegisterServlet
 * Author:   mac
 * Date:     2018/11/20 7:39 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;

import beans.Score;
import beans.Student;
import dao.ScoreDao;
import dao.StudentDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author mac
 * @create 2018/11/20
 * @since 1.0.0
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String psd = req.getParameter("psd");
        Student student = new Student();
        PrintWriter out = resp.getWriter();
        student.setId(id);;
        student.setName(name);
        student.setPsd(psd);
        Score score = new Score();
        score.setId(id);

        StudentDao studentDao = new StudentDao();
        ScoreDao scoreDao = new ScoreDao();
        if(studentDao.addStudent(student)&&scoreDao.addScore(score)){
            out.print("<script language='javascript'>alert('注册成功');" +
                    "window.location.href='index.jsp';</script>");
        }
        else {
            out.print("<script language='javascript'>alert('用户名已经存在!');" +
                    "window.location.href='index.jsp';</script>");
        }
    }
}

