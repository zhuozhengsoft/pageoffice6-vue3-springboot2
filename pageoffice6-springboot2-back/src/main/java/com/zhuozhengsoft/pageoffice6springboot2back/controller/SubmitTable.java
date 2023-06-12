package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

import static java.lang.System.out;

@RestController
@RequestMapping(value = "/word/SubmitTable")
public class SubmitTable {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        //打开数据区域
        DataRegion dTable = doc.openDataRegion("PO_table");
        //设置数据区域可编辑性
        dTable.setEditing(true);

        //打开数据区域中的表格，OpenTable(index)方法中的index为word文档中表格的下标，从1开始
        Table table1 = doc.openDataRegion("PO_Table").openTable(1);
        //设置表格边框样式
        table1.getBorder().setLineColor(Color.green);
        table1.getBorder().setLineWidth(WdLineWidth.wdLineWidth050pt);
        // 设置表头单元格文本居中
        table1.openCellRC(1, 2).getParagraphFormat().setAlignment(WdParagraphAlignment.wdAlignParagraphCenter);
        table1.openCellRC(1, 3).getParagraphFormat().setAlignment(WdParagraphAlignment.wdAlignParagraphCenter);
        table1.openCellRC(2, 1).getParagraphFormat().setAlignment(WdParagraphAlignment.wdAlignParagraphCenter);
        table1.openCellRC(3, 1).getParagraphFormat().setAlignment(WdParagraphAlignment.wdAlignParagraphCenter);

        // 给表头单元格赋值
        table1.openCellRC(1, 2).setValue("产品1");
        table1.openCellRC(1, 3).setValue("产品2");
        table1.openCellRC(2, 1).setValue("A部门");
        table1.openCellRC(3, 1).setValue("B部门");

        poCtrl.setWriter(doc);
        //设置保存数据的接口地址
        poCtrl.setSaveDataPage("/word/SubmitTable/save");
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/SubmitTable/test.docx", OpenModeType.docSubmitForm, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");//解决返回的数据中文乱码问题
        com.zhuozhengsoft.pageoffice.wordreader.WordDocument doc = new com.zhuozhengsoft.pageoffice.wordreader.WordDocument(request, response);
        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dataReg = doc.openDataRegion("PO_table");
        com.zhuozhengsoft.pageoffice.wordreader.Table table = dataReg.openTable(1);

        //输出提交的table中的数据
        out.print("表格中的各个单元的格数据为：<br/><br/>");
        StringBuilder dataStr = new StringBuilder();
        for (int i = 1; i <= table.getRowsCount(); i++) {
            dataStr.append("<div style='width:220px;'>");
            for (int j = 1; j <= table.getColumnsCount(); j++) {
                dataStr.append("<div style='float:left;width:70px;border:1px solid red;'>" + table.openCellRC(i, j).getValue() + "</div>");
            }
            dataStr.append("</div>");
        }
        out.print(dataStr.toString());

        //向客户端显示提交的数据
        doc.showPage(300, 300);
        doc.close();
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().write("表格中的各个单元的格数据为：<br/><br/>"+dataStr.toString());
    }

}
