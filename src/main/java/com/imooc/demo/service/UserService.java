package com.imooc.demo.service;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
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

    public Map<String, Object> add(String username, String password) {
        // 返回结果
        Map<String,Object> result = new HashMap<>();

        boolean isUserNameExsit = userMapper.checkUserNameExsit(username);
        // 账号已存在
        if(isUserNameExsit){
            result.put("result",false);
            result.put("msg","账号已存在，不能重复注册！");
            return result;
        }else {
            //插入结果的自增主键
            int insertResultId = userMapper.add(username,password);

            if(insertResultId>0){
                result.put("result",true);
                result.put("msg","账号添加成功！");
            }else {
                result.put("result",false);
                result.put("msg","账号添加失败！");
            }
        }
        return result;
    }
}
