package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.WdParagraphAlignment;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@RestController
@RequestMapping(value = "/word/DataRegionStyle")
public class DataRegionStyle {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        DataRegion d1 = doc.openDataRegion("d1");
        d1.getFont().setColor(Color.BLUE);//设置数据区域文本字体颜色
        d1.getFont().setName("华文彩云");//设置数据区域文本字体样式
        d1.getFont().setSize(16);//设置数据区域文本字体大小
        d1.getParagraphFormat().setAlignment(
                WdParagraphAlignment.wdAlignParagraphCenter);//设置数据区域文本对齐方式

        DataRegion d2 = doc.openDataRegion("d2");
        d2.getFont().setColor(Color.orange);//设置数据区域文本字体颜色
        d2.getFont().setName("黑体");//设置数据区域文本字体样式
        d2.getFont().setSize(14);//设置数据区域文本字体大小
        d2.getParagraphFormat().setAlignment(
                WdParagraphAlignment.wdAlignParagraphLeft);//设置数据区域文本对齐方式

        DataRegion d3 = doc.openDataRegion("d3");
        d3.getFont().setColor(Color.magenta);//设置数据区域文本字体颜色
        d3.getFont().setName("华文行楷");//设置数据区域文本字体样式
        d3.getFont().setSize(12);//设置数据区域文本字体大小
        d3.getParagraphFormat().setAlignment(
                WdParagraphAlignment.wdAlignParagraphRight);//设置数据区域文本对齐方式

        poCtrl.setWriter(doc);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/DataRegionStyle/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "/Word2")
    public String Word2(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/DataRegionStyle/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

}
