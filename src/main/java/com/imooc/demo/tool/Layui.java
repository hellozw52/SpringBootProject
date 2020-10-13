package com.imooc.demo.tool;

import java.util.HashMap;
import java.util.List;

/**
 * @Description layui数据接口统一格式
 * @Author zw
 * @Date 2020/10/13 14:46
 * @Param
 * @Return
**/
public class Layui extends HashMap<String, Object> {

    public static Layui data(Integer count, List<?> data) {
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}
