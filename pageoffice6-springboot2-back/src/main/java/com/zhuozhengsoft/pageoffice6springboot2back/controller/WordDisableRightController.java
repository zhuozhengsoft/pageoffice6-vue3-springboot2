package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word/WordDisableRight")
public class WordDisableRightController {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument wordDoc = new WordDocument();
        wordDoc.setDisableWindowRightClick(true);//禁止word鼠标右键
        //wordDoc.setDisableWindowDoubleClick(true);//禁止word鼠标双击
        //wordDoc.setDisableWindowSelection(true);//禁止在word中选择文件内容
        poCtrl.setWriter(wordDoc);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/WordDisableRight/test.doc", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


}
