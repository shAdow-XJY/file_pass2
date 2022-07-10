package com.shadowplusing.file_pass2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class FilePass2ApplicationTests {

    void pathOne(){
        //获取跟目录
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!path.exists()) path = new File("");
        System.out.println("path: " + path.getAbsolutePath());

        File upload = new File(path.getAbsolutePath(),"static/images/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("images url: "+upload.getAbsolutePath());

        upload = new File(path.getAbsolutePath(),"static/videos/");
        if(!upload.exists()) upload.mkdirs();
        System.out.println("videos url: "+upload.getAbsolutePath());

    }

    @Test
    void contextLoads() {
        pathOne();
    }

}
