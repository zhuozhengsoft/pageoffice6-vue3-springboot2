package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.PDFCtrl;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/pdf/POPDF")
public class POPDF {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/pdf")
    @ResponseBody
    public String pdf(HttpServletRequest request) {

        PDFCtrl pdfCtrl  = new PDFCtrl(request);
        //打开pdf
        pdfCtrl.webOpen("/doc/pdf/POPDF/test.pdf");
        return  pdfCtrl.getHtmlCode("PDFCtrl1");
    }


}
