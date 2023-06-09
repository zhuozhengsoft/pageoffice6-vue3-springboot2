package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.*;
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
@RequestMapping(value = "/excel/ExcelBorder")
public class ExcelBorder {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/excel")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        Workbook wb = new Workbook();
        Sheet sheet = wb.openSheet("Sheet1");
        // 设置背景
        Table backGroundTable = sheet.openTable("A1:P200");
        //设置表格边框样式
        backGroundTable.getBorder().setLineColor(Color.white);

        // 设置单元格边框样式
        Border C4Border = sheet.openTable("C4:C4").getBorder();
        C4Border.setWeight(XlBorderWeight.xlThick);
        C4Border.setLineColor(Color.yellow);
        C4Border.setBorderType(XlBorderType.xlAllEdges);

        // 设置单元格边框样式
        Border B6Border = sheet.openTable("B6:B6").getBorder();
        B6Border.setWeight(XlBorderWeight.xlHairline);
        B6Border.setLineColor(Color.magenta);
        B6Border.setLineStyle(XlBorderLineStyle.xlSlantDashDot);
        B6Border.setBorderType(XlBorderType.xlAllEdges);

        //设置表格边框样式
        Table titleTable = sheet.openTable("B4:F5");
        titleTable.getBorder().setWeight(XlBorderWeight.xlThick);
        titleTable.getBorder().setLineColor(new Color(0, 128, 128));
        titleTable.getBorder().setBorderType(XlBorderType.xlAllEdges);

        //设置表格边框样式
        Table bodyTable2 = sheet.openTable("B6:F15");
        bodyTable2.getBorder().setWeight(XlBorderWeight.xlThick);
        bodyTable2.getBorder().setLineColor(new Color(0, 128, 128));
        bodyTable2.getBorder().setBorderType(XlBorderType.xlAllEdges);

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/ExcelBorder/test.xlsx", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
