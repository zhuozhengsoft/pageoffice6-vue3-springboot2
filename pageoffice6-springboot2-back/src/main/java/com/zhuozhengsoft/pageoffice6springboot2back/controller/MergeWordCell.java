package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.Table;
import com.zhuozhengsoft.pageoffice.wordwriter.WdParagraphAlignment;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@RestController
@RequestMapping(value = "/word/MergeWordCell")
public class MergeWordCell {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument doc = new WordDocument();
        DataRegion dataReg = doc.openDataRegion("PO_table");
        Table table = dataReg.openTable(1);
        //合并table中的单元格
        table.openCellRC(1, 1).mergeTo(1, 4);
        //给合并后的单元格赋值
        table.openCellRC(1, 1).setValue("销售情况表");
        //设置单元格文本样式
        table.openCellRC(1, 1).getFont().setColor(Color.red);
        table.openCellRC(1, 1).getFont().setSize(24);
        table.openCellRC(1, 1).getFont().setName("楷体");
        table.openCellRC(1, 1).getParagraphFormat().setAlignment(
                WdParagraphAlignment.wdAlignParagraphCenter);

        poCtrl.setWriter(doc);

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/MergeWordCell/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


}
