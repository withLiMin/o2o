package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final Random r = new Random();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);

        } catch (IllegalStateException e) {
            logger.error(e.toString());
            e.printStackTrace();
        } catch (IOException e){
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    public static String generateThunbnail(InputStream thunmnailInputStream, String fileName, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFilExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName +extension;
        logger.debug("current relatieAddr is : " + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is : " + PathUtil.getImgBasePath() + relativeAddr);
        try {
            System.out.println("basePath is : --> " + basePath);
            Thumbnails.of(thunmnailInputStream)
                    .size(200,200).watermark(Positions.BOTTOM_RIGHT,
                    ImageIO.read(new File(basePath + "/watermark.jpg")),0.25f).outputQuality(0.8f)
                    .toFile(dest);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return relativeAddr;
    }

    public static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    public static String getFilExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getRandomFileName() {
        int ranNum = r.nextInt(89999)+10000;
        String noeTimeStr = sDateFormat.format(new Date());
        return noeTimeStr + ranNum;
    }

    /**
     * 编辑时删除之前相应的文件或目录
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath){
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if (fileOrPath.exists()){
            if (fileOrPath.isDirectory()){
                File[] files = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++){
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }


    public static void main(String[] args) throws IOException {
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File("D:/imageO2o/xiaohuangren.jpg"))
                .size(200,200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath + "/watermark.jpg")),0.25f).outputQuality(0.8f)
                .toFile("D:/imageO2o/xiaohuangrennew.jpg");
    }
}
