package com.sxt.domain.mapper;


import com.sxt.domain.entity.User;
import com.sxt.domain.utils.PageBean;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 分页的使用
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    List<User> queryForPage1(int startIndex, int pageSize);

    List<User> queryForPage2(Map<String, Object> map);

    //分页实战方法（不用插件）
    Integer queryCount();

    List<User> queryForPage5(PageBean pageBean);

    //分页+模糊查询
    List<User> queryForPage6(Map<String, Object> map);

    Integer queryCount6(String keywords);


}
