package com.sxt.domain.vo;

import com.sxt.domain.entity.Emp2;

public class EmpVo extends Emp2 {
    private String dname;
    private String dloc;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }

    @Override
    public String toString() {
        return "EmpVo{" +
                "dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}'+super.toString();
    }
}
