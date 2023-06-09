package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.excelwriter.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/excel/ExcelDisableRight")
public class ExcelDisableRightController {

    @RequestMapping(value = "/excel")
    public String showExcel(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        Workbook workBoook = new Workbook();
        workBoook.setDisableSheetRightClick(true);//禁止当前工作表鼠标右键
        //workBoook.setDisableSheetDoubleClick(true);//禁止当前工作表鼠标双击
        //workBoook.setDisableSheetSelection(true);//禁止在当前工作表中选择内容
        poCtrl.setWriter(workBoook);

        //打开Word文档
        poCtrl.webOpen("/doc/excel/ExcelDisableRight/test.xlsx", OpenModeType.xlsNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


}
