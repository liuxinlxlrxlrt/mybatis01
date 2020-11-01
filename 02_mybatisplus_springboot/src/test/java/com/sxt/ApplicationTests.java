package com.sxt;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxt.mapper.UserMapper;
import com.sxt.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getClass());
    }

    @Test
    public void query1(){
        IPage<User> page= new Page<>(1,3);
        userMapper.selectPage(page,null);
        long total = page.getTotal();
        List<User> list = page.getRecords();
        for (User user:list){
            System.out.println(user);
        }
        System.out.println("总条数："+total);
    }

}
