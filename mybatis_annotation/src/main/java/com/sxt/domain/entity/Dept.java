package com.sxt.domain.entity;

import java.util.HashSet;
import java.util.Set;

public class Dept {
    private  Integer deptid;
    private String dname;
    private String dloc;
    private Set<Emp> emps = new HashSet<>();

    public Dept() {
    }

    public Dept(String dname, String dloc) {
        super();
        this.dname = dname;
        this.dloc = dloc;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

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

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}';
    }
}
