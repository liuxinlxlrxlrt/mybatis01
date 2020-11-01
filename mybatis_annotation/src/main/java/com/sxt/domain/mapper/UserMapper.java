package com.sxt.domain.mapper;


import com.sxt.domain.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert("insert into sys_user ( name,address,birthday)values (#{name},#{address},#{birthday})")
    void add(User user);

    @Update("update sys_user set name=#{name},address=#{address},birthday=#{birthday} where id=#{id}")
    void update(User user);

    @Delete("delete from sys_user where id=#{value}")
    void delete(Integer id);

    @Select("select * from sys_user where id=#{id}")
    User queryById(Integer id);

    @Select("select * from sys_user")
    List<User> queryAll();
}
