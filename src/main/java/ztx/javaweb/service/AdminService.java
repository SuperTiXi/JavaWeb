package ztx.javaweb.service;

import org.apache.ibatis.session.SqlSession;
import ztx.javaweb.bean.Admin;
import ztx.javaweb.bean.Merchant;
import ztx.javaweb.dao.AdminMapperImpl;
import ztx.javaweb.dao.MerchantMapperImpl;
import ztx.javaweb.mapper.MerchantMapper;

import java.util.List;

public class AdminService {

    MerchantMapperImpl merchantMapper = new MerchantMapperImpl();

    AdminMapperImpl adminMapper = new AdminMapperImpl();
    /**
     * 登录
     * @param name 输入的姓名
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String name ,String password){
        boolean flag;
        Admin admin = adminMapper.queryAdminByName(name);
        flag = admin.getPassword().equals(password);

        return flag;
    }

    /**
     * 注册
     * @param name
     * @param password
     * @return
     */
    public boolean register(String name,String password){
        try{
            boolean flag;
            Admin admin = new Admin(name,password);
            flag = adminMapper.insertAdmin(admin);
            return flag;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }

    /**
     * 添加商家
     * @param merchant 要插入的对象
     * @return 是否插入成功
     */
    public boolean insertMer(Merchant merchant){
        boolean flag = merchantMapper.insertMer(merchant);
        merchantMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 根据Id删除商家
     * @param id 要删除商家的Id
     * @return 是否删除成功
     */
    public boolean deleteMerById(String id){
        boolean flag = merchantMapper.deleteMerById(id);
        merchantMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 更新商家信息
     * @param merchant 更新数据
     * @return 是否更新成功
     */
    public boolean updateMer(Merchant merchant){
        boolean flag = merchantMapper.updateMer(merchant);
        merchantMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 根据ID查询商家
     * @param id 查询商家的ID
     * @return 返回查询到的对象
     */
    public Merchant queryMerById(String id){
        return merchantMapper.queryMerById(id);
    }

    /**
     * 获取所有商家信息
     * @return 商家列表
     */
    public List<Merchant> getMerchants(){
        return merchantMapper.getMerchants();
    }
}
