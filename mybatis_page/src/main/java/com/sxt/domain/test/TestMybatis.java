package com.sxt.domain.test;

import com.sxt.domain.entity.User;
import com.sxt.domain.mapper.UserMapper;
import com.sxt.domain.utils.MybatisUtil;
import com.sxt.domain.utils.PageBean;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.*;

public class TestMybatis {
    /**
     * 两者的区别
     * rowBounds 本质就是封装了limit
     * limit 是在SQL层面实现分页,在测试中使用getMapper获得对象
     * rowBounds 在代码层面实现分页,创建rowBounds对象
     */
    //01.limit方式
    SqlSession session = MybatisUtil.createSqlSession();
    //得到UserMapper的代理对象
    UserMapper userMapper = session.getMapper(UserMapper.class);

    //方法一：
    @Test
    public void queryForPage1() {
        int currentPage = 1;
        int pageSize=5;

        List<User> list1 = userMapper.queryForPage1((currentPage-1)*pageSize,pageSize);
        for (User u1: list1) {
            System.out.println(u1);
        }
        MybatisUtil.closeSqlSession(session);
    }

    //方法二：map
    @Test
    public void queryForPage2() {
        int currentPage=1;
        int pageSize=5;
        Map<String,Object> map = new HashMap<>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<User> list1 = userMapper.queryForPage2(map);
        for (User u1: list1) {
            System.out.println(u1);
        }
        MybatisUtil.closeSqlSession(session);
    }

    //方法三：RowBounds方式(不推荐)
    @Test
    public void queryForPage3() {
        int currentPage=1;
        int pageSize=5;
        /**
         * 参数1：开始条，偏移量
         * 参数2：查询总条数（拿不到）
         */
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);
        ////使用mybatis中提供的API
        List<User> list1 = session.selectList("com.sxt.domain.mapper.UserMapper.queryForPage3",null,rowBounds);
        for (User u1: list1) {
            System.out.println(u1);
        }
        MybatisUtil.closeSqlSession(session);
    }

    //方法四：查询总条数
    @Test
    public void queryForPage4() {
        //查询总条数
        int count = userMapper.queryCount();
        System.out.println("总条数为："+count);
        int currentPage=1;
        System.out.println("当前第"+currentPage+"页，共"+count+"条");
        MybatisUtil.closeSqlSession(session);
    }

    //方法五：PageBean查询
    @Test
    public void queryForPage5() {

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(1);
        pageBean.setPageSize(5);
        //查询总条数
        Integer count = userMapper.queryCount();
        pageBean.setTotalCount(count);

        List<User> list4 = userMapper.queryForPage5(pageBean);
        for (User u4 : list4) {
            System.out.println(u4);
        }
        System.out.println("当前第"+pageBean.getCurrentPage()+"页，共"+pageBean.getTotalCount()+"条");
        MybatisUtil.closeSqlSession(session);
    }

    //分页+模糊查询
    @Test
    public void queryForPage6() {
        String keywords="6";

        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(1);
        pageBean.setPageSize(5);
        //查询总条数
        Integer count = userMapper.queryCount6(keywords);
        pageBean.setTotalCount(count);

        Map<String,Object> map = new HashMap<>();
        map.put("startIndex",pageBean.getStartIndex());
        map.put("pageSize",pageBean.getPageSize());
        map.put("keywords",keywords);

        List<User> list4 = userMapper.queryForPage6(map);
        for (User u4 : list4) {
            System.out.println(u4);
        }
        System.out.println("当前第"+pageBean.getCurrentPage()+"页，共"+pageBean.getTotalCount()+"条");
        MybatisUtil.closeSqlSession(session);
    }


}
