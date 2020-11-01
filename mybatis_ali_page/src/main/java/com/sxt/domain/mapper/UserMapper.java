package com.sxt.domain.mapper;


import com.sxt.domain.entity.User;
import com.sxt.domain.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryForPage(User user);

}
