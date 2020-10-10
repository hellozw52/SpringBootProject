package com.imooc.demo.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @Description 登录获取权限
 * @Author zw
 * @Date 2020/9/2 15:54
 * @Param
 * @Return
 **/
public class MyCasRealm extends CasRealm {

    private static Logger log = LoggerFactory.getLogger(MyCasRealm.class);

//    //注入时一定加上懒加载  否则 shiro会导致事务报错！
//    @Lazy
//    @Autowired
//    private UserService userService;

    @Value("${shiro.casServerUrlPrefix}")
    private String casServerUrlPrefix;
    @Value("${shiro.shiroServerUrlPrefix}")
    private String shiroServerUrlPrefix;
    @Value("${shiro.casFilterUrlPattern}")
    private String casFilterUrlPattern;

    @PostConstruct
    public void initProperty(){
        setCasServerUrlPrefix(casServerUrlPrefix);
        // 客户端回调地址
        setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
    }

//    /**
//     * @Description 交由cas进行认证  可注释掉
//     * @Author zw
//     * @Date 2020/9/4 16:22
//     * @Param [token]
//     * @Return org.apache.shiro.authc.AuthenticationInfo
//     **/
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
//        //调用CasRealm实现的认证方法,其包含验证ticket、填充CasToken的principal等操作)
//        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);
//        String username = (String) authc.getPrincipals().getPrimaryPrincipal();
//        //获取登录用户的信息
//        Map user = userService.findByUsername(username);
//        //用户信息存在
//        if (user != null) {
////            System.out.println(user);
//            //将用户信息放在session
//            SecurityUtils.getSubject().getSession().setAttribute("user", user);
//            return authc;
//        } else {
//            return null;
//        }
//    }


//    /**
//     * @Description 权限认证，为当前登录的Subject授予角色和权限
//     * @Author zw
//     * @Date 2020/9/2 15:50
//     * @Param [principalCollection]
//     * @Return org.apache.shiro.authz.AuthorizationInfo
//     **/
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        log.info("##################执行Shiro权限认证##################");
//        //获取当前登录输入的用户名，等价于(String) principalCollection.fromRealm(getName()).iterator().next();
//        String loginName = (String)super.getAvailablePrincipal(principalCollection);
//        //到数据库查是否有此对象
////        int userNum = userService.findByUserNameMb(loginName);
//        int userNum = userService.findByUserName(loginName);// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        if(userNum>0){
//            //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
//            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//            //获取登录用户的所有角色名称集合
//            Set<String> userRolesName = new HashSet<>();
////            List<Map<String,Object>> listRolesName = userService.listRolesNameByLoginNameMb(loginName);
//            List<Map<String,Object>> listRolesName = userService.listRolesNameByLoginName(loginName);
//            for(Map<String,Object> map:listRolesName){
//                userRolesName.add(map.get("name").toString());
//            }
//            info.setRoles(userRolesName);
//
//            //用户的角色对应的所有权限  permission列表
//            Collection<String> permissionList = new ArrayList<String>();
////            List<Map<String,Object>> listPermissions = userService.listPermissionsByLoginNameMb(loginName);
//            List<Map<String,Object>> listPermissions = userService.listPermissionsByLoginName(loginName);
//
//            for(Map<String,Object> map:listPermissions){
//                permissionList.add(map.get("permission").toString());
//            }
//            info.addStringPermissions(permissionList);
//
//            return info;
//        }
//        // 返回null的话，就会导致任何用户访问被拦截的请求时，都会自动跳转到unauthorizedUrl指定的地址
//        return null;
//    }
}