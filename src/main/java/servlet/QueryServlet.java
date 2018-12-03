/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: QueryServlet
 * Author:   mac
 * Date:     2018/11/26 5:55 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;

import beans.ScoreList;
import dao.ListDao;

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
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String s_low = req.getParameter("low");
        String s_high = req.getParameter("high");

        HttpSession session = req.getSession();
        session.removeAttribute("scoreLists");


        //按照名字查询
        if (!name.equals("") && s_low.equals("") && s_high.equals("")) {
            ArrayList <ScoreList> scoreLists = new ListDao().find(name);
            session.setAttribute("scoreLists", scoreLists);
            resp.sendRedirect("score_management.jsp");
        }
        //按照分数段查询
        else if (name.equals("") && !s_low.equals("") && !s_high.equals("")) {
            int low = Integer.parseInt(s_low);
            int high = Integer.parseInt(s_high);
            ArrayList <ScoreList> scoreLists = new ListDao().find(low, high);
            session.setAttribute("scoreLists", scoreLists);
            resp.sendRedirect("score_management.jsp");
        } else if (!name.equals("") && !s_low.equals("") && !s_high.equals("")) {
            int low = Integer.parseInt(s_low);
            int high = Integer.parseInt(s_high);
            ArrayList <ScoreList> scoreLists = new ListDao().find(name, low, high);
            session.setAttribute("scoreLists", scoreLists);
            resp.sendRedirect("score_management.jsp");
        } else {
            ArrayList <ScoreList> scoreLists = new ListDao().findAll();
            session.setAttribute("scoreLists", scoreLists);
            resp.sendRedirect("score_management.jsp");
        }

    }
}

