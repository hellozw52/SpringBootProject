package com.imooc.demo.config;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasToken;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description CAS配置
 * @Author zw
 * @Date 2020/10/13 15:48
 * @Param
 * @Return
**/
public class MyCasFilter extends CasFilter {

    private static final String TICKET_PARAMETER = "ticket";

    public MyCasFilter() {

    }

    @Override
    public AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        // 获取请求的ticket
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String ticket = getRequestTicket(httpRequest);
        if (StringUtils.isEmpty(ticket)) {
            return null;
        }
        return new CasToken(ticket);
    }

    /**
     * 拒绝除了option以外的所有请求
     **/
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 获取ticket，如果不存在，直接返回false
        String ticket = getRequestTicket((HttpServletRequest) request);
        if (StringUtils.isEmpty(ticket)) {
            return false;
        }
        return this.executeLogin(request, response);
    }

    /**
     * 获取请求的ticket
     */
    private String getRequestTicket(HttpServletRequest httpRequest) {
        // 从参数中获取ticket
        String ticket = httpRequest.getParameter(TICKET_PARAMETER);
        if (StringUtils.isEmpty(ticket)) {
            // 如果为空的话，则从header中获取参数
            ticket = httpRequest.getHeader(TICKET_PARAMETER);
        }
        return ticket;
    }

}