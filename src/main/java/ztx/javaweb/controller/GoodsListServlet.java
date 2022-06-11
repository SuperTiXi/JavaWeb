package ztx.javaweb.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ztx.javaweb.bean.Goods;
import ztx.javaweb.service.MerchantService;
import ztx.javaweb.util.StrUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GoodsListServlet", value = "/GoodsListServlet")
public class GoodsListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MerchantService merchantService = new MerchantService();

        String creator = (String) req.getSession().getAttribute("belong");
        req.setAttribute("belong",creator);

        String model =  req.getParameter("model")==null?"init":req.getParameter("model");
        if(model.equals("delete")){
            String id = req.getParameter("id");
            int id_int = StrUtil.strToInt(id);
            if(merchantService.deleteGoodsById(id_int)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList", goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }

        }else if(model.equals("add")){
            String id= req.getParameter("id-input");
            String name = req.getParameter("name-input");
            String price = req.getParameter("price-input");
            String info = req.getParameter("info-input");
            float price_float = StrUtil.strToFloat(price);
            int id_int = StrUtil.strToInt(id);
            String belong = creator;

            Goods goods = new Goods(name,belong,price_float,info,null,id_int);

            if(merchantService.insertGoods(goods)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList",goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }
        }else if(model.equals("query")){
            String id = req.getParameter("queryById");
            int id_int = StrUtil.strToInt(id);
            List<Goods> goodsList = new ArrayList<>();
            goodsList.add(merchantService.queryGoodsById(id_int));
            req.setAttribute("goodsList", goodsList);
            req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
        }else if(model.equals("modify")){
            String id = req.getParameter("modifyId");
            int id_int = StrUtil.strToInt(id);
            String name = req.getParameter("name-input");
            String price = req.getParameter("price-input");
            float price_float = StrUtil.strToFloat(price);
            String info = req.getParameter("info-input");
            String belong = creator;
            String picture = req.getParameter("picture");
            Goods goods = new Goods(name,belong,price_float,info,picture,id_int);
            if(merchantService.updateGoods(goods)){
                List<Goods> goodsList = merchantService.getGoodsList();
                req.setAttribute("goodsList",goodsList);
                req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
            }
        }
        else if(model.equals("init")){
            List<Goods> goodsList = merchantService.getGoodsList();
            req.setAttribute("goodsList",goodsList);
            req.getRequestDispatcher("/goodsManage.jsp").forward(req, resp);
        }
    }
}
