package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.*;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;

import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/word/DataTagEdit")
public class DataTagEdit {
    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument doc = new WordDocument();
        doc.getTemplate().defineDataTag("{ 甲方 }");
        doc.getTemplate().defineDataTag("{ 乙方 }");
        doc.getTemplate().defineDataTag("{ 担保人 }");
        doc.getTemplate().defineDataTag("【 合同日期 】");
        doc.getTemplate().defineDataTag("【 合同编号 】");

        poCtrl.setSaveFilePage("/word/DataTagEdit/save");

        poCtrl.setTheme(ThemeType.Office2007);
        poCtrl.setBorderStyle(BorderStyleType.BorderThin);
        poCtrl.setWriter(doc);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/DataTagEdit/test.doc", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/DataTagEdit/" + fs.getFileName());
        fs.close();
    }

}
