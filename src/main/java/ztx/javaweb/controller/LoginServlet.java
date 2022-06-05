package ztx.javaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ztx.javaweb.bean.Admin;
import ztx.javaweb.service.AdminService;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_Login");
        String password = request.getParameter("password_Login");

        boolean flag = adminService.login(name,password);


        if(flag){
            request.getSession().setAttribute("admin",new Admin(name,password));
            request.setAttribute("kind","登录");
            request.getRequestDispatcher("/merchantManage").forward(request,response);
        }
        else{
            request.setAttribute("msg","用户名或密码不正确");
            request.setAttribute("name",name);
            request.setAttribute("password",password);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
