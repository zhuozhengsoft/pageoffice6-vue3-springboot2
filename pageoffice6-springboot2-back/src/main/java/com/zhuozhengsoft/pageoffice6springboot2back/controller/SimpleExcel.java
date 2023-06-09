package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
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
@RequestMapping(value = "/excel/SimpleExcel")
public class SimpleExcel {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/excel")
    @ResponseBody
    public String excel(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setSaveFilePage("save");//设置保存方法的url
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/SimpleExcel/test.xlsx", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }
    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "excel/SimpleExcel/" + fs.getFileName());
        fs.close();
    }


}
