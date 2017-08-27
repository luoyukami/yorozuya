package com.luoyu.yorozuya.utils;

import com.luoyu.yorozuya.pojo.Result;
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

    public static Result uploadFile(byte[] file, String filePath, String fileName) {
        String realPath = filePath +"/"+ fileName;//创建文件的实际路径以及文件名

        Result result = new Result();
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
            result.setInfo("文件IO流异常");
            result.setSuccess(false);
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error("关闭文件输出流异常");
                    e.printStackTrace();
                    result.setInfo("关闭文件输出流异常");
                    result.setSuccess(false);
                }
            }
        }
        return result;
    }
}
