package ztx.javaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ztx.javaweb.bean.Admin;
import ztx.javaweb.service.AdminService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_Register");
        String password = request.getParameter("password_Register");

        boolean flag = adminService.register(name,password);

        if(flag){
            request.getSession().setAttribute("admin",new Admin(name,password));
            request.setAttribute("kind","注册");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        else{
            request.setAttribute("msg","注册失败");
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
