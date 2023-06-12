package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/basic/SendParameters")
public class SendParameters {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/word")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("save?p1=1");
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/basic/SendParameters/test.docx", OpenModeType.docNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }
    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        String value=request.getParameter("p1");//存页面的url中的?传递过来的参数
        //注意：getFormField方法的参数是form控件的id
        String age=fs.getFormField("p2");//Form控件input隐藏域传递过来的参数
        System.out.println("页面的url中的?传递过来的参数="+value+"\r\nForm控件input隐藏域传递过来的参数="+age);
        fs.saveToFile(dir + "basic/SendParameters/" + fs.getFileName());
        fs.close();
    }


}
