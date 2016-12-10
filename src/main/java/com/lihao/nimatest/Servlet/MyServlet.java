package com.lihao.nimatest.Servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by lihao on 2016/12/9.
 */
@WebServlet(name = "myservlet", urlPatterns = {"/myservlet"})
public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("username");
        //PrintStream out = new PrintStream(resp.getOutputStream());
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lihaotest","root","55637179q");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM careers WHERE id=" + id);
            while (rs.next()){
                Map<String,String> params = new LinkedHashMap<String, String>();
                params.put("id",rs.getString("id"));
                params.put("name",rs.getString("name"));
                params.put("age",rs.getString("age"));
                params.put("sex",rs.getString("sex"));
                Gson paramGson = new Gson();
                String personInfo = paramGson.toJson(params);
                System.out.println(personInfo);
                writer.println(personInfo);
                return;
            }
            writer.println("没有该号码对应的信息!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
