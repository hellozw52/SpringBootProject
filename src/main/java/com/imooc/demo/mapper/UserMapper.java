package com.imooc.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imooc.demo.domain.User;
import com.imooc.demo.domain.ZdPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {

    List<Map<String, Object>> currentPageList(@Param("orderField") String orderField, @Param("orderType") String orderType);

    Map<String, Object> login(@Param("username") String username, @Param("password") String password);

    int getUserTotalNum();

    boolean checkUserNameExsit(String username);

    int add(User user);

    List<Map<String, Object>> search(Map param);

    List searchTotalNum(Map param);

    int update(User user);

    int delete(List<String> ids);
}