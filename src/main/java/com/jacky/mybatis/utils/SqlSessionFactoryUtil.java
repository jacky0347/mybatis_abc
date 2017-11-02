package com.jacky.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by jacky on 2017/10/23.
 */
public class SqlSessionFactoryUtil {
    //单利模式私有属性
    private static SqlSessionFactory sqlSessionFactory;

    //类线程锁,避免并发影响
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    //私有构造函数,why?
    private SqlSessionFactoryUtil(){}

    //SqlSession 工厂方法,初始化工厂接口
    //get方法还是初始化方法?最终要用到的是什么？
    //能否把方法返回类型改为void？
    public static SqlSessionFactory initSqlSessionFactory(){
        String resource ="mybatis-config.xml";
        InputStream inputStream =null;
        try{
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            Logger.getLogger(SqlSessionFactoryUtil.class.getName()).log(Level.SEVERE,null,e);
        }
        //同步构建CLASS级别的锁（可以回顾并发锁的级别）
        synchronized (CLASS_LOCK){
            if(sqlSessionFactory==null){
                sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        //在锁内返回和所外返回区别？
        return sqlSessionFactory;
    }
    public static SqlSession openSession(){
        if(sqlSessionFactory ==null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}
