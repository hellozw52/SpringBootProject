package com.imooc.demo.service;

import com.github.pagehelper.PageHelper;
import com.imooc.demo.domain.User;
import com.imooc.demo.mapper.UserMapper;
import com.imooc.demo.tool.FieldTool;
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

    public List<Map<String, Object>> currentPageList(int page,int limit,String orderField,String orderType) {

        //排序字段  驼峰转下划线
        orderField = FieldTool.humpToUnderline(orderField);

        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(page,limit);
        //转为驼峰命名
        return formatHumpNameForList(userMapper.currentPageList(orderField,orderType));
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
            User user =  new User();
            user.setUsername(username);
            user.setPassword(password);
            //插入
            userMapper.add(user);
            //插入结果的自增id
            int insertResultId = user.getId();

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

    public List<Map<String, Object>> search(String username,String startime,String endtime,String orderField,String orderType,int page,int limit) {

        //排序字段  驼峰转下划线
        orderField = FieldTool.humpToUnderline(orderField);

        //查询条件  多个条件时 用map传参
        Map param = new HashMap();
        param.put("username",username);
        param.put("startime",startime);
        param.put("endtime",endtime);
        param.put("orderField",orderField);
        param.put("orderType",orderType);

        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(page,limit);
        //转为驼峰命名
        return formatHumpNameForList(userMapper.search(param));
    }

    public int searchTotalNum(String username,String startime,String endtime) {

        //查询条件  多个条件时 用map传参
        Map param = new HashMap();
        param.put("username",username);
        param.put("startime",startime);
        param.put("endtime",endtime);

        return userMapper.searchTotalNum(param).size();
    }

    public Map<String, Object> update(String id,String username, String password) {
        // 返回结果
        Map<String,Object> result = new HashMap<>();

        User user =  new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        //更新行数
        int updateNum = userMapper.update(user);

        if(updateNum ==1){
            result.put("result",true);
            result.put("msg","修改成功！");
        }else {
            result.put("result",false);
            result.put("msg","修改失败！");
        }

        return result;
    }
}
