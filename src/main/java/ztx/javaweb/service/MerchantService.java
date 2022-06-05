package ztx.javaweb.service;


import ztx.javaweb.bean.Merchant;
import ztx.javaweb.dao.MerchantMapperImpl;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MerchantService {
    MerchantMapperImpl merchantMapper = new MerchantMapperImpl();

    /**
     * 获取所有商家信息
     * @return 商家列表
     */
    public List<Merchant> getMerchants(){
        return merchantMapper.getMerchants();
    }

    /**
     * 登录
     * @param id 输入的ID
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String id ,String password){
        boolean flag;
        Merchant merchant = merchantMapper.queryMerById(id);
        flag = merchant.getPassword().equals(password);

        return flag;
    }

    /**
     * 返回JSON字符列表
     * @return 返回JSON字符列表
     */
    public List<String> getJSONList(){
         List<Merchant> merchants = merchantMapper.getMerchants();
         List<String> strings = new ArrayList<>();
         for(Merchant m : merchants){
            String str = JSONObject.toJSONString(m);
            strings.add(str);
         }

         return strings;
    }
}
