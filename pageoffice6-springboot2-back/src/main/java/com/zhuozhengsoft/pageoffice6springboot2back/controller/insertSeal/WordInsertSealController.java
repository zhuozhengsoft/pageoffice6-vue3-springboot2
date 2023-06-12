package com.zhuozhengsoft.pageoffice6springboot2back.controller.insertSeal;

import com.zhuozhengsoft.pageoffice.*;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping(value = "/word/InsertSeal/")
public class WordInsertSealController {
    //获取doc目录的磁盘路径
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";


    @RequestMapping(value = "BatchAddSeal/index")
    public String showindex(HttpServletRequest request) {
        return dir + "word/InsertSeal/BatchAddSeal/";
    }

    @RequestMapping(value = "BatchAddSeal/Edit")
    public String showBatchAddSealEdit(HttpServletRequest request) {
        String filePath = "";
        String id = request.getParameter("id").trim();
        if ("1".equals(id)) {
            filePath = "test1.docx";
        }
        if ("2".equals(id)) {
            filePath = "test2.docx";
        }
        if ("3".equals(id)) {
            filePath = "test3.docx";
        }
        if ("4".equals(id)) {
            filePath = "test4.docx";
        }

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/BatchAddSeal/save");
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/BatchAddSeal/" + filePath, OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "BatchAddSeal/AddSeal")
    public String showBatchAddSealAddSeal(HttpServletRequest request) {

        String path = request.getContextPath();
        String filePath = "";
        String id = request.getParameter("id").trim();
        if ("1".equals(id)) {
            filePath = "test1.docx";
        }
        if ("2".equals(id)) {
            filePath = "test2.docx";
        }
        if ("3".equals(id)) {
            filePath = "test3.docx";
        }
        if ("4".equals(id)) {
            filePath = "test4.docx";
        }

        FileMakerCtrl fmCtrl = new FileMakerCtrl(request);
        fmCtrl.setServerPage("/api/poserver.zz");
        //fmCtrl.setJsFunction_AfterDocumentOpened("AfterDocumentOpened()");
        fmCtrl.setJsFunction_OnProgressComplete("OnProgressComplete()");
        //设置保存文件的接口地址
        fmCtrl.setSaveFilePage("/word/InsertSeal/BatchAddSeal/save");
        fmCtrl.fillDocument("/doc/word/InsertSeal/BatchAddSeal/" + filePath, DocumentOpenType.Word);
        return fmCtrl.getHtmlCode("FileMakerCtrl1");
    }


    @RequestMapping("BatchAddSeal/save")
    public void save3(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/InsertSeal/BatchAddSeal/" + fs.getFileName());
        fs.close();
    }


    @RequestMapping(value = "AddSeal/Word1")
    public String showWord(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");
         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test1.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping(value = "AddSeal/Word2")
    public String showWord2(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test2.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word3")
    public String showWord3(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test3.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word4")
    public String showWord4(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test4.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word5")
    public String showWord5(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test5.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word6")
    public String showWord6(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test6.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word7")
    public String showWord7(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test7.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word8")
    public String showWord8(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test8.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word9")
    public String showWord9(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test9.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSeal/Word10")
    public String showWord10(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSeal/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSeal/test10.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSign/Word1")
    public String showWord11(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSign/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSign/test1.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping(value = "AddSign/Word2")
    public String showWord12(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSign/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSign/test2.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSign/Word3")
    public String showWord13(HttpServletRequest request, Map<String, Object> map) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSign/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSign/test3.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSign/Word4")
    public String showWord14(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSign/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSign/test4.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "AddSign/Word5")
    public String showWord15(HttpServletRequest request) {
        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);

        //设置保存文件的接口地址
        poCtrl.setSaveFilePage("/word/InsertSeal/AddSign/save");

         /**
         * 下面是以url方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.docx  2.file://D:/doc/test.docx两种方式。
         * 还可以支持openstream二进制输出流的方式(此方式支持集群部署)，例如：webOpen("/openstream?id=xx",...)。
         */
        poCtrl.webOpen("/doc/word/InsertSeal/AddSign/test5.docx", OpenModeType.docNormalEdit, "张三");
        return poCtrl.getHtmlCode();
    }


    @RequestMapping("/AddSeal/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/InsertSeal/AddSeal/" + fs.getFileName());
        fs.close();
    }

    @RequestMapping("/AddSign/save")
    public void save2(HttpServletRequest request, HttpServletResponse response) {
        FileSaver fs = new FileSaver(request, response);
        fs.saveToFile(dir + "word/InsertSeal/AddSign/" + fs.getFileName());
        fs.close();
    }

}
