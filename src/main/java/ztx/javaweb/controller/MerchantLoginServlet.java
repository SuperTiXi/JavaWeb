package ztx.javaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ztx.javaweb.service.MerchantService;

import java.io.IOException;

@WebServlet(name = "MerchantLoginServlet", value = "/merchantLoginServlet")
public class MerchantLoginServlet extends HttpServlet {

    MerchantService merchantService = new MerchantService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("name_Merchant");
        String password = request.getParameter("password_Merchant");

        boolean flag = merchantService.login(id,password);

        if(flag){
            request.getSession().setAttribute("belong",id);
            request.getRequestDispatcher("/GoodsListServlet").forward(request,response);
        }
        else{
            request.setAttribute("msg","登录失败");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
