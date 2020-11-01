package com.newsxt.domain.mapper;



import com.newsxt.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
     void add(User user);

     void update(User user);

     void delete(Integer id);

     User queryById(Integer id);

     List<User> queryALL();
}
