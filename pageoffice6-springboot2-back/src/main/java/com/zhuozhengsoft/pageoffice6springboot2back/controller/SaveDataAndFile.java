package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/basic/SaveDataAndFile")
public class SaveDataAndFile {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/word")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        //设置PO_deptName和PO_userName这两个数据区域可编辑
        doc.openDataRegion("PO_deptName").setEditing(true);
        doc.openDataRegion("PO_userName").setEditing(true);
        poCtrl.setWriter(doc);

        poCtrl.setSaveDataPage("SaveData"); //设置保存数据时的接口地址
        poCtrl.setSaveFilePage("SaveFile");//设置保存文件时的接口地址
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/basic/SaveDataAndFile/test.doc", OpenModeType.docSubmitForm, "张三");
        return  poCtrl.getHtmlCode();
    }
    @RequestMapping("/SaveFile")
    public void saveFile(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "basic/SaveDataAndFile/" + fs.getFileName());
        fs.close();
    }
    @RequestMapping("/SaveData")
    public void saveData(HttpServletRequest request, HttpServletResponse response) {
        com.zhuozhengsoft.pageoffice.wordreader.WordDocument doc = new com.zhuozhengsoft.pageoffice.wordreader.WordDocument(request, response);
        //获取提交的数值
        String contractNum = doc.openDataRegion("PO_deptName").getValue();
        String contractDate = doc.openDataRegion("PO_userName").getValue();
        String contractId = doc.getFormField("contractId");//getFormField的参数是Form控件的id
        /**
         *实际开发中，这块代码一般是连接数据库将上面获取的数据更新到数据库中
         */
        doc.close();
    }


}
