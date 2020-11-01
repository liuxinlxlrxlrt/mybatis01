package com.sxt.domain.test;

import com.sxt.domain.entity.Dept;
import com.sxt.domain.entity.Emp;
import com.sxt.domain.mapper.DeptMapper;
import com.sxt.domain.mapper.EmpMapper;
import com.sxt.domain.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;


public class TestMybatisDept {

    SqlSession session = MybatisUtil.createSqlSession();
    DeptMapper deptMapper = session.getMapper(DeptMapper.class);

    @Test
    public void testQueryAllDept(){
        List<Dept> list = deptMapper.queryAllDept();
        for(Dept dept:list){
            System.out.println(dept+","+dept.getEmps());
        }
        MybatisUtil.closeSqlSession(session);
    }

    /**
     * 根据部门id查询部门信息
     */
    @Test
    public void queryDeptById(){
        Integer deptid=1;
        Dept dept1= deptMapper.queryDeptById(deptid);
        Dept dept2= deptMapper.queryDeptById(deptid);
        System.out.println(dept1);
        System.out.println(dept2);
    }
}
