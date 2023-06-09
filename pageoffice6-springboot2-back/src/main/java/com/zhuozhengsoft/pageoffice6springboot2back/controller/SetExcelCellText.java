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
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/excel/SetExcelCellText")
public class SetExcelCellText {
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
        Cell cell = sheet.openCell("A1");
        cell.setValue("测试文本");
        cell.getFont().setBold(true); // 设置加粗
        cell.getFont().setItalic(true); // 设置斜体
        cell.getFont().setSize(20); // 设置20号字
        cell.getFont().setName("微软雅黑"); // 设置字体为：微软雅黑

        poCtrl.setWriter(wb); //必须。
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/excel/SetExcelCellText/test.xls", OpenModeType.xlsNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
