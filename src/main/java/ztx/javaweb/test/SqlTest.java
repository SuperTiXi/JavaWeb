package ztx.javaweb.test;

import ztx.javaweb.bean.Admin;
import ztx.javaweb.bean.Merchant;
import ztx.javaweb.dao.AdminMapperImpl;
import ztx.javaweb.dao.MerchantMapperImpl;
import ztx.javaweb.service.MerchantService;

import java.util.List;

public class SqlTest {
    public static void main(String[] args) {
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        Admin admin = adminMapper.queryAdminByName("ztx");
        MerchantService merchantService = new MerchantService();
//        System.out.println(admin.toString());

        MerchantMapperImpl merchantMapper = new MerchantMapperImpl();
        Merchant merchant = merchantMapper.queryMerById("1");
        System.out.println(merchant.toString());

    }

}
