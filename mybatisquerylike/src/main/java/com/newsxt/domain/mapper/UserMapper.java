package com.newsxt.domain.mapper;

import com.newsxt.domain.entity.User;

import java.util.List;

public interface UserMapper {
     void add(User user);

     List<User> queryLike(User user);
}
