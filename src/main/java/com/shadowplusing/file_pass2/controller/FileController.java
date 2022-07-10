package com.shadowplusing.file_pass2.controller;


import com.shadowplusing.file_pass2.config.MediaHttpRequestHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

    String imagePath = System.getProperty("user.dir") + "\\static\\images\\img1.jpg";
    @GetMapping("/getImage")
    public void getImage(HttpServletResponse response){
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;

        try{
            System.out.println(imagePath);

            //根据 图片路径 实例一个 File对象
            File imgFile = new File(imagePath);
            if(!imgFile.exists()){
                return;
            }
            //根据 File对象 实例一个 文件流对象
            inputStream = new FileInputStream(imgFile);

            //http响应头设置返回类型type
            response.setContentType("image/jpg;charset=utf-8");
            //服务端输出流
            outputStream = response.getOutputStream();

            //将 文件流 写入 输出流
            int len = 0;
            byte[] buffer = new byte[1024 * 10];
            while ((len = inputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();

        } catch (FileNotFoundException e) {
            System.out.println("FileInputStream 实例化错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("response.getOutputStream 错误");
            e.printStackTrace();
        } finally {
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("outputStream 关闭错误");
                e.printStackTrace();
            }

            try {
                if(inputStream != null){
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("inputStream 关闭错误");
                e.printStackTrace();
            }
        }
    }

    String videoPath = System.getProperty("user.dir") + "\\static\\videos\\video1.mp4";
    @Resource
    private MediaHttpRequestHandler mediaHttpRequestHandler;
    @GetMapping("/getVideo")
    public void getVideo(HttpServletRequest request, HttpServletResponse response) throws Exception{

        Path path = Paths.get(videoPath);

        if(Files.exists(path)) {
            String contentType = Files.probeContentType(path);
            if(!StringUtils.hasLength(contentType)){
                response.setContentType(contentType);
            }

            request.setAttribute(MediaHttpRequestHandler.ATTR_FILE,path);
            mediaHttpRequestHandler.handleRequest(request,response);

        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }

    }
}
