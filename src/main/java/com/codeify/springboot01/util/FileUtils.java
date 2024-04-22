package com.codeify.springboot01.util;

import cn.hutool.core.io.FileUtil;

import java.util.Base64;

public class FileUtils {
    public static void main(String[] args) {
        String filePath = "/Users/sunhanbing/IdeaProjects/study-springboot01/src/main/resources/static/hello.txt";
        byte[] bytes = FileUtil.readBytes(filePath);
        String str = Base64.getEncoder().encodeToString(bytes);
        System.out.println("str = " + str);
    }
}
