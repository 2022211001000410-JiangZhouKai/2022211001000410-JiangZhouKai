package com.JiangZhouKai.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//use @webservlet - no wb.xml code
@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost;databaseName=userdb;"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="jiang123456"),
        },loadOnStartup = 1
)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null; //class variabke
    @Override
    public void init() throws ServletException {
    //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
        //String url="jdbc:sqlserver://localhost;databaseName=userdb;";
        //String username="sa";
        //String password="jiang123456";
        //code like this is bad way --- because chjange in not easy
        //for example change password of da - change in java code

        //get servletconfig --> getInitParmeters
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");// <param-name>driver</param-name>
        String url=config.getInitParameter("url");//param-name>url</param-name>
        String username=config.getInitParameter("username");//<param-name>username</param-name>
        String password=config.getInitParameter("password");//<param-name>password</param-name>



        try {
            Class.forName(driver);
             con=DriverManager.getConnection(url,username,password);
            System.out.println("init()"+con);// ok(java code)- ok(use config-in web.xml) -- ok - use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // connection within do get-- many times - bad way
        System.out.println("i am in doGet()");// ok- ok
        //we need to use con within doget
        String sql="select * from usertable";
        try {
            ResultSet rs= con.createStatement().executeQuery(sql);
            while (rs.next()){
                //get from rs - print - write into response
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

