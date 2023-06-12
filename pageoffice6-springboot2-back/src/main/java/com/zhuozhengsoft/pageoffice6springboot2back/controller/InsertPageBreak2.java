package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegionInsertType;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

@RestController
@RequestMapping(value = "/word/InsertPageBreak2")
public class InsertPageBreak2 {
    private String dir = ResourceUtils.getURL("classpath:").getPath() + "static/doc/";

    public InsertPageBreak2() throws FileNotFoundException {
    }

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument doc = new WordDocument();
        DataRegion mydr1 = doc.createDataRegion("PO_first", DataRegionInsertType.After, "[end]");
        mydr1.selectEnd();
        doc.insertPageBreak();//插入分页符
        DataRegion mydr2 = doc.createDataRegion("PO_second", DataRegionInsertType.After, "[end]");
        mydr2.setValue("[word]/doc/word/InsertPageBreak2/test2.docx[/word]");

        poCtrl.setWriter(doc);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertPageBreak2/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertPageBreak2/test1.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/InsertPageBreak2/" + fs.getFileName());
        fs.close();
    }

}
