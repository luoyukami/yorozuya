package com.luoyu.yorozuya.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 落羽 on 2017/8/21.
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static void uploadFile(byte[] file, String filePath, String fileName) {

        String realPath = filePath +"/"+ fileName;
        File targetFile = new File(realPath);
        FileOutputStream out = null;
        try {
            if(!targetFile.exists() && !targetFile.createNewFile() ){
                throw new IOException("创建文件失败，请检查路径"+ realPath);
            }
            out = new FileOutputStream(targetFile);
            out.write(file);
            out.flush();
        } catch (IOException e) {
            logger.error("文件IO流异常");
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("关闭文件输出流异常");
                    e.printStackTrace();
                }
            }
        }
    }
}
