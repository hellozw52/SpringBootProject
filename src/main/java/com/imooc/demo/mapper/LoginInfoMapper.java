package com.imooc.demo.mapper;

import com.imooc.demo.domain.LoginInfo;
import java.util.List;

public interface LoginInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginInfo record);

    LoginInfo selectByPrimaryKey(Integer id);

    List<LoginInfo> selectAll();

    int updateByPrimaryKey(LoginInfo record);
}