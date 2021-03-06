package com.imooc.demo.controller;

import com.alibaba.fastjson.JSON;
import com.imooc.demo.tool.CasServerUtil;
import com.imooc.demo.tool.WebServiceUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description cas验证控制器
 * @Author zw
 * @Date 2020/7/22 20:12
 * @Param
 * @Return
**/
@Controller
@RequestMapping("/casAuth")
public class CasAuthController {

    @Resource
    Environment ymlConfig;//注入配置文件

    // 读取yml中 第三方CAS  账号  密码  cas服务路径
    private String USERNAME;
    private String PASSWORD;
    private String CAS_SERVER_PATH;

    // 目标返回的服务器的url， 同访问的地址必须完全一致，不然就会报错。
    private static String TAGET_URL = "";

    /**
     * @Description 根据账号，密码  获取CAS票据   直接登录
     * @Author zw
     * @Date 2020/7/22 20:12
     * @Param []
     * @Return java.lang.String
    **/
    @RequestMapping("/login")
    public String login() {
        //读取cas配置文件
        USERNAME = ymlConfig.getProperty("otherCas.username");
        PASSWORD = ymlConfig.getProperty("otherCas.password");
        CAS_SERVER_PATH = ymlConfig.getProperty("otherCas.casServerPath");

        TAGET_URL = ymlConfig.getProperty("otherCas.commonPath");
        //获取票据信息  直接登录
        String ticket = CasServerUtil.getInstance(CAS_SERVER_PATH, TAGET_URL).getSt(USERNAME, PASSWORD);
        return "redirect:" + TAGET_URL + "?ticket=" + ticket;
    }

    /**
     * @Description 获取cas内部数据  http://127.0.0.1:8001/demo/casAuth/getCasInterData?interfaceUrl=http://dsjpt.isct.cn:18087/common/notice/list?page=1%26rows=15
     * @Author zw
     * @Date 2020/7/22 20:12
     * @Param [interfaceUrl]
     * @Return com.alibaba.fastjson.JSON
    **/
    @ResponseBody
    @RequestMapping("/getCasInterData")
    public JSON getCasInterData(String interfaceUrl) throws IOException {
        //读取cas配置文件
        USERNAME = ymlConfig.getProperty("otherCas.username");
        PASSWORD = ymlConfig.getProperty("otherCas.password");
        CAS_SERVER_PATH = ymlConfig.getProperty("otherCas.casServerPath");

        TAGET_URL = interfaceUrl;
        //获取票据信息  通过接口url 和 票据参数  直接访问CAS内部数据
        String ticket = CasServerUtil.getInstance(CAS_SERVER_PATH, TAGET_URL).getSt(USERNAME, PASSWORD);
        interfaceUrl = TAGET_URL + "&ticket=" + ticket;

        //后台模拟浏览器打开接口url  获取数据结果
        String pageResult = WebServiceUtil.getPageResult(interfaceUrl);
        //返回结果
        JSON json = JSON.parseObject(pageResult);
        return json;
    }

}
