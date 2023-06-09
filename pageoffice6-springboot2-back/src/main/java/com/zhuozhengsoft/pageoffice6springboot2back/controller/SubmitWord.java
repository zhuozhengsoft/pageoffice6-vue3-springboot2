package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice.wordwriter.DataRegion;
import com.zhuozhengsoft.pageoffice.wordwriter.WordDocument;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(value = "/word/SubmitWord")
public class SubmitWord {


    @RequestMapping(value = "/Word")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        WordDocument wordDoc = new WordDocument();
        //打开数据区域，openDataRegion方法的参数代表Word文档中的书签名称
        DataRegion dataRegion1 = wordDoc.openDataRegion("PO_userName");
        //设置DataRegion的可编辑性
        dataRegion1.setEditing(true);
        //为DataRegion赋值,此处的值可在页面中打开Word文档后自己进行修改
        dataRegion1.setValue("张三");

        DataRegion dataRegion2 = wordDoc.openDataRegion("PO_deptName");
        dataRegion2.setEditing(true);
        dataRegion2.setValue("开发部");
        poCtrl.setWriter(wordDoc);
        //添加自定义按钮
        //设置保存页面
        poCtrl.setSaveDataPage("/word/SubmitWord/save");//设置处理文件保存的请求方法

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/SubmitWord/test.docx", OpenModeType.docSubmitForm, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");//解决返回的数据中文乱码问题
        com.zhuozhengsoft.pageoffice.wordreader.WordDocument doc = new com.zhuozhengsoft.pageoffice.wordreader.WordDocument(request, response);
        //获取提交的数值
        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dataUserName = doc.openDataRegion("PO_userName");
        com.zhuozhengsoft.pageoffice.wordreader.DataRegion dataDeptName = doc.openDataRegion("PO_deptName");
        String content = "";
        ////getFormField获取PageOfficeCtrl控件所在页面Form域里的指定Form控件的值，此方法的参数指的是当前Form控件的id
        content += "公司名称：" +  java.net.URLDecoder.decode(doc.getFormField("txtCompany"), "UTF-8");
        content += "<br/>员工姓名：" + dataUserName.getValue();
        content += "<br/>部门名称：" + dataDeptName.getValue();
        doc.showPage(500, 400);
        doc.close();
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter().write(content);
    }

}
