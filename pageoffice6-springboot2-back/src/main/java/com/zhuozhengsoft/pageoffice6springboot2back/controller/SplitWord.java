package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/word/SplitWord")
public class SplitWord {

    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument wordDoc = new WordDocument();
        //打开数据区域，openDataRegion方法的参数代表Word文档中的书签名称
        DataRegion dataRegion1 = wordDoc.openDataRegion("PO_test1");
        dataRegion1.setSubmitAsFile(true);
        DataRegion dataRegion2 = wordDoc.openDataRegion("PO_test2");
        dataRegion2.setSubmitAsFile(true);
        dataRegion2.setEditing(true);
        DataRegion dataRegion3 = wordDoc.openDataRegion("PO_test3");
        dataRegion3.setSubmitAsFile(true);
        poCtrl.setWriter(wordDoc);

        //设置保存页面
        poCtrl.setSaveDataPage("/word/SplitWord/save");//设置处理文件保存的请求方法
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/SplitWord/test.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = dir + "word/SplitWord/";
        com.zhuozhengsoft.pageoffice.wordreader.WordDocument doc = new com.zhuozhengsoft.pageoffice.wordreader.WordDocument(request, response);
        byte[] bWord;

        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dr1 = doc.openDataRegion("PO_test1");

        bWord = dr1.getFileBytes();

        FileOutputStream fos1 = new FileOutputStream(filePath + "new1.docx");
        fos1.write(bWord);
        fos1.flush();
        fos1.close();
        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dr2 = doc.openDataRegion("PO_test2");
        bWord = dr2.getFileBytes();
        FileOutputStream fos2 = new FileOutputStream(filePath + "new2.docx");
        fos2.write(bWord);
        fos2.flush();
        fos2.close();

        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dr3 = doc.openDataRegion("PO_test3");
        bWord = dr3.getFileBytes();
        FileOutputStream fos3 = new FileOutputStream(filePath + "new3.docx");
        fos3.write(bWord);
        fos3.flush();
        fos3.close();

        doc.close();
    }

}
