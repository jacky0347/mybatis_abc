package com.jacky.mybatis.demo;

import com.jacky.mybatis.beans.Role;
import com.jacky.mybatis.dao.RoleMapper;
import com.jacky.mybatis.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role();
//            role.setName("张三");
//            role.setNote("第一个角色");
//            roleMapper.insertRole(role);
//            role = roleMapper.getRole(1L);
//            System.out.print(role);
//            roleMapper.insertRole(role);
            roleMapper.deleteRole(5L);
            int i=  1/0;

            sqlSession.commit();

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null) {
                sqlSession.close();
            }
        }
    }
}
