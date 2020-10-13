package com.imooc.demo.tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Description 读取locationinfo.txt手机归属地文件 每行数据
 * @Author zw
 * @Date 2020/10/13 14:38
 * @Param
 * @Return
**/
public class FileReadUtil {

//    public static void main(String[] args) {
////        String filePath = FileReadUtil.class.getResource("").getPath()+"aaa.txt"; // 文件路径
//        String filePath = "D://locationinfo.txt"; // 文件路径
//        read(filePath);
//    }

    /**
     * @Description 读取每行内容 控制台 生成插入的sql语句
     * @Author zw
     * @Date 2020/10/13 14:38
     * @Param [filePath]
     * @Return java.lang.String
    **/
    public static String read(String filePath) {
        BufferedReader br = null;
        String line = null;
        //StringBuffer buf = new StringBuffer();
        try {
            //根据文件路径创建缓冲输入流
            //filePath中是aaa.txt文件
            br = new BufferedReader(new FileReader(filePath));
            String str = "";

            //循环读取文件的每一行，对需要修改的行进行修改，放入缓冲对象中
            while ((line = br.readLine()) != null) {
                //设置正则将多余空格都转为一个空格
                str = line;
                String[] dictionary = str.split(",");
                for (int i = 0; i < dictionary.length; i++) {
                    str = "insert into sjgsd (sjhmq7,gsdyys) values('" + dictionary[0] + "','" + dictionary[1] + "');";
                }
                System.out.println(str);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                // 关闭流
                try {
                    br.close();
                } catch (IOException e) {
                    br = null;
                }
            }
        }
        return null;
    }
}
