package com.imooc.demo.tool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Description poi-tl 导出 word 表格
 * @Author zw
 * @Date 2020/10/13 14:49
 * @Param
 * @Return
**/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Table {
    String data1;
    String data2;
    String data3;
    String data4;
    String data5;
    String data6;
    String data7;
}
