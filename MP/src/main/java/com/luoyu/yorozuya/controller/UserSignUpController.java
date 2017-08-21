package com.luoyu.yorozuya.controller;

import com.luoyu.yorozuya.entity.UserSignUp;
import com.luoyu.yorozuya.service.UserSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

    @GetMapping(value = "/signUp")
    public UserSignUp signUp(@RequestParam String name,
                             @RequestParam String password){
        UserSignUp userSignUp = new UserSignUp(name, password);
        return userSignUpService.signUp(userSignUp);
    }

    @PostMapping(value = "/imageUpload")
    public String imageUpload(@RequestParam MultipartHttpServletRequest multiReq) {
        MultipartFile file = multiReq.getFile("image");
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
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
}
