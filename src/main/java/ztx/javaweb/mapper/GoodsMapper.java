package ztx.javaweb.mapper;

import ztx.javaweb.bean.Goods;

import java.util.List;

/**
 * Goods接口
 */
public interface GoodsMapper {

    /**
     * 添加商品
     * @param goods 要添加的商品对象
     * @return 是都插入成功
     */
    public boolean insertGoods(Goods goods);

    /**
     * 根据ID删除商品
     * @param id 要删除商品的ID
     * @return 是否成功删除
     */
    public boolean deleteGoodsById(int id );

    /**
     * 更新商品
     * @param goods 要更新的商品
     * @return 是否更新成功
     */
    public boolean updateGoods(Goods goods);

    /**
     * 根据Id查询对象
     * @param id 要查询商品的id
     * @return 返回对象
     */
    public Goods queryGoodsById(int id);

    /**
     * 获取Goods列表
     * @return
     */
    public List<Goods> getGoodsList();
}
