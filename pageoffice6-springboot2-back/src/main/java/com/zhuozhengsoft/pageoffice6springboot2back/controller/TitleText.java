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
@RequestMapping(value = "/basic/TitleText")
public class TitleText {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/word")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        //打开磁盘路径的话有两种写法：1.D:\\doc\\test.doc  2.file://D:/doc/test.doc
        poCtrl.webOpen("/doc/basic/TitleText/test.doc", OpenModeType.docNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }


}
