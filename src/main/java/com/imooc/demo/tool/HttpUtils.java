package com.imooc.demo.tool;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP post请求
 */
public class HttpUtils {

    public static String doPost(String url, String json) {
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        String result =null;
        try {
            StringEntity s = new StringEntity(json, "UTF-8"); // 中文乱码在此解决
            s.setContentType("application/json");
            post.setEntity(s);
            HttpResponse res = HttpClients.createDefault().execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(res.getEntity());// 返回json格式：
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * post请求
     *
     * @param url
     * @param map
     * @return
     */
    public static String httpPost(String url, Map<String, Object> map) {
        try {
            HttpPost post = new HttpPost(url);
            //requestConfig post请求配置类，设置超时时间
            RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(50000).build();
            post.setConfig(requestConfig);
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getValue() != null && entry.getValue() != "") {
                    //用basicNameValuePair来封装数据
                    params.add(new BasicNameValuePair(entry.getKey(), entry.getValue() + ""));
                }
            }
            //在这个地方设置编码 防止请求乱码
            post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
//            GeneralLog.info(ModelName, "请求url:" + url);
//            GeneralLog.info(ModelName, "请求数据:" + map);
            CloseableHttpResponse httpResponse = HttpClients.createDefault().execute(post);
            //System.out.println("返回数据：" + httpResponse);
            String result = null;
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);// 取出应答字符串
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 设置cookie
     * @param cookieKey 键
     * @param cookieValue 值
     * @param effectTime 有效时间 秒
     * @param response
     */
    public static void putCookies(String cookieKey, String cookieValue, int effectTime, HttpServletResponse response){
        Cookie cookie = new Cookie(cookieKey, cookieValue);
        cookie.setPath("/");// tomcat下多应用共享
        try {
            URLEncoder.encode(cookieKey, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(effectTime);//过期时间30秒
        // 将Cookie添加到Response中,使之生效
        response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
    }



}
