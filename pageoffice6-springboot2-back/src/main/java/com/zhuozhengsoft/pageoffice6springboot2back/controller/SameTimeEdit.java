package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: dong
 * @Date: 2023/6/5 14:16
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/word/SameTimeEdit")
public class SameTimeEdit {
    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        String userName = request.getParameter("user");
        //***************************卓正PageOffice组件的使用********************************
        WordDocument doc = new WordDocument();
        //打开数据区域
        DataRegion d1 = doc.openDataRegion("PO_com1");
        DataRegion d2 = doc.openDataRegion("PO_com2");

        //给数据区域赋值
        d1.setValue("[word]/doc/word/SameTimeEdit/content1.doc[/word]");
        d2.setValue("[word]/doc/word/SameTimeEdit/content2.doc[/word]");


        //根据登录用户名设置数据区域可编辑性
        //甲客户：zhangsan登录后
        if (userName.equals("zhangsan")) {
            d1.setEditing(true);
            //若要将数据区域内容存入文件中，则必须设置属性“setSubmitAsFile”值为true
            d1.setSubmitAsFile(true);
            d2.setEditing(false);
        }
        //乙客户：lisi登录后
        else {
            d2.setEditing(true);
            d2.setSubmitAsFile(true);
            d1.setEditing(false);
        }

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setWriter(doc);


        //设置保存页
        poCtrl.setSaveDataPage("save?userName=" + userName);
        //打开Word文档
        poCtrl.webOpen("/doc/word/SameTimeEdit/test.doc", OpenModeType.docSubmitForm, userName);
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        com.zhuozhengsoft.pageoffice.wordreader.WordDocument doc = new com.zhuozhengsoft.pageoffice.wordreader.WordDocument(request, response);
        byte[] bytes = null;
        String filePath = "";
        if (request.getParameter("userName") != null && request.getParameter("userName").trim().equalsIgnoreCase("zhangsan")) {
            bytes = doc.openDataRegion("PO_com1").getFileBytes();
            filePath = "content1.doc";
        } else {
            bytes = doc.openDataRegion("PO_com2").getFileBytes();
            filePath = "content2.doc";
        }
        doc.close();

        filePath = dir + "word/SameTimeEdit/" + filePath;
        FileOutputStream outputStream = new FileOutputStream(filePath);
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

}


