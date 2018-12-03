/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: SubmitServlet
 * Author:   mac
 * Date:     2018/11/20 6:13 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;

import beans.Score;
import beans.Student;
import dao.ScoreDao;

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
 * @create 2018/11/20
 * @since 1.0.0
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        int score = 0;
        String q1 = req.getParameter("q1");
        String q2 = req.getParameter("q2");
        String[] q3 = req.getParameterValues("q3");

        if (q1 != null && q1.equals("武汉")) {
            score += 10;
        }
        if (q2 != null && q2.equals("赵匡胤")) {
            score += 10;
        }
        if (q3 != null && q3.length == 2 && q3[0].equals("红楼梦") && q3[1].equals("水浒传")) {
            score += 10;
        }

        Student student =(Student)session.getAttribute("student");
        Score newscore = new Score();
        newscore.setId(student.getId());
        newscore.setScore(score);
        ScoreDao scoreDao = new ScoreDao();

        if (scoreDao.updateScore(newscore)) {
            session.invalidate();
            out.print("<script language='javascript'>alert('提交成功');" +
                    "window.location.href='index.jsp';</script>");
        } else {
            out.print("<script language='javascript'>alert('提交失败');" +
                    "window.location.href='index.jsp';</script>");
        }
    }
}

