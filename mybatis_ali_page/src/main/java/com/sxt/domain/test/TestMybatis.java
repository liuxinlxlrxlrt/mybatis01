package com.sxt.domain.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.domain.entity.User;
import com.sxt.domain.mapper.UserMapper;
import com.sxt.domain.utils.MybatisUtil;
import com.sxt.domain.utils.PageBean;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {

    //01.limit方式
    SqlSession session = MybatisUtil.createSqlSession();
    //得到UserMapper的代理对象
    UserMapper userMapper = session.getMapper(UserMapper.class);

    //方法一：
    @Test
    public void queryForPage() {
        User user = new User();
        PageBean bean = new PageBean();
        bean.setCurrentPage(1);
        bean.setPageSize(5);
        //分页查询+查询总条数
        Page<User> page = PageHelper.startPage(bean.getCurrentPage(), bean.getPageSize());
        //分页查询+不查询总条数
        /**
         * 参数1：当前第几页
         * 参数2：每页条数
         * 参数3：是否查询总条数，默认为true
         */
//        Page<User> page = PageHelper.startPage(bean.getCurrentPage(),bean.getPageSize(),false);

        List<User> list1 = userMapper.queryForPage(user);
        for (User u1 : list1) {
            System.out.println(u1);
        }
        System.out.println("总条数为：" + page.getTotal()+", 总页数"+page.getPages());
        MybatisUtil.closeSqlSession(session);
    }
}
