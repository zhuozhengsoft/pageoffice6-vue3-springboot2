package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataTag;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/word/WordDataTag2")
public class WordDataTag2 {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //定义WordDocument对象
        WordDocument doc = new WordDocument();

        //定义DataTag对象
        DataTag deptTag = doc.openDataTag("{部门名}");
        //给DataTag对象赋值
        deptTag.setValue("B部门");
        deptTag.getFont().setColor(Color.GREEN);

        DataTag userTag = doc.openDataTag("{姓名}");
        userTag.setValue("李四");
        userTag.getFont().setColor(Color.GREEN);

        DataTag dateTag = doc.openDataTag("【时间】");
        dateTag.setValue(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
        dateTag.getFont().setColor(Color.BLUE);

        poCtrl.setWriter(doc);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/WordDataTag2/test2.doc", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

}
