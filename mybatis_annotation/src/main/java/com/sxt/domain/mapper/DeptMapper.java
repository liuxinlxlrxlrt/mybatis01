package com.sxt.domain.mapper;

import com.sxt.domain.entity.Dept;
import com.sxt.domain.entity.Emp;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

public interface DeptMapper {

    /**
     * 根据部门id查询部门信息
     *
     * @return
     */
    @Select("select * from dept where deptid=#{deptid}")
    Dept queryDeptById(Integer deptid);

    @Select("select * from dept")
    @Results({@Result(property = "deptid",column = "deptid"),
    @Result(property = "dname",column = "dname"),
    @Result(property = "dloc",column = "dloc"),
    @Result(property = "emps",javaType = Set.class,column = "deptid",
    many = @Many(select = "com.sxt.domain.mapper.EmpMapper.queryEmpByDeptId"))
    })
    List<Dept> queryAllDept();

}
