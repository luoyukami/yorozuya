package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.UserSignUp;
import com.luoyu.yorozuya.service.UserSignUpService;
import com.luoyu.yorozuya.utils.FileUtil;
import com.luoyu.yorozuya.vo.TestJsonVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by 落羽 on 2017/8/17.
 * 测试的都放在这，不要纠结名字
 */
@RestController
@RequestMapping("/yorozuya")
public class UserSignUpController {

    @Autowired
    UserSignUpService userSignUpService;



    private static final Logger logger = LoggerFactory.getLogger(UserSignUpController.class);

    @GetMapping(value = "/signUp")
    public UserSignUp signUp(@RequestParam String name,
                             @RequestParam String password){
        UserSignUp userSignUp = new UserSignUp(name, password);
        return userSignUpService.signUp(userSignUp);
    }

    @GetMapping(value = "/jsonTest")
    public TestJsonVo jsontest(){
        TestJsonVo testJsonVo = new TestJsonVo();
        testJsonVo = userSignUpService.changeJson(testJsonVo);
        return testJsonVo;
    }


    // https://stackoverflow.com/questions/43936372/upload-file-springboot-required-request-part-file-is-not-present
    @PostMapping(value = "/upload")
    public @ResponseBody String uploader(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        logger.info("上传的文件名:" + fileName);
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffixName);
        // 存储路径
        String filePath = "D://upload//";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    // http://blog.csdn.net/change_on/article/details/59529034
//    @PostMapping(value = "/imageUpload")
//    public @ResponseBody String imageUpload(@RequestParam("file") MultipartFile file,
//                              HttpServletRequest request) {
//        if (file.isEmpty()) {
//            return "文件为空";
//        }
//        // 文件名
//        String fileName = file.getOriginalFilename();
//        System.out.println(fileName);
//        // 后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        System.out.println(suffixName);
//        // 存储路径
//        String filePath = "D://upload//";
//        // 解决中文问题，liunx下中文路径，图片显示问题
//        // fileName = UUID.randomUUID() + suffixName;
//        File dest = new File(filePath + fileName);
//        // 检测是否存在目录
//        if (!dest.getParentFile().exists()) {
//            dest.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(dest);
//            return "上传成功";
//        }catch (IllegalStateException e) {
//            e.printStackTrace();
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "上传失败";
//
//        String contentType = file.getContentType();
//        String fileName = file.getOriginalFilename();
//        /*System.out.println("fileName-->" + fileName);
//        System.out.println("getContentType-->" + contentType);*/
//        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
//        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//        //返回json
//        return "uploadimg success";
//    }
}
