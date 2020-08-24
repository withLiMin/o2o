package com.imooc.o2o.util;

public class PathUtil {
    private  static String sepatator = System.getProperty("file.separator");
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/projectdev/image";
        } else {
            basePath = "/home/o2oimage/image";
        }
        basePath = basePath.replace("/",sepatator);
        return basePath;

    }
    public static String getShopImagePath(Long shopId){
        String imagePath = "upload/item/shop" + shopId + "/";
        return imagePath.replace("/",sepatator);
    }




}
