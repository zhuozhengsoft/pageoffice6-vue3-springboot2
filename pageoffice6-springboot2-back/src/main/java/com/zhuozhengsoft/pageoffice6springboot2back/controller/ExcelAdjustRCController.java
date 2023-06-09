package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Sheet;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/excel/ExcelAdjustRC")
public class ExcelAdjustRCController {

    @RequestMapping(value = "/excel")
    public String excel(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        Workbook wb = new Workbook();
        Sheet sheet1 = wb.openSheet("Sheet1");
        //设置当工作表只读时，是否允许用户手动调整行列。
        sheet1.setAllowAdjustRC(true);
        poCtrl.setWriter(wb);//此行必须

        //打开Word文档
        poCtrl.webOpen("/doc/excel/ExcelAdjustRC/test.xls", OpenModeType.xlsReadOnly, "张三");
        return poCtrl.getHtmlCode();
    }


}
