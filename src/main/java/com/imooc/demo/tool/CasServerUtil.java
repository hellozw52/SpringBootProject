package com.imooc.demo.tool;

import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * 通过账号和密码获取CAS ticket票据
 *
 * 首先客户端提交用户名、密码、及Service三个参数，
 * 如果验证成功便返回用户的TGT(Ticket Granting Ticket)至客户端,
 * 然后客户端再根据 TGT 获取用户的 ST(Service Ticket)来进行验证登录。
 * 故名思意，TGT是用于生成一个新的Ticket(ST)的Ticket，
 * 而ST则是提供给客户端用于登录的Ticket，两者最大的区别在于，
 * TGT是用户名密码验证成功之后所生成的Ticket，并且会保存在Server中及Cookie中，
 * 而ST则必须是是根据TGT来生成，主要用于登录，并且当登录成功之后 ST 则会失效。
 */
public class CasServerUtil {

    //登录服务器地址
    private static String  CAS_SERVER_PATH = "http://192.168.0.39:8080/cas";

    //登录地址的token
    private static String  GET_TOKEN_URL = CAS_SERVER_PATH + "/v1/tickets";

    //目标返回的服务器的url， 同访问的地址必须完全一致，不然就会报错。
    private static String TAGET_URL = "http://192.168.0.39:8080/common/";
//    private static String TAGET_URL = "http://192.168.0.39:8080/common/notice/list?page=1&rows=15";


    private static CasServerUtil utils = null;

    private CasServerUtil(){}

    public static CasServerUtil getInstance(String casServerPath,String targetUrl){

        CAS_SERVER_PATH = casServerPath;

        GET_TOKEN_URL = CAS_SERVER_PATH + "/v1/tickets";

        TAGET_URL = targetUrl;

        if(utils == null){
            synchronized (CasServerUtil.class) {
                if(utils == null){
                    utils = new CasServerUtil();
                }
            }
        }
        return utils;
    }

    /**
     * 创建日期:2018年2月8日<br/>
     * 创建时间:下午7:26:32<br/>
     * 创建用户:yellowcong<br/>
     * 机能概要:通过用户名和密码来获取service ticket,通过这个可以免密码登录
     * @param username
     * @param password
     * @return
     */
    public String getSt(String username,String password){
        //先获取到 token generate ticket
        String tgt = utils.getTGT(username, password);

        if(StringUtils.isEmpty(tgt)){
            return "";
        }

        return utils.getST(tgt);
    }
    /**
     * 创建日期:2018年2月8日<br/>
     * 创建时间:下午6:36:54<br/>
     * 创建用户:yellowcong<br/>
     * 机能概要:获取到 （Tokent generate tiker ,token生成票据）tgt
     * @return
     */
    private String getTGT(String username,String password){
        String tgt = "";
        OutputStreamWriter out = null;
        BufferedWriter wirter  = null;
//        HttpsURLConnection conn = null;
        HttpURLConnection conn = null;
        try {
            //第一步，获取到tgt
            conn = (HttpURLConnection) openConn(GET_TOKEN_URL);
            String param ="username=" + URLEncoder.encode(username, "UTF-8");
            param += "&password" + "=" + URLEncoder.encode(password, "UTF-8");

            out = new OutputStreamWriter(conn.getOutputStream());
            wirter = new BufferedWriter(out);
            //添加参数到目标服务器
            wirter.write(param);
            wirter.flush();
            wirter.close();
            out.close();

            //获取token
            tgt = conn.getHeaderField("location");
            //获取返回值
            if (tgt != null && conn.getResponseCode() == 201) {
                tgt = tgt.substring(tgt.lastIndexOf("/") + 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return tgt;
    }

    /**
     * 创建日期:2018年2月8日<br/>
     * 创建时间:下午7:15:16<br/>
     * 创建用户:yellowcong<br/>
     * 机能概要:根据票据生成工具，获取st
     * @param tgt
     * @return
     */
    private String getST(String tgt){
        String serviceTicket = "";
        OutputStreamWriter out = null;
        BufferedWriter wirter  = null;
        HttpURLConnection conn = null;
        try {

            //第一步，获取到tgt
            conn = (HttpURLConnection) openConn(GET_TOKEN_URL+"/"+tgt);

            //需要访问的目标网站
            String param ="service=" + URLEncoder.encode(TAGET_URL, "utf-8");

            out = new OutputStreamWriter(conn.getOutputStream());
            wirter = new BufferedWriter(out);
            //添加参数到目标服务器
            wirter.write(param);
            wirter.flush();
            wirter.close();
            out.close();

            //获取返回的ticket票据
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line ="";
            while ((line = in.readLine()) != null) {
                serviceTicket = line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(conn != null){
                    conn.disconnect();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return serviceTicket;
    }

    /**
     * 创建日期:2018年2月8日<br/>
     * 创建时间:下午7:28:36<br/>
     * 创建用户:yellowcong<br/>
     * 机能概要:通过post表单提交来获取连接
     * @param urlk
     * @return
     * @throws Exception
     */
    private URLConnection openConn(String urlk) throws Exception {
//        URL url = new URL(urlk);
        URL url= new URL(null, urlk, new sun.net.www.protocol.http.Handler());
        HttpURLConnection hsu = (HttpURLConnection) url.openConnection();

        hsu.setDoInput(true);
        hsu.setDoOutput(true);
        hsu.setRequestMethod("POST");
        return hsu;
    }

    /**
     * 测试获取票据
     * @param args
     * @throws Exception
     */
//    public static void main(String [] args) throws Exception {
//        String username ="xnhdfx";
//        String password ="2e9b1b1428a9a249d8f1c50c213cbbf5";
//        String casServerPath = "http://192.168.0.39:8080/cas";
//        String targetUrl = "http://192.168.0.39:8080/common/";
//
//        CasServerUtil utils = CasServerUtil.getInstance(casServerPath,targetUrl);
//        String st = utils.getSt(username, password);
//        System.out.println(st);
//    }

}
