package com.sxt.domain.mapper;


import com.sxt.domain.entity.User;
import com.sxt.domain.utils.PageBean;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> queryAll(User user);

    /**
     * 查询id在Integer[]里面的数据
     */
    List<User> queryALLInIds(Integer[] ids);



}
