package com.sxt.domain.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String name;
    private String address;
    private Date birthday;

    public User(){

    }

    public User(String name, String address, Date birthday) {
        super();
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }
    //查询用
    public User(Integer id, String name, String address, Date birthday) {
        super();
        this.id=id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
