package com.imooc.demo.service;

import com.imooc.demo.domain.User;
import com.imooc.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    public void insert(User user) {
        userMapper.insert(user);
    }

    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public List<User> list() {
        return userMapper.selectAll();
    }

    public User getOne(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
