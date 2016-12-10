package com.lihao.nimatest.DataBase;

import java.sql.*;

/**
 * Created by lihao on 2016/12/10.
 */
public class DatabaseDao {

    private Connection conn;
    private String driver;
    private String url;
    private String userName;
    private String passWord;

    public DatabaseDao(){

    }

    public DatabaseDao(String driver,String url,String userName,String passWord){
        this.driver = driver;
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (conn == null){
            Class.forName(driver);
            conn = DriverManager.getConnection(url,userName,passWord);
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        if(conn != null&&!conn.isClosed()){
            conn.close();
        }
    }

    public boolean insert(String sql, Object... objects) throws Exception{
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i + 1, objects[i]);
        }
        if(ps.executeUpdate()!=1){
            return false;
        }
        return true;
    }

    public ResultSet query(String sql, Object... objects) throws Exception{
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i+1,objects[i]);
        }
        return ps.executeQuery();
    }

    public void update(String sql, Object... objects) throws Exception{
        PreparedStatement ps = getConnection().prepareStatement(sql);
        for (int i = 0; i < objects.length; i++) {
            ps.setObject(i+1,objects[i]);
        }
        ps.executeUpdate();
        ps.close();
    }

    public void delete(String sql, Object... objects) throws Exception{

    }
}
