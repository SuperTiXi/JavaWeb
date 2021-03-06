package ztx.javaweb.dao;

import org.apache.ibatis.session.SqlSession;
import ztx.javaweb.bean.Goods;
import ztx.javaweb.mapper.GoodsMapper;
import ztx.javaweb.sql.GetSqlSession;

import java.util.List;

public class GoodsMapperImpl {
    SqlSession sqlSession;
    GoodsMapper goodsMapper;

    public GoodsMapperImpl(){
        this.sqlSession = GetSqlSession.createSqlSession();
        goodsMapper = sqlSession.getMapper(GoodsMapper.class);
    }

    /**
     * 添加商品
     * @param goods 要添加的商品对象
     * @return 是都插入成功
     */
    public boolean insertGoods(Goods goods){
        boolean flag = goodsMapper.insertGoods(goods);
        sqlSession.commit();
        return flag;
    }

    /**
     * 根据ID删除商品
     * @param id 要删除商品的ID
     * @return 是否成功删除
     */
    public boolean deleteGoodsById(int id ){
        boolean flag = goodsMapper.deleteGoodsById(id);
        sqlSession.commit();
        return flag;
    }

    /**
     * 更新商品
     * @param goods 要更新的商品
     * @return 是否更新成功
     */
    public boolean updateGoods(Goods goods){
        boolean flag = goodsMapper.updateGoods(goods);
        sqlSession.commit();
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

    public SqlSession getSqlSession() {
        return sqlSession;
    }
}
