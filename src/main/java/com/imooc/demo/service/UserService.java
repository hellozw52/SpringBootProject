package com.imooc.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.imooc.demo.entity.User;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author hellozw
 * @since 2020-05-16
 */
public interface UserService extends IService<User> {

    public List<Map<String, Object>> currentPageList(int page, int limit, String orderField, String orderType);

    public Map<String, Object> login(String username, String password);

    public int getUserTotalNum();

    public Map<String, Object> add(String username, String password);

    public List<Map<String, Object>> search(String username, String startime, String endtime, String orderField, String orderType, int page, int limit);

    public int searchTotalNum(String username, String startime, String endtime);

    public Map<String, Object> update(String id, String username, String password);

    public Map<String, Object> delete(List<Integer> ids);
}
