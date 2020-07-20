package com.imooc.demo.interceptor;


import com.imooc.demo.tool.HttpUtils;
import com.imooc.demo.tool.WebServiceUtil;
import cz.mallat.uasparser.OnlineUpdater;
import cz.mallat.uasparser.UASparser;
import cz.mallat.uasparser.UserAgentInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/***
 * @description 登录拦截器
 * @author lwh
 * @Param
 * @date 2020/6/23 9:47
 * @return
 * @throws
 */
@Component
public class LogInterceptor implements HandlerInterceptor {

    @Value("${logUrl}")
    String logUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String username = request.getRemoteUser();//cas获取用户名
        String ip = WebServiceUtil.getIpAddr(request);// 操作用户的IP地址
        String userAgent = request.getHeader("user-agent");// 操作用户代理信息
        String url = request.getRequestURL().toString();// 操作的URI
        String urlPage = request.getRequestURI();//去除ip端口后的路径
        String urlData = request.getQueryString();//网址携带参数
        String method = request.getMethod(); // 操作的方式
        UASparser uasParser = new UASparser(OnlineUpdater.getVendoredInputStream());
        UserAgentInfo userAgentInfo = uasParser.parse(userAgent);
        String browser = userAgentInfo.getUaFamily();//浏览器名称
        String os = userAgentInfo.getOsName();//操作系统名称
        Map map = new HashMap();
        map.put("username", username);
        map.put("url", url);
        map.put("ip", ip);
        map.put("userAgent", userAgent);
        map.put("urlPage", urlPage);
        map.put("urlData", urlData);
        map.put("method", method);
        map.put("browser", browser);
        map.put("os", os);
        HttpUtils.httpPost(logUrl, map);
    }
}
