package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Sheet;
import com.zhuozhengsoft.pageoffice.excelwriter.Table;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

@RestController
@RequestMapping(value = "/excel/SubmitExcel")
public class SubmitExcel {


    @RequestMapping(value = "/excel")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        //定义Workbook对象
        Workbook workBook = new Workbook();
        //定义Sheet对象，"Sheet1"是打开的Excel表单的名称
        Sheet sheet = workBook.openSheet("Sheet1");
        //定义table对象，设置table对象的设置范围
        Table table = sheet.openTable("B4:F13");
        //设置table对象的提交名称，以便保存页面获取提交的数据
        table.setSubmitName("Info");

        poCtrl.setWriter(workBook);
        //设置保存数据的接口地址
        poCtrl.setSaveDataPage("saveData");
        //打开Word文档
        poCtrl.webOpen("/doc/excel/SubmitExcel/test.xlsx", OpenModeType.xlsSubmitForm, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("/saveData")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");//解决返回的数据中文乱码问题
        com.zhuozhengsoft.pageoffice.excelreader.Workbook workBook = new com.zhuozhengsoft.pageoffice.excelreader.Workbook(request, response);
        com.zhuozhengsoft.pageoffice.excelreader.Sheet sheet = workBook.openSheet("Sheet1");
        com.zhuozhengsoft.pageoffice.excelreader.Table table = sheet.openTable("Info");
        String content = "";
        int result = 0;
        while (!table.getEOF()) {
            //获取提交的数值
            if (!table.getDataFields().getIsEmpty()) {
                content += "<br/>月份名称："
                        + table.getDataFields().get(0).getText();
                content += "<br/>计划完成量："
                        + table.getDataFields().get(1).getText();
                content += "<br/>实际完成量："
                        + table.getDataFields().get(2).getText();
                content += "<br/>累计完成量："
                        + table.getDataFields().get(3).getText();
                //out.print(table.getDataFields().get(2).getText()+"      mmmmmmmmmmmmm          "+table.getDataFields().get(1).getText());
                if (table.getDataFields().get(2).getText().equals(null)
                        || table.getDataFields().get(2).getText().trim().length() == 0
                ) {
                    content += "<br/>完成率：0%";
                } else {
                    float f = Float.parseFloat(table.getDataFields().get(2)
                            .getText());
                    f = f / Float.parseFloat(table.getDataFields().get(1).getText());
                    DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
                    content += "<br/>完成率：" + df.format(f * 100) + "%";
                }
                content += "<br/>*********************************************";
            }
            //循环进入下一行
            table.nextRow();
        }
        table.close();
        workBook.showPage(500, 400);
        workBook.close();
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().write(content);

    }

}
