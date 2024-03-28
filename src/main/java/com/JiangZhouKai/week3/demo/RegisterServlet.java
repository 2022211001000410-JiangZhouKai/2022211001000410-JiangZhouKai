package com.JiangZhouKai.week3.demo;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")

public class RegisterServlet<set, OrderList> extends HttpServlet {

    Connection con = null;

    @Override
    public void init() throws ServletException {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost;databaseName=userdb;";
        String username = "sa";
        String password = "jiang123456";


        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id1="1";
//        String username1 = "JiangZhouKai";
//        String password1 = "2022211001000410";
//        String email1 = "123@qq.com";
//        String gender1 = "male";
//        String birthdate1 = "1212-12-12";
//
//        try {
//            SET IDENTITY_INSERT [ database.[ owner.] ] { table } { ON | OFF }
//            set identity_insert userdb ON;
//            PreparedStatement stmt = con.prepareStatement("insert into usertable(id,username,password,email,gender,birthdate)  values(?,?,?,?,?,?)");
//            stmt.setString(1, id1);
//            stmt.setString(2, username1);
//            stmt.setString(3, password1);
//            stmt.setString(4, email1);
//            stmt.setString(5, gender1);
//            stmt.setString(6, birthdate1);
//
//            stmt.executeUpdate();
//            con.commit();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        String str = "select * from usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(str);
            try {
                PrintWriter writer = response.getWriter();
                writer.println("<html><head><meta charset=\"UTF-8\"><title>User Information</title></head><body>");
                writer.println("<table border='1'>");
                writer.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
                while (rs.next()) {
                    String id = rs.getString("id");
                    String username = ((ResultSet) rs).getString("username");
                    String password = rs.getString("password");
                    String email = rs.getString("email");
                    String gender = rs.getString("gender");
                    String birthdate = rs.getString("birthdate");
                    writer.println("<tr>");
                    writer.println("<td>" + id + "</td>");
                    writer.println("<td>" + username + "</td>");
                    writer.println("<td>" + password + "</td>");
                    writer.println("<td>" + email + "</td>");
                    writer.println("<td>" + gender + "</td>");
                    writer.println("<td>" + birthdate + "</td>");
                    writer.println("</tr>");
                }
                writer.println("</table>");
                writer.println("</body></html>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    public void destroy() {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}