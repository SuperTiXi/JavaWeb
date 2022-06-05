package ztx.javaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ztx.javaweb.bean.Merchant;
import ztx.javaweb.service.MerchantService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MerchantListServlet", urlPatterns = {"/merchantManage"})
public class MerchantListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MerchantService merchantService = new MerchantService();
        List<Merchant> merchants = merchantService.getMerchants();

        req.setAttribute("merchantList",merchants);
        System.out.println(merchants);
        req.getRequestDispatcher("/merchantManage.jsp").forward(req,resp);
    }
}
