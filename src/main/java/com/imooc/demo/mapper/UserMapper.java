package com.imooc.demo.mapper;

import com.imooc.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<Map<String,Object>> currentPageList();

    Map<String, Object> login(@Param("username") String username, @Param("password") String password);

    int getUserTotalNum();

    boolean checkUserNameExsit(String username);

    int add(User user);

    List<Map<String, Object>> search(Map param);

    List searchTotalNum(Map param);
}