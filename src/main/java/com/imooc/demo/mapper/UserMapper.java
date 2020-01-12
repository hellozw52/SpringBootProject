package com.imooc.demo.mapper;


import com.imooc.demo.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询所有用户
    public List<User> selectAll();

    //查询一个用户
    public User selectById(Integer id);

    //添加用户
    public int insertUser(User user);

    //修改用户
    public int updateUser(User user);

    //删除用户
    public int deleteUser(Integer id);
}