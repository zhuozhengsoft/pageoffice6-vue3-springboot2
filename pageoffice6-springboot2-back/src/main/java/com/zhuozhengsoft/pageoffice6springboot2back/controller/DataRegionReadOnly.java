package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/word/DataRegionReadOnly")
public class DataRegionReadOnly {
    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument doc = new WordDocument();
        //打开数据区域，openDataRegion方法的参数代表Word文档中的书签名称
        doc.openDataRegion("PO_Buyer").setValue("北京幻想科技有限公司");
        doc.openDataRegion("PO_No").setValue("HT20230211");
        doc.openDataRegion("PO_ProductName").setValue("三防热敏标签纸");

        DataRegion  supplierNameDr = doc.openDataRegion("PO_Supplier");
        supplierNameDr.setValue("湖北某某有限公司");
        supplierNameDr.setEditing(true); // true代表当前数据区域可编辑，false为不可编辑。默认值是false

        DataRegion guarantorDr = doc.openDataRegion("PO_Guarantor");
        guarantorDr.setValue("张三");
        guarantorDr.setEditing(true);
        poCtrl.setWriter(doc);
        poCtrl.setSaveFilePage("/word/DataRegionReadOnly/save");//设置保存方法的url
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/DataRegionReadOnly/test.doc", OpenModeType.docSubmitForm, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/DataRegionReadOnly/" + fs.getFileName());
        fs.close();
    }
}
