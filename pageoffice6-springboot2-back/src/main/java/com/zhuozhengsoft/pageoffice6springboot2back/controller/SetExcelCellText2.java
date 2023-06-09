package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Cell;
import com.zhuozhengsoft.pageoffice.excelwriter.Sheet;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import com.zhuozhengsoft.pageoffice.excelwriter.XlHAlign;
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
@RequestMapping(value = "/excel/SetExcelCellText2")
public class SetExcelCellText2 {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/excel")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //定义Workbook对象
        Workbook wb = new Workbook();
        //定义Sheet对象，"Sheet1"是打开的Excel表单的名称
        Sheet sheet = wb.openSheet("Sheet1");

        Cell cC3 = sheet.openCell("C3");
        cC3.setValue("一月");
        //设置单元格背景样式
        cC3.setBackColor(Color.LIGHT_GRAY);
        cC3.setForeColor(Color.white);
        cC3.setHorizontalAlignment(XlHAlign.xlHAlignCenter);

        Cell cD3 = sheet.openCell("D3");
        cD3.setValue("二月");
        //设置单元格背景样式
        cD3.setBackColor(Color.green);
        cD3.setForeColor(Color.white);
        cD3.setHorizontalAlignment(XlHAlign.xlHAlignCenter);

        Cell cE3 = sheet.openCell("E3");
        cE3.setValue("三月");
        //设置单元格背景样式
        cE3.setBackColor(Color.red);
        cE3.setForeColor(Color.white);
        cE3.setHorizontalAlignment(XlHAlign.xlHAlignCenter);

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/SetExcelCellText2/test.xlsx", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
