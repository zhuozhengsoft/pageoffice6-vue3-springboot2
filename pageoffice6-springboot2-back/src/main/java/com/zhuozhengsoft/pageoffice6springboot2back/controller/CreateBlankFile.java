package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.DocumentVersion;
import com.zhuozhengsoft.pageoffice.FileSaver;
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
@RequestMapping(value = "/word/CreateBlankFile")
public class CreateBlankFile {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/Word")
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("save");
        poCtrl.webCreateNew("张三", DocumentVersion.Word2007); // 创建docx格式文档
        return  poCtrl.getHtmlCode();
    }
    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        FileSaver fs = new FileSaver(request, response);
        //getFormField获取PageOfficeCtrl控件所在页面Form域里的指定Form控件的值，此方法的参数指的是当前Form控件的id
        String fileName = fs.getFormField("fileName");
        fileName=java.net.URLDecoder.decode(fileName, "UTF-8");
        fs.saveToFile(dir + "word/CreateBlankFile/" +fileName + fs.getFileExtName());
        fs.close();
    }

}
