package com.sxt.domain.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory sessionFactory;

    static {
        try {
            InputStream in = MybatisUtil.class.getClassLoader().getResourceAsStream("mybatis.config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession(){
        return  sessionFactory.openSession();
    }

    public static void closeSqlSession(SqlSession session){
        if(session != null){
            session.close();
        }
    }
}

