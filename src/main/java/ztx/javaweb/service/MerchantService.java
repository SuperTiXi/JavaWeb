package ztx.javaweb.service;


import ztx.javaweb.bean.Goods;
import ztx.javaweb.bean.Merchant;
import ztx.javaweb.dao.GoodsMapperImpl;
import ztx.javaweb.dao.MerchantMapperImpl;

import java.util.List;


public class MerchantService {
    MerchantMapperImpl merchantMapper = new MerchantMapperImpl();
    GoodsMapperImpl goodsMapper = new GoodsMapperImpl();

    /**
     * 登录
     * @param id 输入的ID
     * @param password  输入的密码
     * @return  登录是否成功
     */
    public boolean login(String id ,String password){
        boolean flag;
        Merchant merchant = merchantMapper.queryMerById(id);
        if(merchant==null){
            return false;
        }
        flag = merchant.getPassword().equals(password);

        return flag;
    }

    /**
     * 添加商品
     * @param goods 要添加的商品对象
     * @return 是都插入成功
     */
    public boolean insertGoods(Goods goods){
        boolean flag = goodsMapper.insertGoods(goods);
        goodsMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 根据ID删除商品
     * @param id 要删除商品的ID
     * @return 是否成功删除
     */
    public boolean deleteGoodsById(int id ){
        boolean flag = goodsMapper.deleteGoodsById(id);
        goodsMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 更新商品
     * @param goods 要更新的商品
     * @return 是否更新成功
     */
    public boolean updateGoods(Goods goods){
        boolean flag = goodsMapper.updateGoods(goods);
        goodsMapper.getSqlSession().commit();
        return flag;
    }

    /**
     * 根据Id查询对象
     * @param id 要查询商品的id
     * @return 返回对象
     */
    public Goods queryGoodsById(int id){
        return goodsMapper.queryGoodsById(id);
    }

    /**
     * 获取Goods列表
     * @return
     */
    public List<Goods> getGoodsList(){
        return goodsMapper.getGoodsList();
    }
}
