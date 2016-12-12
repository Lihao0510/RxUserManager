package com.lihao.nimatest.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by lihao on 2016/12/12.
 */
@WebServlet(name = "updateservlet", urlPatterns = {"/updateservlet"})
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String sql = "UPDATE careers SET name ='" + username + "', age =" + age + ",sex='" + sex + "' WHERE id = " + id;
        System.out.println(sql);
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lihaotest?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull","root","55637179q");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            writer.println("修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("修改失败!");
        }
    }

}
