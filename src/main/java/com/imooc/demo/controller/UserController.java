package com.imooc.demo.controller;

import com.imooc.demo.log.ExecTime;
import com.imooc.demo.tool.JsonResult;
import com.imooc.demo.tool.LayuiResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 用户控制器
 * @Author zw
 * @Date 2020/7/22 20:07
 * @Param
 * @Return
**/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description 查询当前页面用户
     * @Author zw
     * @Date 2020/7/22 20:06
     * @Param [page, limit, orderField, orderType]
     * @Return com.imooc.demo.tool.LayuiResult
    **/
    @ExecTime(value = "记录接口结果和时间")
    @ResponseBody
    @RequestMapping("/listByListMap")
    public LayuiResult listByListMap(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @RequestParam("orderField") String orderField,
            @RequestParam("orderType") String orderType
    ) {
        listMap = userService.currentPageList(page, limit, orderField, orderType);
        listNum = userService.getUserTotalNum();
        return new LayuiResult().ok(listMap, listNum);
    }

    /**
     * @Description 登录
     * @Author zw
     * @Date 2020/7/22 20:05
     * @Param [username, password, request]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @ExecTime(value = "记录接口结果和时间")
    @ResponseBody
    @RequestMapping("login")
    public Map<String, Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        logger.info("进行登陆");
        //返回结果
        result = new HashMap<>();
        //获取一条结果
        map = userService.login(username, password);

        if (map != null) {
            // 账号密码存session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);

            result.put("result", "success");
            result.put("msg", "登录成功，欢迎您： " + username);
            result.put("url", "./frame.html");
        } else {
            result.put("result", "false");
            result.put("msg", "登录失败");
        }

        return result;
    }

    /**
     * @Description 新增
     * @Author zw
     * @Date 2020/7/22 20:08
     * @Param [username, password]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @ResponseBody
    @RequestMapping("add")
    public Map<String, Object> add(@RequestParam("username") String username, @RequestParam("password") String password) {
        logger.info("添加用户");
        //返回结果
        map = userService.add(username, password);
        return map;
    }

    /**
     * @Description 查询
     * @Author zw
     * @Date 2020/7/22 20:08
     * @Param [username, startime, endtime, page, limit, orderField, orderType]
     * @Return com.imooc.demo.tool.LayuiResult
    **/
    @ExecTime(value = "记录接口结果和时间")
    @ResponseBody
    @RequestMapping("/search")
    public LayuiResult search(
            @RequestParam("username") String username,
            @RequestParam("startime") String startime,
            @RequestParam("endtime") String endtime,
            @RequestParam("page") String page,
            @RequestParam("limit") String limit,
            @RequestParam("orderField") String orderField,
            @RequestParam("orderType") String orderType
    ) {
        logger.info("查询开始");

        int pagecc = Integer.parseInt((page == null || page == "0") ? "1" : page);// 开始位置
        int limitcc = Integer.parseInt((limit == null || limit == "0") ? "10" : limit);// 每页个数

        if (startime.equals("") || startime == null) {
            startime = "1860-01-01";
        }
        if (endtime.equals("") || endtime == null) {
            endtime = "2300-01-01";
        }

        listMap = userService.search(username, startime, endtime, orderField, orderType, pagecc, limitcc);
        listNum = userService.searchTotalNum(username, startime, endtime);

        return new LayuiResult(listMap, listNum);
    }

    /**
     * @Description 修改
     * @Author zw
     * @Date 2020/7/22 20:08
     * @Param [id, username, password]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @ResponseBody
    @RequestMapping("update")
    public Map<String, Object> update(
            @RequestParam("id") String id,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        logger.info("修改用户");
        //返回结果
        map = userService.update(id, username, password);
        return map;
    }

    /**
     * @Description 批量删除
     * @Author zw
     * @Date 2020/7/22 20:08
     * @Param [ids]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
    **/
    @ResponseBody
    @RequestMapping("delete")
    public Map<String, Object> delete(@RequestParam("ids") List<Integer> ids) {
        logger.info("批量删除");
        //返回结果
        map = userService.delete(ids);
        return map;
    }

    /**
     * @Description 通过shiro获取当前登录的账号
     * @Author zw
     * @Date 2020/10/10 14:11
     * @Param [request]
     * @Return com.imooc.demo.tool.JsonResult
    **/
    @ResponseBody
    @RequestMapping("getLoginInfo")
    public JsonResult getLoginInfo(
            HttpServletRequest request) {

        //shiro获取登录的username
        String username = (String) SecurityUtils.getSubject().getPrincipal();

        if(StringUtils.isEmpty(username)){
            return JsonResult.errorMsg("用户未登录！");
        }

        return JsonResult.ok(username);
    }

    /**
     * @Description 单点登录退出  清除所有session
     * @Author zw
     * @Date 2020/10/10 14:49
     * @Param [request]
     * @Return com.imooc.demo.tool.JsonResult
    **/
    @ResponseBody
    @RequestMapping("/logOut")
    public JsonResult logOut(HttpServletRequest request){
        // 清除session
        Enumeration<String> enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            request.getSession().removeAttribute(key);
        }
        //存放cas和子系统地址  用来单点退出
        result = new HashMap<>();
        result.put("casUrl",casUrl);
        result.put("demoUrl",demoUrl);
        return new JsonResult().ok(result);
    }

}