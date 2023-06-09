package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Cell;
import com.zhuozhengsoft.pageoffice.excelwriter.Sheet;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/excel/ExcelFill")
public class ExcelFill {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/excel")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //定义Workbook对象
        Workbook wb = new Workbook();
        //定义Sheet对象，"Sheet1"是打开的Excel表单的名称
        Sheet sheet = wb.openSheet("Sheet1");
        //定义Cell对象
        Cell cellB4 = sheet.openCell("B4");
        //给单元格赋值
        cellB4.setValue("1月");
        Cell cellC4 = sheet.openCell("C4");
        cellC4.setValue("300");
        Cell cellD4 = sheet.openCell("D4");
        cellD4.setValue("270");
        Cell cellE4 = sheet.openCell("E4");
        cellE4.setValue("270");
        Cell cellF4 = sheet.openCell("F4");
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        cellF4.setValue(df.format(270.00 / 300 * 100) + "%");

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/ExcelFill/test.xls", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
