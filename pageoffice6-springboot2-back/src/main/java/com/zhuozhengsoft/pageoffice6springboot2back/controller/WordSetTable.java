package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.Table;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word/WordSetTable")
public class WordSetTable {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        //打开数据区域
        DataRegion dataRegion = doc.openDataRegion("PO_regTable");
        //打开table，openTable(index)方法中的index代表Word文档中table位置的索引，从1开始
        Table table = dataRegion.openTable(1);

        //给table中的单元格赋值， openCellRC(int,int)中的参数分别代表第几行、第几列，从1开始
        table.openCellRC(3, 1).setValue("A公司");
        table.openCellRC(3, 2).setValue("开发部");
        table.openCellRC(3, 3).setValue("李清");

        //插入一行，insertRowAfter方法中的参数代表在哪个单元格下面插入一个空行
        table.insertRowAfter(table.openCellRC(3, 3));

        table.openCellRC(4, 1).setValue("B公司");
        table.openCellRC(4, 2).setValue("销售部");
        table.openCellRC(4, 3).setValue("张三");

        poCtrl.setWriter(doc);

        //隐藏自定义工具栏
        poCtrl.setCustomToolbar(false);

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/WordSetTable/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


}
