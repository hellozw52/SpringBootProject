package com.imooc.demo.service;

import com.imooc.demo.domain.User;
import com.imooc.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    public List<User> list() {
        return userMapper.selectAll();
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
