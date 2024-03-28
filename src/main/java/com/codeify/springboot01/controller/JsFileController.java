package com.codeify.springboot01.controller;

import cn.hutool.core.io.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author codeify
 * @since 2024/03/05 12:22
 */
@Controller
@RequestMapping("/js")
public class JsFileController {
    @RequestMapping("/vue/{time}")
    public void lazyGetVue(@PathVariable Long time, HttpServletResponse res) {
        try {
//            String filePath = "/Users/sunhanbing/IdeaProjects/study-springboot01/src/main/resources/static/js/vue.js";
            String filePath = "classpath:static/js/vue.js";
            String fileName = FileUtil.getName(filePath);
            res.setHeader("content-disposition", "attachment;filename=" + fileName);
            ServletOutputStream outputStream = res.getOutputStream();
            // 延迟加载
            TimeUnit.SECONDS.sleep(time);
            FileUtil.writeToStream(filePath, outputStream);
//             关闭流
            outputStream.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
