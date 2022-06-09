package ztx.javaweb.dao;

import org.apache.ibatis.session.SqlSession;
import ztx.javaweb.bean.Admin;
import ztx.javaweb.mapper.AdminMapper;
import ztx.javaweb.sql.GetSqlSession;

public class AdminMapperImpl {
    SqlSession sqlSession;
    AdminMapper adminMapper;


    public AdminMapperImpl(){
        this.sqlSession = GetSqlSession.createSqlSession();
        adminMapper = sqlSession.getMapper(AdminMapper.class);
    }

    /**
     * 插入Admin
     * @param admin 输入的admin对象
     * @return 是否插入成功
     */
    public boolean insertAdmin(Admin admin){
        boolean flag = adminMapper.insertAdmin(admin);
        sqlSession.commit();
        return flag;
    }

    /**
     * 根据id删除Admin
     * @param id 要删除的姓名
     * @return 是否删除成功
     */
    public boolean deleteAdminById(String id){
        boolean flag = adminMapper.deleteAdminById(id);
        sqlSession.commit();
        return flag;
    }

    /**
     * 根据名字查询对象
     * @param name 要查询的对象名字
     * @return 返回对象
     */
    public Admin queryAdminByName(String name){
        return adminMapper.queryAdminByName(name);
    }

    /**
     * 更新admin
     * @param admin 更新信息
     * @return 是否成功
     */
    public boolean updateAdmin(Admin admin){
        boolean flag = adminMapper.updateAdmin(admin);
        sqlSession.commit();
        return flag;
    }
}
