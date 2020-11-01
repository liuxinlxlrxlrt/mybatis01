package com.sxt.domain.test;

import com.sxt.domain.entity.User;
import com.sxt.domain.mapper.UserMapper;
import com.sxt.domain.utils.MybatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
import java.util.List;


public class TestMybatis {

    //01.limit方式
    SqlSession session = MybatisUtil.createSqlSession();
    //得到UserMapper的代理对象
    UserMapper userMapper = session.getMapper(UserMapper.class);

    //方法一：
    @Test
    public void queryAll() {
        User user = new User();

        List<User> list1 = userMapper.queryAll(user);
        for (User u1 : list1) {
            System.out.println(u1);
        }
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void queryALLInIds() {
        Integer[] ids = {6,7,8,9,10};

        List<User> list2 = userMapper.queryALLInIds(ids);
        for (User u2 : list2) {
            System.out.println(u2);
        }
        MybatisUtil.closeSqlSession(session);
    }
}

