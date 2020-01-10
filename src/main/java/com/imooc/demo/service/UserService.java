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

    /**
     * 登录功能
     * @return
     */
        public Map<String,Object> doLogin(String username,String password) {
        List<Map<String,Object>> userList = userMapper.doLogin(username,password);
        if (CollectionUtils.isEmpty(userList)) {
            LOG.info("根据用户名查找不到记录");
            return null;
        } else {
            Map<String,Object> user = userList.get(0);
            LOG.info("根据用户名查找结果：{}", user);
            return user;
        }
    }

    /**
     * @return
     */
    public List<Map<String,Object>> list() {
        List<Map<String,Object>> allUser = userMapper.list();
        return allUser;
    }
}
