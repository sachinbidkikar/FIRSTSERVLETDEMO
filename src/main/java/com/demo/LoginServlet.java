package com.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;
//import static java.lang.System.out;

@WebServlet(
        description = "Login Servlet Testing",
        urlPatterns = {"/LoginServlet"},
        initParams = {
                @WebInitParam(name = "user", value = "Sachin"),
                @WebInitParam(name = "password", value = "BridgeLabz")
        }
)
        public class LoginServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String user=request.getParameter("user");
                String pwd=request.getParameter("pwd");

                String userID=getServletConfig().getInitParameter("user");
                String password=getServletConfig().getInitParameter("password");

                if(userID.equals(user)&&password.equals(pwd)){
                        request.setAttribute("user",user);
                        request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
                }else{
                        RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
                        PrintWriter outs=response.getWriter();
                        out.println("<font color=red> user name or password is wrong. </font>");
                        rd.include(request,response);
                }
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user=request.getParameter("user");
        String pwd=request.getParameter("pwd");

                String userID=getServletConfig().getInitParameter("user");
                String password=getServletConfig().getInitParameter("password");

                if(userID.equals(user)&&password.equals(pwd)){
                request.setAttribute("user",user);
                request.getRequestDispatcher("LoginSuccess.jsp").forward(request,response);
                }else{
                RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
                PrintWriter outs=response.getWriter();
                out.println("<font color=red> user name or password is wrong. </font>");
                rd.include(request,response);
                }
                }

                }