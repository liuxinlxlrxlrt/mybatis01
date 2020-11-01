package com.sxt.domain.test;


import com.sxt.domain.entity.User;
import com.sxt.domain.mapper.UserMapper;
import com.sxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

//assocication：关联

public class TestMybatisUser {

    SqlSession session = MybatisUtil.createSqlSession();
    UserMapper userMapper = session.getMapper(UserMapper.class);

    @Test
    public void add() {
//        userMapper.add(new User("江疏影","重庆",new Date()));
//                userMapper.add(new User("景甜","香港",new Date()));
        userMapper.add(new User("童谣", "北京", new Date()));
        session.commit();
        System.out.println("添加成功");
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void update() {
        userMapper.update(new User(104, "许晴", "武汉", new Date()));
        session.commit();
        System.out.println("更新成功");
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void delete() {
        userMapper.delete(104);
        session.commit();
        System.out.println("删除成功");
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void queryById() {
        User user=userMapper.queryById(103);
        System.out.println(user);
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void queryAllUser() {
        List<User> userList = userMapper.queryAll();
        for (User user : userList) {
            System.out.println(user);
        }
        MybatisUtil.closeSqlSession(session);
    }
}
