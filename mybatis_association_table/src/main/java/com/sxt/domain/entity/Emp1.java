package com.sxt.domain.entity;

import java.util.Date;

public class Emp1 {
    private Integer empid;
    private String ename;
    private String esex;
    private Date ehiredate;
    private Double esal;
    private Integer deptid;
    //把用户要查询的多的信息再声明变量
    private String dname;
    private String dloc;

    public Emp1() {
    }

    public Emp1(String ename, String esex, Date ehiredate, Double esal, Integer deptid) {
        super();
        this.ename = ename;
        this.esex = esex;
        this.ehiredate = ehiredate;
        this.esal = esal;
        this.deptid = deptid;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEsex() {
        return esex;
    }

    public void setEsex(String esex) {
        this.esex = esex;
    }

    public Date getEhiredate() {
        return ehiredate;
    }

    public void setEhiredate(Date ehiredate) {
        this.ehiredate = ehiredate;
    }

    public Double getEsal() {
        return esal;
    }

    public void setEsal(Double esal) {
        this.esal = esal;
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

    @Override
    public String toString() {
        return "Emp1{" +
                "empid=" + empid +
                ", ename='" + ename + '\'' +
                ", esex='" + esex + '\'' +
                ", ehiredate=" + ehiredate +
                ", esal=" + esal +
                ", deptid=" + deptid +
                ", dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}';
    }
}
