package com.zhuozhengsoft.pageoffice6springboot2back.controller;

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
import java.awt.*;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/excel/ExcelFill2")
public class ExcelFill2 {
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
        //设置文本颜色为红色
        cellB4.setForeColor(Color.red);

        Cell cellC4 = sheet.openCell("C4");
        cellC4.setValue("300");
        cellC4.setForeColor(Color.green);

        Cell cellD4 = sheet.openCell("D4");
        cellD4.setValue("270");
        cellD4.setForeColor(Color.blue);

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/ExcelFill2/test.xls", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
