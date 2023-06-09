package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word/WordCreateTable")
public class WordCreateTable {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument doc = new WordDocument();
        //在word中指定的"PO_table1"的数据区域内动态创建一个3行5列的表格
        Table table1 = doc.openDataRegion("PO_table1").createTable(3, 5, WdAutoFitBehavior.wdAutoFitWindow);
        //合并(1,1)到(3,1)的单元格并赋值
        table1.openCellRC(1, 1).mergeTo(3, 1);
        table1.openCellRC(1, 1).setValue("合并后的单元格");
        //给表格table1中剩余的单元格赋值
        for (int i = 1; i < 4; i++) {
            table1.openCellRC(i, 2).setValue("AA" + String.valueOf(i));
            table1.openCellRC(i, 3).setValue("BB" + String.valueOf(i));
            table1.openCellRC(i, 4).setValue("CC" + String.valueOf(i));
            table1.openCellRC(i, 5).setValue("DD" + String.valueOf(i));
        }

        //在"PO_table1"后面动态创建一个新的数据区域"PO_table2",用于创建新的一个5行5列的表格table2
        DataRegion drTable2 = doc.createDataRegion("PO_table2", DataRegionInsertType.After, "PO_table1");
        Table table2 = drTable2.createTable(5, 5, WdAutoFitBehavior.wdAutoFitWindow);
        //给新表格table2赋值
        for (int i = 1; i < 6; i++) {
            table2.openCellRC(i, 1).setValue("AA" + String.valueOf(i));
            table2.openCellRC(i, 2).setValue("BB" + String.valueOf(i));
            table2.openCellRC(i, 3).setValue("CC" + String.valueOf(i));
            table2.openCellRC(i, 4).setValue("DD" + String.valueOf(i));
            table2.openCellRC(i, 5).setValue("EE" + String.valueOf(i));
        }

        poCtrl.setWriter(doc);//此行必须
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/WordCreateTable/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

}
