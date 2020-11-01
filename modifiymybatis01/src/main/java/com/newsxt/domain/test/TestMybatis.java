package com.newsxt.domain.test;

import com.newsxt.domain.entity.User;
import com.newsxt.domain.mapper.UserMapper;
import com.newsxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        //1.查询所有数据
//        SqlSession session = MybatisUtil.createSqlSession();
//        //得到UserMapper的代理对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//        System.out.println(userMapper);
//        //打印结果：org.apache.ibatis.binding.MapperProxy@50b494a6
//        System.out.println(userMapper.getClass().getSimpleName());
//        //打印结果：$Proxy6
//        List<User> list = userMapper.queryALL();
//        for(User user : list){
//            System.out.println(user);
//        }
//        MybatisUtil.closeSqlSession(session);

        //2.更新
//        SqlSession session = MybatisUtil.createSqlSession();
//        //得到UserMapper的代理对象
//        UserMapper userMapper = session.getMapper(UserMapper.class);
//
//        User user = new User(3,"高圆圆","北京",new Date());
//        userMapper.update(user);
//        session.commit();
//        MybatisUtil.closeSqlSession(session);


        //3.新增
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User("景甜","香港",new Date());
        userMapper.add(user);
        session.commit();
        MybatisUtil.closeSqlSession(session);

    }
}
