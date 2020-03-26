package com.imooc.demo.mapper;

import com.imooc.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    List<Map<String,Object>> listByListMap();

}