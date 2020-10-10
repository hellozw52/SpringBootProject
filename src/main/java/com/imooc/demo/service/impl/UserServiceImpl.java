package com.imooc.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.imooc.demo.domain.User;
import com.imooc.demo.mapper.UserMapper;
import com.imooc.demo.service.UserService;
import com.imooc.demo.tool.FieldTool;
import com.imooc.demo.tool.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.imooc.demo.tool.FieldTool.formatHumpNameForList;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-16
 */
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    protected UserMapper userMapper;

    @Override
    public List<Map<String, Object>> currentPageList(int page, int limit, String orderField, String orderType) {
        //排序字段  驼峰转下划线
        orderField = FieldTool.humpToUnderline(orderField);

        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(page, limit);
        //转为驼峰命名
        return formatHumpNameForList(userMapper.currentPageList(orderField, orderType));
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public int getUserTotalNum() {
        return userMapper.getUserTotalNum();
    }

    @Override
    public Map<String, Object> add(String username, String password) {
        // 返回结果
        Map<String, Object> result = new HashMap<>();

        boolean isUserNameExsit = userMapper.checkUserNameExsit(username);
        // 账号已存在
        if (isUserNameExsit) {
            result.put("result", false);
            result.put("msg", "账号已存在，不能重复注册！");
            return result;
        } else {
            User user = new User();
            user.setUsername(username);
            //进行md5加密 入库
            password = MD5Util.string2MD5(password);
            user.setPassword(password);
            //插入
            userMapper.add(user);
            //插入结果的自增id
            int insertResultId = user.getId();

            if (insertResultId > 0) {
                result.put("result", true);
                result.put("msg", "账号添加成功！");
            } else {
                result.put("result", false);
                result.put("msg", "账号添加失败！");
            }
        }
        return result;
    }

    @Override
    public List<Map<String, Object>> search(String username, String startime, String endtime, String orderField, String orderType, int page, int limit) {

        //排序字段  驼峰转下划线
        orderField = FieldTool.humpToUnderline(orderField);

        //查询条件  多个条件时 用map传参
        Map param = new HashMap();
        param.put("username", username);
        param.put("startime", startime);
        param.put("endtime", endtime);
        param.put("orderField", orderField);
        param.put("orderType", orderType);

        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(page, limit);
        //转为驼峰命名
        return formatHumpNameForList(userMapper.search(param));
    }

    @Override
    public int searchTotalNum(String username, String startime, String endtime) {

        //查询条件  多个条件时 用map传参
        Map param = new HashMap();
        param.put("username", username);
        param.put("startime", startime);
        param.put("endtime", endtime);

        return userMapper.searchTotalNum(param).size();
    }

    @Override
    public Map<String, Object> update(String id, String username, String password) {
        // 返回结果
        Map<String, Object> result = new HashMap<>();

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(MD5Util.string2MD5(password));
        //更新行数
        int updateNum = userMapper.update(user);

        if (updateNum == 1) {
            result.put("result", true);
            result.put("msg", "修改成功！");
        } else {
            result.put("result", false);
            result.put("msg", "修改失败！");
        }

        return result;
    }

    @Override
    public Map<String, Object> delete(List<String> ids) {
        Map<String, Object> result = new HashMap<>();

        int deleteNum = userMapper.delete(ids);
        if (deleteNum > 0) {
            result.put("result", true);
            result.put("msg", "删除成功！");
        } else {
            result.put("result", false);
            result.put("msg", "删除失败！");
        }
        return result;
    }
}
