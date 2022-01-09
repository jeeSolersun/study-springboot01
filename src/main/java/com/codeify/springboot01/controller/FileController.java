package com.codeify.springboot01.controller;

import com.alibaba.excel.EasyExcel;
import com.codeify.springboot01.excel.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by sunhanbing on 2021/07/19 01:16
 */
@RequestMapping("/file")
@Controller
public class FileController {

    @RequestMapping("/sayHello2")
    @ResponseBody
    public Map sayHello2(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("msg", "hello22");
        return result;
    }

    @RequestMapping(value = "/upload")
    public void upload(MultipartFile fileData, HttpServletResponse response){
        ByteBuffer bf = ByteBuffer.allocate(1024 * 100);
        File file = new File("/Users/sunhanbing/MyProfiles/upload/".concat(fileData.getOriginalFilename()));
        try {
            ReadableByteChannel readableByteChannel = Channels.newChannel(fileData.getInputStream());
            FileChannel outputChannel = new FileOutputStream(file).getChannel();
            int len = -1;
            while((len = readableByteChannel.read(bf)) != -1){
                System.out.println(String.format("uploading...%s", len));
                bf.flip();
                outputChannel.write(bf);
                bf.clear();
            }
            readableByteChannel.close();
            outputChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/downloadExcel")
    @CrossOrigin
    public void downloadExcel(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf8");
//            String fileName = URLEncoder.encode("测试.xlsx", "utf8").replaceAll("\\+", "%20");
            String fileName = URLEncoder.encode("测试.xlsx", "utf8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            EasyExcel.write(response.getOutputStream(), UserData.class)
                    .sheet("用户数据")
                    .doWrite(getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<UserData> getData() {
        UserData aa = new UserData("1", "aa", 1);
        List<UserData> userData = Collections.nCopies(3, aa);
        return userData;
    }
}
