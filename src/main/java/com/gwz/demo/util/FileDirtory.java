package com.gwz.demo.util;

import java.io.File;

public class FileDirtory {
    public static String genChildDirectory(String realPath, String fileName) {
        int hashCode = fileName.hashCode();
        int dir1 = hashCode & 0xf;
        int dir2 = (hashCode & 0xf0) >> 4;
        String str = dir1 + File.separator + dir2;
        File file = new File(realPath, str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }
}
