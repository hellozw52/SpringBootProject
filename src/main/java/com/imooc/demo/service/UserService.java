package com.imooc.demo.service;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static com.imooc.demo.tool.FieldTool.formatHumpNameForList;

@Service
@Transactional//配置事务，如果失败即回滚
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserMapper userMapper;

    public List<Map<String, Object>> currentPageList(int page,int limit) {

        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(page,limit);
        //转为驼峰命名
        return formatHumpNameForList(userMapper.currentPageList());
    }

    public Map<String, Object> login(String username, String password) {
        return userMapper.login(username,password);
    }

    public int getUserTotalNum() {
        return userMapper.getUserTotalNum();
    }
}
