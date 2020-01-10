package com.imooc.demo.mapper;


import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<Map<String,Object>> doLogin(@Param("username") String username,@Param("password") String password);

    List<Map<String,Object>> list();

}