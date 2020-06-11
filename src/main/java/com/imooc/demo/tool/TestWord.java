package com.imooc.demo.tool;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.HackLoopTableRenderPolicy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestWord {

    public static void main(String[] args) throws IOException {
        HackLoopTableRenderPolicy policy = new HackLoopTableRenderPolicy();

        Configure config = Configure.newBuilder()
                .bind("table1", policy).build();

        List<Table> table1 = new ArrayList<>();
        Table t1 = new Table();
        t1.setData1("111");
        t1.setData2("222");
        t1.setData3("333");
        t1.setData4("444");
        t1.setData5("555");
        t1.setData6("666");
        t1.setData7("777");
        table1.add(t1);


        XWPFTemplate template = XWPFTemplate.compile("D:\\test.docx", config).render(
                new HashMap<String, Object>() {{
                    put("table1", table1);
                }}
        );

        downloadLocalhost(template);
    }

    /**
     * 下载至本地
     *
     * @param template
     */
    public static File downloadLocalhost(XWPFTemplate template) {
        try {
            File file = new File("D:/test1.docx");
            FileOutputStream out = new FileOutputStream(file);
            template.write(out);
            out.flush();
            out.close();
            template.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
