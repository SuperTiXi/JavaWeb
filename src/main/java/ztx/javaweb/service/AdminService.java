package ztx.javaweb.service;

import ztx.javaweb.bean.Admin;
import ztx.javaweb.dao.AdminMapperImpl;

import java.sql.SQLDataException;

public class AdminService {

    /**
     * 登录
     * @param name 输入的姓名
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String name ,String password){
        boolean flag;
        AdminMapperImpl adminMapper = new AdminMapperImpl();
        Admin admin = adminMapper.queryAdminByName(name);
        flag = admin.getPassword() == password;

        return flag;
    }

    public boolean register(String name,String password){
        try{
            boolean flag;
            AdminMapperImpl adminMapper = new AdminMapperImpl();
            Admin admin = new Admin(name,password);
            flag = adminMapper.insertAdmin(admin);
            return flag;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }
}
