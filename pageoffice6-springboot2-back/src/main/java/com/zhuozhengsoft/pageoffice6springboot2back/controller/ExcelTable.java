package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Sheet;
import com.zhuozhengsoft.pageoffice.excelwriter.Table;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/excel/ExcelTable")
public class ExcelTable {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/excel")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //定义Workbook对象
        Workbook wb = new Workbook();
        //定义Sheet对象，"Sheet1"是打开的Excel表单的名称
        Sheet sheet = wb.openSheet("Sheet1");
        //定义Table对象
        Table table = sheet.openTable("B4:F13");
        for (int i = 0; i < 50; i++) {
            table.getDataFields().get(0).setValue("产品 " + i);
            table.getDataFields().get(1).setValue("100");
            table.getDataFields().get(2).setValue(String.valueOf(100 + i));
            table.nextRow();
        }
        table.close();

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/ExcelTable/test.xlsx", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
