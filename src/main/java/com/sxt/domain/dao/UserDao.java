package com.sxt.domain.dao;

import com.sxt.domain.entity.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    void update(User user);

    void delete(Integer id);

    User queryById(Integer id);

    List<User> queryAll();
}
