package com.sxt.domain.test;

import com.sxt.domain.entity.Emp;
import com.sxt.domain.mapper.EmpMapper;
import com.sxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;


public class TestMybatisEmp {

    SqlSession session = MybatisUtil.createSqlSession();
    EmpMapper empMapper = session.getMapper(EmpMapper.class);

    @Test
    public void testQueryAllEmp(){
        List<Emp> list = empMapper.queryAllEmp();
        for(Emp emp:list){
            System.out.println(emp);
        }
        MybatisUtil.closeSqlSession(session);
    }

    @Test
    public void testQueryAllEmp2(){
        List<Emp> list = empMapper.queryAllEmp2();
        for(Emp emp:list){
            System.out.println(emp);
        }
//        String className = "com.sxt.domain.mapper.DeptMapper";
//        Class<?> forName = null;
//        try {
//            forName = Class.forName(className);
//            forName.newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        MybatisUtil.closeSqlSession(session);
    }
}
