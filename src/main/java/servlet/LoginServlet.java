/**
 * Copyright (C), 2016-2018, 李浩楠
 * FileName: LoginServlet
 * Author:   mac
 * Date:     2018/11/20 11:44 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package servlet;

import beans.Admin;
import beans.Student;
import dao.AdminDao;
import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        //获取账号密码
        String id = req.getParameter("id");
        String psd = req.getParameter("psd");
        //数据库操作
        StudentDao studentDao = new StudentDao();
        AdminDao adminDao = new AdminDao();
        PrintWriter out = resp.getWriter();
        //获取登录类型
        String type = req.getParameter("type");
        //普通用户登录
        if (type.equals("student")) {
            Student student = studentDao.findStudent(id,psd);
            if (student!=null) {
                //设置session
                session.setAttribute("student", student);
                //跳转
                resp.sendRedirect("test.jsp");
            } else {
                if (studentDao.isIdExists(id)) {
                    session.setAttribute("err", "密码错误！");
                    resp.sendRedirect("index.jsp");
                } else {
                    session.setAttribute("err", "用户名错误");
                    resp.sendRedirect("index.jsp");
                }
            }
        }
        //管理员登录
        else {
            if (adminDao.findAdmin(id, psd)) {
                //定义对象
                Admin admin = new Admin();
                admin.setUsername(id);
                admin.setPsd(psd);
                //设置session
                session.setAttribute("admin", admin);
                //跳转
                resp.sendRedirect("admin_page.jsp");
            } else {
                if (adminDao.isAdminExists(id)) {
                    session.setAttribute("err", "密码错误！");
                    resp.sendRedirect("index.jsp");
                } else {
                    session.setAttribute("err", "用户名错误");
                    resp.sendRedirect("index.jsp");
                }
            }
        }
    }
}

