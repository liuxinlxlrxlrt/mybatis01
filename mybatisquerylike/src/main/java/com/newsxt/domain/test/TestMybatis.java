package com.newsxt.domain.test;

import com.newsxt.domain.entity.User;
import com.newsxt.domain.mapper.UserMapper;
import com.newsxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class TestMybatis {
    /**
     * 第一种方法：
     *select * from sys_user where name like #{name}
     *  user.setName("%疏影6%");
     */
    @Test
    public void queryLike01() {
        //第一种方法模糊查询方法
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setName("%疏影6%");
        List<User> list1 = userMapper.queryLike(user1);
        for (User u1 : list1) {
            System.out.println(u1);
        }
        MybatisUtil.closeSqlSession(session);
    }

    /**
     * 第二种方法(推荐使用)：
     *select * from sys_user where name like "%"#{name}"%"
     *  user.setName("疏影6");
     */
    @Test
    public void queryLike02() {
        //第一种方法模糊查询方法
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user2 = new User();
        user2.setName("疏影6");
        List<User> list2 = userMapper.queryLike(user2);
        for (User u2: list2) {
            System.out.println(u2);
        }
        MybatisUtil.closeSqlSession(session);
    }

    /**
     * 第三种方法（不推荐使用：有sql注入的风险）：
     *select * from sys_user where name like "%${name}%"
     *  user.setName("疏影6");
     */
    @Test
    public void queryLike03() {
        //第一种方法模糊查询方法
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user2 = new User();
        user2.setName("疏影6");
        List<User> list2 = userMapper.queryLike(user2);
        for (User u2: list2) {
            System.out.println(u2);
        }
        MybatisUtil.closeSqlSession(session);
    }

    /**
     * 第四种方法：
     * <bind name="keywords" value="'%'+name+'%'"/>
     *  select * from sys_user where name like #{keywords}
     *  user.setName("疏影6");
     */
    @Test
    public void queryLike04() {
        //第一种方法模糊查询方法
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user2 = new User();
        user2.setName("疏影6");
        List<User> list2 = userMapper.queryLike(user2);
        for (User u2: list2) {
            System.out.println(u2);
        }
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void initDate() {
        //3.新增
        SqlSession session = MybatisUtil.createSqlSession();
        //得到UserMapper的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        for (int i = 1; i <=100; i++) {
            userMapper.add(new User("江疏影" + i, "重庆" + i, new Date()));
            session.commit();
        }
        System.out.println("添加成功");
        MybatisUtil.closeSqlSession(session);
    }
}
