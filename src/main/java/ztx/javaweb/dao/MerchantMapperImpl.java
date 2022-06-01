package ztx.javaweb.dao;

import org.apache.ibatis.session.SqlSession;
import ztx.javaweb.bean.Merchant;
import ztx.javaweb.sql.GetSqlSession;

public class MerchantMapperImpl {
    SqlSession sqlSession;
    MerchantMapper merchantMapper;

    public MerchantMapperImpl(){
        this.sqlSession = GetSqlSession.createSqlSession();
        merchantMapper = sqlSession.getMapper(MerchantMapper.class);
    }

    /**
     * 添加商家
     * @param merchant 要插入的对象
     * @return 是否插入成功
     */
    public boolean insertMer(Merchant merchant){
        boolean flag = merchantMapper.insertMer(merchant);
        sqlSession.commit();
        return flag;
    }

    /**
     * 根据Id删除商家
     * @param id 要删除商家的Id
     * @return 是否删除成功
     */
    public boolean deleteMerById(int id){
        boolean flag = merchantMapper.deleteMerById(id);
        sqlSession.commit();
        return flag;
    }

    /**
     * 更新商家信息
     * @param merchant 更新数据
     * @return 是否更新成功
     */
    public boolean updateMer(Merchant merchant){
        boolean flag = merchantMapper.updateMer(merchant);
        sqlSession.commit();
        return flag;
    }

    /**
     * 根据ID查询商家
     * @param id 查询商家的ID
     * @return 返回查询到的对象
     */
    public Merchant queryMerById(int id){
        return merchantMapper.queryMerById(id);
    }
}
