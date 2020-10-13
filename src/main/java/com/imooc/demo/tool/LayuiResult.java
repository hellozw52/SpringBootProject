package com.imooc.demo.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description 返回给layui的json结果
 * @Author zw
 * @Date 2020/10/13 14:47
 * @Param
 * @Return
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LayuiResult {

    //响应业务状态
    private Integer code;
    //响应消息
    private String msg;
    //响应中的数据
    private Object data;
    //数据个数
    private Integer count;


    public static LayuiResult ok(Object data) {
        return new LayuiResult(data);
    }

    public static LayuiResult ok(Object data, Integer count) {
        return new LayuiResult(data, count);
    }

    public static LayuiResult errorMsg(String msg) {
        return new LayuiResult(500, msg);
    }

    public LayuiResult(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    public LayuiResult(Object data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    public LayuiResult(Object data, Integer count) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
        this.count = count;
    }

    public LayuiResult(Integer errorCode, String msg) {
        this.code = errorCode;
        this.msg = msg;
    }
}
