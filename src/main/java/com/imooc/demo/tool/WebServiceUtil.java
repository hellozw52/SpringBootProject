package com.imooc.demo.tool;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 采用代理方式访问外网接口   解决浏览器跨域问题
 * 例如：号码归属地查询等功能
 * @author hellozw
 */
public class WebServiceUtil {
	
	/** 
     * 发送GET请求 
     *  
     * @param url 
     *            目的地址 
     * @param parameters 
     *            请求参数，Map类型。 
     * @return 远程响应结果 
     */  
    public static String sendGet(String url, Map<String, String> parameters) { 
        String result="";
        BufferedReader in = null;// 读取响应输入流  
        StringBuffer sb = new StringBuffer();// 存储参数  
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数  
            if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),  
                            "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8")).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }
            String full_url = url + "?" + params; 
            //System.out.println(full_url); 
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(full_url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 建立实际的连接  
            httpConn.connect();  
            // 响应头部获取  
//            Map<String, List<String>> headers = httpConn.getHeaderFields();  
            // 遍历所有的响应头字段  
//            for (String key : headers.keySet()) {  
//                System.out.println(key + "\t：\t" + headers.get(key));  
//            }  
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            
            // 存储输出结果
            List<String> list = new ArrayList<String>(); 
            
            String line= null;
            // 每行结果都存放在list中
	        if((line=in.readLine())!= null) { 
	            list.add(line); 
	        } 
	        
	        int lastindex = list.size()-1;
	        
	        result = list.get(lastindex);
	            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }
        return result ;
    }  
  
    /** 
     * 发送POST请求 
     *  
     * @param url 
     *            目的地址 
     * @param parameters 
     *            请求参数，Map类型。 
     * @return 远程响应结果 
     */  
    public static String sendPost(String url, Map<String, String> parameters) {  
        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入流  
        PrintWriter out = null;  
        StringBuffer sb = new StringBuffer();// 处理请求参数  
        String params = "";// 编码之后的参数  
        try {  
            // 编码请求参数  
            if (parameters.size() == 1) {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8"));  
                }  
                params = sb.toString();  
            } else {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8")).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }  
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 设置POST方式  
            httpConn.setDoInput(true);  
            httpConn.setDoOutput(true);  
            // 获取HttpURLConnection对象对应的输出流  
            out = new PrintWriter(httpConn.getOutputStream());  
            // 发送请求参数  
            out.write(params);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            
            // 存储输出结果
            List<String> list = new ArrayList<String>(); 
            
            String line=null;
            // 每行结果都存放在list中
	        if((line=in.readLine())!= null) { 
	            list.add(line); 
	        } 
	        
	        int lastindex = list.size()-1;
	        
	        result = list.get(lastindex);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }

    /**
     * 获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if(ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "localhost";
        }
        return ip;
    }

    /**
     * 获取项目地址  http://192.168.0.39:8080/hdfxyh/
     */
    public static String getProjectUrl(HttpServletRequest request) {
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getServletContext().getContextPath();
    }

    /**
     * 后台模拟浏览器打开url地址  获取页面结果  字符串
     */
    public static String getPageResult(String pageUrl) throws IOException {

        URL url =new URL(pageUrl);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(5*1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inStream,"utf-8");


        /*
         * int raed()
         * 读取一个字符，具体读取了几个字节字符流根据给定的字符集
         * 以及实际数据自行判断
         */
        int d = -1;
        final StringBuilder builder = new StringBuilder(10000000);
        while((d=inputStreamReader.read())!=-1) {
            builder.append((char) d);
        }
        String response = builder.toString();
//        System.out.print("response:"+response);
        inputStreamReader.close();
        return response;

    }
  
    /**
     * 主函数，测试请求
     *
     * @param args
     */
//    public static void main(String[] args) {
//        Map<String, String> parameters = new HashMap<String, String>();
//        parameters.put("tel", "15850781443");
//        String result =sendGet("http://mobsec-dianhua.baidu.com/dianhua_api/open/location", parameters);
//        System.out.println(result);
//    }
	
}
