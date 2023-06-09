package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.Table;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word/TableInsertRow")
public class TableInsertRow {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        Table table1 = doc.openDataRegion("PO_T001").openTable(1);

        table1.openCellRC(1, 1).setValue("PageOffice组件");
        int dataRowCount = 5;//需要插入数据的行数
        int oldRowCount = 3;//表格中原有的行数
        // 扩充表格
        for (int j = 0; j < dataRowCount - oldRowCount; j++) {
            table1.insertRowAfter(table1.openCellRC(2, 5));  //在第2行的最后一个单元格下插入新行
        }
        // 填充数据
        int i = 1;
        while (i <= dataRowCount) {
            table1.openCellRC(i, 2).setValue("AA" + String.valueOf(i));
            table1.openCellRC(i, 3).setValue("BB" + String.valueOf(i));
            table1.openCellRC(i, 4).setValue("CC" + String.valueOf(i));
            table1.openCellRC(i, 5).setValue("DD" + String.valueOf(i));
            i++;
        }
        poCtrl.setWriter(doc);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/TableInsertRow/test_table.doc", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

}
