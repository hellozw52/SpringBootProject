package com.imooc.demo.service;

import com.imooc.demo.domain.User;
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

    public List<Map<String, Object>> listByListMap() {
        //转为驼峰命名
        return formatHumpNameForList(userMapper.listByListMap());
    }
}
