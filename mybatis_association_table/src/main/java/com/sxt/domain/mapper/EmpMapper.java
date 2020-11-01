package com.sxt.domain.mapper;

import com.sxt.domain.entity.Emp1;
import com.sxt.domain.entity.Emp3;
import com.sxt.domain.vo.EmpVo;

import java.util.List;

public interface EmpMapper {
    List<Emp1> queryAllEmp1();

    List<EmpVo> queryAllEmp2();

    List<Emp3> queryAllEmp3();

    List<Emp3> queryAllEmp4();
}
