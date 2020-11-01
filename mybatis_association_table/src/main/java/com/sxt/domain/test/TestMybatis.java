package com.sxt.domain.test;

import com.sxt.domain.entity.Dept;
import com.sxt.domain.entity.Emp1;
import com.sxt.domain.entity.Emp3;
import com.sxt.domain.mapper.DeptMapper;
import com.sxt.domain.mapper.EmpMapper;
import com.sxt.domain.utils.MybatisUtil;
import com.sxt.domain.vo.EmpVo;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;
//assocication：关联
import java.util.List;

public class TestMybatis {

    SqlSession session = MybatisUtil.createSqlSession();
    EmpMapper empMapper = session.getMapper(EmpMapper.class);
    DeptMapper deptMapper = session.getMapper(DeptMapper.class);

    @Test
    public void queryAllEmp1(){
        List<Emp1> empList1 = empMapper.queryAllEmp1();
        for(Emp1 emp1:empList1){
            System.out.println(emp1);
        }
    }

    @Test
    public void queryAllEmp2(){
        List<EmpVo> empList2 = empMapper.queryAllEmp2();
        for(EmpVo empVo:empList2){
            System.out.println(empVo);
        }
    }

    @Test
    public void queryAllEmp3(){
        List<Emp3> empList3 = empMapper.queryAllEmp3();
        for(Emp3 emp3:empList3){
            System.out.println(emp3);
        }
    }

    @Test
    public void queryAllEmp4(){
        List<Emp3> empList4 = empMapper.queryAllEmp4();
        for(Emp3 emp4:empList4){
            System.out.println(emp4);
        }
    }

    @Test
    public void queryAllDept(){
        List<Dept> deptlist = deptMapper.queryAllDept();
        for(Dept dept : deptlist){
            System.out.println(dept+","+dept.getEmps());
        }
    }
    @Test
    public void queryAllDept2(){
        List<Dept> deptlist = deptMapper.queryAllDept();
        for(Dept dept : deptlist){
            System.out.println(dept+","+dept.getEmps());
        }
    }

}
