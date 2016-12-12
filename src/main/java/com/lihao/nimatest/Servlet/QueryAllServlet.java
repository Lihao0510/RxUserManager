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
 * Created by lihao on 2016/12/12.
 */
@WebServlet(name = "queryallservlet", urlPatterns = {"/queryallservlet"})
public class QueryAllServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lihaotest","root","55637179q");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM careers");
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
            writer.println("查询出错!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
