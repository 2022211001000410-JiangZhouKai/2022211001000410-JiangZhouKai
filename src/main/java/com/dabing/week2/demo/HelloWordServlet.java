package com.dabing.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

//now its just a java class
//extend HttpServlet
public class HelloWordServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws IOException {
        //when client request method is GET - here - inside deGot()
        //we want to send Hello to client
        //we need to write Hello in respose
        // get writer - java .io
        PrintWriter writer = response.getWriter();
        writer.println("Name : Jiang Zhoukai");
        writer.println("ID : 2022211001000410");
        Date current = new Date();
        writer.println("Date and Time : " + current.toString());
        writer.close();

    }

}
