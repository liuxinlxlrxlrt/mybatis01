package com.sxt.domain.mapper;

import com.sxt.domain.entity.Dept;
import com.sxt.domain.entity.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface EmpMapper {
    //注解方式扫描到EmpMapper，会在内存中创建EmpMapper对象
    //@ResultMap中EmpMapper.xml的namespace="xxx",xxx不能是EmpMapper对象,否则重复后报错
    @Select("select * from emp inner join dept using(deptid)")
    @ResultMap("EmpMapper.myEmp")
    List<Emp> queryAllEmp();

    //不用xml
    @Select("select * from emp inner join dept using(deptid)")
    @Results({@Result(property = "empid", column = "empid"),
            @Result(property = "ename", column = "ename"),
            @Result(property = "esex", column = "esex"),
            @Result(property = "ehiredate", column = "ehiredate"),
            @Result(property = "esal", column = "esal"),
            @Result(property = "dept", column = "deptid", javaType = Dept.class,
                    one = @One(select = "com.sxt.domain.mapper.DeptMapper.queryDeptById"))
    })
    List<Emp> queryAllEmp2();

    /**
     * 根据部门id查询员工信息
     */
    @Select("select * from emp where deptid=#{deptid}")
    List<Emp> queryEmpByDeptId(Integer deptid);
}
