package com.imooc.demo.tool;

import java.util.*;

/**
 * @Description 字段处理工具 下划线转驼峰  驼峰转下划线
 * @Author zw
 * @Date 2020/10/13 14:31
 * @Param
 * @Return
**/
public class FieldTool {

    private final static String UNDERLINE = "_";

    /**
     * @Description 将Map中的key由下划线转换为驼峰
     * @Author zw
     * @Date 2020/10/13 14:31
     * @Param [map]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
    **/
    public static Map<String, Object> formatHumpName(Map<String, Object> map) {
        Map<String, Object> newMap = new HashMap<String, Object>();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String key = entry.getKey();
            String newKey = toFormatCol(key);
            newMap.put(newKey, entry.getValue());
        }
        return newMap;
    }

    public static String toFormatCol(String colName) {
        StringBuilder sb = new StringBuilder();
        String[] str = colName.toLowerCase().split("_");
        int i = 0;
        for (String s : str) {
            if (s.length() == 1) {
                s = s.toUpperCase();
            }
            i++;
            if (i == 1) {
                sb.append(s);
                continue;
            }
            if (s.length() > 0) {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1));
            }
        }
        return sb.toString();
    }


    /**
     * @Description 将List中map的key值命名方式格式化为驼峰方式
     * @Author zw
     * @Date 2020/10/13 14:31
     * @Param [list]
     * @Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    **/
    public static List<Map<String, Object>> formatHumpNameForList(List<Map<String, Object>> list) {
        List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> o : list) {
            newList.add(formatHumpName(o));
        }
        return newList;
    }

    /**
     * @Description 驼峰转下划线
     * @Author zw
     * @Date 2020/10/13 14:31
     * @Param [str]
     * @Return java.lang.String
    **/
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }


    /**
     * @Description 驼峰命名转为下划线命名
     * @Author zw
     * @Date 2020/10/13 14:32
     * @Param [para]
     * @Return java.lang.String
    **/
    public static String humpToUnderline(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;
        if (!para.contains(UNDERLINE)) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    sb.insert(i + temp, UNDERLINE);
                    temp += 1;
                }
            }
        }
        return sb.toString().toLowerCase();
    }


//    public static void main(String[] args) {
//        String t = "createDate";
//        System.out.println(humpToUnderline(t));
//    }
}
