package com.zhuozhengsoft.pageoffice6springboot2back.controller.insertSeal;


import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/word/InsertSeal")
public class InsertSealController {
    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value = "/refresh")
    public String showrefresh(HttpServletRequest request) {

        copyFile(dir + "word/InsertSeal/AddSeal/test1_bak.doc", dir + "word/InsertSeal/AddSeal/test1.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test2_bak.doc", dir + "word/InsertSeal/AddSeal/test2.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test3_bak.doc", dir + "word/InsertSeal/AddSeal/test3.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test4_bak.doc", dir + "word/InsertSeal/AddSeal/test4.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test5_bak.doc", dir + "word/InsertSeal/AddSeal/test5.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test6_bak.doc", dir + "word/InsertSeal/AddSeal/test6.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test7_bak.doc", dir + "word/InsertSeal/AddSeal/test7.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test8_bak.doc", dir + "word/InsertSeal/AddSeal/test8.doc");
        copyFile(dir + "word/InsertSeal/AddSeal/test10_bak.doc", dir + "word/InsertSeal/AddSeal/test10.doc");

        copyFile(dir + "word/InsertSeal/AddSign/test1_bak.doc", dir + "word/InsertSeal/AddSign/test1.doc");
        copyFile(dir + "word/InsertSeal/AddSign/test2_bak.doc", dir + "word/InsertSeal/AddSign/test2.doc");
        copyFile(dir + "word/InsertSeal/AddSign/test3_bak.doc", dir + "word/InsertSeal/AddSign/test3.doc");
        copyFile(dir + "word/InsertSeal/AddSign/test4_bak.doc", dir + "word/InsertSeal/AddSign/test4.doc");
        copyFile(dir + "word/InsertSeal/AddSign/test5_bak.doc", dir + "word/InsertSeal/AddSign/test5.doc");

        copyFile(dir + "word/InsertSeal/BatchAddSeal/test1_bak.doc", dir + "word/InsertSeal/BatchAddSeal/test1.doc");
        copyFile(dir + "word/InsertSeal/BatchAddSeal/test2_bak.doc", dir + "word/InsertSeal/BatchAddSeal/test2.doc");
        copyFile(dir + "word/InsertSeal/BatchAddSeal/test3_bak.doc", dir + "word/InsertSeal/BatchAddSeal/test3.doc");
        copyFile(dir + "word/InsertSeal/BatchAddSeal/test4_bak.doc", dir + "word/InsertSeal/BatchAddSeal/test4.doc");

        return "复位成功！";
    }

    //拷贝文件
    private void copyFile(String oldPath, String newPath) {
        try {
            int bytesum = 0;
            int byteread = 0;
            File oldfile = new File(oldPath);
            if (oldfile.exists()) { //文件存在时
                InputStream inStream = new FileInputStream(oldPath); //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
                int length;
                while ((byteread = inStream.read(buffer)) != -1) {
                    bytesum += byteread; //字节数 文件大小
//                    System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                fs.close();
                inStream.close();
            }
        } catch (Exception e) {
            System.out.println("复制单个文件操作出错");
            e.printStackTrace();
        }
    }


}
