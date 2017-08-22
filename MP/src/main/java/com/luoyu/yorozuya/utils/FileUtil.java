package com.luoyu.yorozuya.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by 落羽 on 2017/8/21.
 */
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
