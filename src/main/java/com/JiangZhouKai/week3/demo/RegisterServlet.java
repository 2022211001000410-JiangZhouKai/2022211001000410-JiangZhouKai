package com.JiangZhouKai.week3.demo;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UserName =request.getParameter("UserName");
        String ID =request.getParameter("ID");
        String Email =request.getParameter("Email");
        String gender =request.getParameter("gender");
        String birthDate =request.getParameter("birthDate");

        PrintWriter writer = response.getWriter();
        writer.println("<br>UserName:"+UserName);
        writer.println("<br>ID:"+ID);
        writer.println("<br>Email:"+Email);
        writer.println("<br>gender:"+gender);
        writer.println("<br> birth Date:"+birthDate);
        writer.close();
    }

}
