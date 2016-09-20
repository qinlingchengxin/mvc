package com.yx.utils;

/**
 * User: LiWenC
 * Date: 16-9-8
 */
public class Tools {

    /**
     * 判断多个字符串是否为空
     *
     * @param strings
     * @return
     */
    public static boolean isNotEmpty(String... strings) {
        if (strings == null || strings.length == 0) {
            return false;
        }
        for (String str : strings) {
            if (str == null || "".equals(str)) {
                return false;
            }
        }
        return true;
    }
}
