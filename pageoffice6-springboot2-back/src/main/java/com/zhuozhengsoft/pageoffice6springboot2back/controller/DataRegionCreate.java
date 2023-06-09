package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegionInsertType;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/word/DataRegionCreate")
public class DataRegionCreate {

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        WordDocument doc = new WordDocument();
        //创建数据区域，createDataRegion 方法中的三个参数分别代表“新建的数据区域名称”，“数据区域将要插入的位置”，
        //“与新建的数据区域相关联的数据区域名称”，若当前Word文档中尚无数据区域（书签）或者想在文档的最开头创建时，那么第三个参数为“[home]”
        //若想在文档的结尾处创建数据区域则第三个参数为“[end]”
        DataRegion dataRegion1 = doc.createDataRegion("reg1", DataRegionInsertType.After, "[home]");
        //设置创建的数据区域的可编辑性
        dataRegion1.setEditing(true);
        //给数据区域赋值
        dataRegion1.setValue("第一个数据区域\r\n");

        DataRegion dataRegion2 = doc.createDataRegion("reg2", DataRegionInsertType.After, "reg1");
        dataRegion2.setEditing(true);
        dataRegion2.setValue("第二个数据区域");

        poCtrl.setWriter(doc);
        //隐藏工具栏
        poCtrl.setCustomToolbar(false);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/DataRegionCreate/test.doc", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

}
