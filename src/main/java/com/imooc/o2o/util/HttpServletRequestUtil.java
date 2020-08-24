package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author withlimin
 * @data 2019/12/30
 */
public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key){
        try {
            return Integer.decode(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }


    public static long getlong(HttpServletRequest request, String key){
        try {
            return Long.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1;
        }
    }

    public static Double getDouble(HttpServletRequest request, String key){
        try {
            return Double.valueOf(request.getParameter(key));
        }catch (Exception e){
            return -1d;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key){
        try {
            return Boolean.valueOf(request.getParameter(key));
        }catch (Exception e){
            return false;
        }
    }

    public static String getString(HttpServletRequest httpServletRequest, String key){
        try {
            String result = httpServletRequest.getParameter(key);
            if (result != null){
                result = result.trim();
            }
            if ("".equals(result)){
                result = null;
            }
            return result;
        }catch (Exception e){
            return null;
        }
    }
}
