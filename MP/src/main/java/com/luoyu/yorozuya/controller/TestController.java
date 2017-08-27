package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.pojo.Article;
import com.luoyu.yorozuya.utils.FileUtil;
import com.mysql.jdbc.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.File;
import java.util.Map;

/**
 * @author ganxiang20970
 *         2017-08-21 22:55
 */
@Controller
public class TestController {

    @Value("${file.path}")
    private String filePath;

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String upload(
            @RequestParam(value = "file") MultipartFile multipartFile,
            Map<String, Object> map) {
        if (!multipartFile.isEmpty()) {
            try {
                File file = new File("/Users/gx/Downloads/QQDownloads/temp/upload/"+ multipartFile.getOriginalFilename());
                multipartFile.transferTo(file);
                map.put("msg", "success");
            } catch (IOException e) {
                map.put("msg", "error");
                e.printStackTrace();
            }
        } else {
            map.put("msg", "error");
        }
        return "msg";
    }

    @RequestMapping(value = "/uploadForm", method = RequestMethod.POST)
    public String uploadForm(Article article,
                             Map<String, Object> map) {
        if(null != article) {
            FileUtil.uploadFile(article.getContent().getBytes(), filePath, "test.txt");
            map.put("msg", "success");
        } else {
            map.put("msg", "error");
        }

        return "msg";
    }

    @GetMapping(value = "/upload")
    public String initUpload(Map<String, Object> map){
                map.put("msg", "test");
        return "form";
    }

}
