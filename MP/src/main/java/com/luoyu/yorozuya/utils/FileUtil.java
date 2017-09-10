package com.luoyu.yorozuya.utils;

import com.luoyu.yorozuya.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.UUID;

/**
 * Created by 落羽 on 2017/8/21.
 */
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private static Integer READ_SIZE = 1024 * 1024;//每次读取文件的最大byte数

    /**
     * 文件上传
     * @param fileContent 文件内容
     * @param filePath 文件上传路径
     * @param fileName 文件名+类型
     * @return 操作结果
     */
    public static Result uploadFile(byte[] fileContent, String filePath, String fileName) {
        String realPath = filePath +"/"+ fileName;//创建文件的实际路径以及文件名

        Result result = new Result();
        File targetFile = new File(realPath);
        FileOutputStream out = null;
        try {
            if(!targetFile.exists() && !targetFile.createNewFile() ){
                throw new IOException("创建文件失败，请检查路径"+ realPath);
            }
            out = new FileOutputStream(targetFile);
            out.write(fileContent);
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

    /**
     * 读取文章内容
     * @param filePath
     * @param fileName
     * @return
     */
    public static Result getFileContent(String filePath, String fileName) {
        String realPath = filePath + (fileName == null ? "": "/" + fileName);
        Result result = new Result();
        File file = new File(realPath);
        FileInputStream inputStream = null;
        String content = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] bytes = new byte[READ_SIZE];
            StringBuffer stb = new StringBuffer();
            while ((inputStream.read(bytes)) != -1) {
                stb.append(new String(bytes));
            }
            content = stb.toString();
        } catch (IOException e) {
            result.setSuccess(false);
            result.setInfo("文件IO流异常"+ e.getMessage());
            logger.error("==========读取文件失败============");
            e.printStackTrace();
        }
        if (null != content && !content.isEmpty()) {
            result.setData(content);
        } else {
            result.setData("文件内容为空");
        }
        return result;
    }

    public static Result getFileContent(String realPath) {
        return getFileContent(realPath, null);
    }

    /**
     * 通过Reader读取文件内容
     * @param filePath 文件所在路径
     * @param fileName 文件名
     * @return 读取结果
     */
    public static Result getFileContentByReader(String filePath, String fileName) {
        String realPath = filePath + (fileName == null ? "": "/" + fileName);
        Result result = new Result();
        FileReader fr = null;
        BufferedReader br = null;
        String content = null;
        try {
            fr = new FileReader(realPath);
            br = new BufferedReader(fr);
            StringBuffer stb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                stb.append(line);
            }
            content = stb.toString();
        } catch (IOException e) {
            result.setSuccess(false);
            result.setInfo("文件IO流异常"+ e.getMessage());
            logger.error("==========读取文件失败============");
            e.printStackTrace();
        } finally {
            try {
                if(null != fr)
                    fr.close();
                if(null != br)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("==========关闭流文件读取异常============");
            }
        }
        if (null != content && !content.isEmpty()) {
            result.setData(content);
        } else {
            result.setData("文件内容为空");
        }
        return result;
    }

    public static Result getFileContentByReader(String realPath) {
        return getFileContentByReader(realPath, null);
    }

    /**
     * 获取去除 - 的UUID - 用于文件名
     * @return 去除出 - 的UUID
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
