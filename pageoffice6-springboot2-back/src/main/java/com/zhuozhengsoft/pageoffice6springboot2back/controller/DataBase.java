package com.zhuozhengsoft.pageoffice6springboot2back.controller;

import com.zhuozhengsoft.pageoffice.FileSaver;
import com.zhuozhengsoft.pageoffice.OpenModeType;
import com.zhuozhengsoft.pageoffice.PageOfficeCtrl;
import com.zhuozhengsoft.pageoffice6springboot2back.util.GetDirPathUtil;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * @Author: dong
 * @Date: 2023/4/6 13:47
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/basic/DataBase")
public class DataBase {
    private String dir = GetDirPathUtil.getDirPath() + "static/doc/";

    @RequestMapping(value="/word")
    @ResponseBody
    public String word(HttpServletRequest request) {

        PageOfficeCtrl poCtrl = new PageOfficeCtrl(request);
        poCtrl.setSaveFilePage("save?id=1");//设置保存方法的url
         /**
         * 下面是二进制输出流的方式(此方式支持集群部署)方式打开文件的，还可以支持磁盘路径方式，例如：D:\\doc\\test.doc  2.file://D:/doc/test.doc两种方式。
         * 还可以支持url路径，例如：webOpen("doc/test.doc,...)。
         */
        poCtrl.webOpen("Openstream?id=1", OpenModeType.docNormalEdit, "张三");
        return  poCtrl.getHtmlCode();
    }

    @RequestMapping(value = "/Openstream")
    public void Openstream(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        String id = "2";
        if (request.getParameter("id") != null
                && request.getParameter("id").trim().length() > 0) {
            id = request.getParameter("id");
        }
        Class.forName("org.sqlite.JDBC");

        String strUrl = "jdbc:sqlite:" + ResourceUtils.getURL("classpath:").getPath() + "static/demodata/DataBase.db";
        Connection conn = DriverManager.getConnection(strUrl);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from stream where id = "
                + id);
        int newID = 1;
        if (rs.next()) {
            //******读取磁盘文件，输出文件流 开始*******************************
            byte[] imageBytes = rs.getBytes("Word");
            int fileSize = imageBytes.length;

            response.reset();
            response.setContentType("application/msword"); // application/x-excel, application/ms-powerpoint, application/pdf
            response.setHeader("Content-Disposition",
                    "attachment; filename=down.doc"); //fileN应该是编码后的(utf-8)
            response.setContentLength(fileSize);

            OutputStream outputStream = response.getOutputStream();
            outputStream.write(imageBytes);

            outputStream.flush();
            outputStream.close();
            outputStream = null;
            //******读取磁盘文件，输出文件流 结束*******************************
        }
        rs.close();
        conn.close();
    }
    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, FileNotFoundException, SQLException {
        FileSaver fs = new FileSaver(request, response);
        String err = "";
        if (request.getParameter("id") != null
                && request.getParameter("id").trim().length() > 0) {
            String id = request.getParameter("id").trim();
            Class.forName("org.sqlite.JDBC");
            String strUrl = "jdbc:sqlite:" + ResourceUtils.getURL("classpath:").getPath() + "static/demodata/DataBase.db";
            ;
            Connection conn = DriverManager.getConnection(strUrl);
            String sql = "UPDATE  Stream SET Word=?  where ID=" + id;
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(sql);
            pstmt.setBytes(1, fs.getFileBytes());
            //pstmt.setBinaryStream(1, fs.getFileStream(),fs.getFileSize());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            fs.setCustomSaveResult("ok");
        } else {
            err = "<script>alert('未获得文件的ID，保存失败');</script>";
        }
        fs.close();
    }


}
