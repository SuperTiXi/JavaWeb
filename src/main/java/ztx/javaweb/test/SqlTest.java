package ztx.javaweb.test;

import ztx.javaweb.bean.Admin;
import ztx.javaweb.dao.AdminMapperImpl;

public class SqlTest {
    public static void main(String[] args) {
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        Admin admin = adminMapper.queryAdminByName("ztx");
        System.out.println(admin.toString());
    }
}
