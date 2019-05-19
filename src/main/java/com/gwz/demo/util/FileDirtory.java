package com.gwz.demo.util;

import java.io.File;
<<<<<<< HEAD
=======
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
>>>>>>> 第一次更新

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
<<<<<<< HEAD
=======
    public  static String getFileMD5String(File file) throws Exception {
        char hexDigits[]={'0','1','2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        FileInputStream in=new FileInputStream(file);
        FileChannel channel=in.getChannel();
        MappedByteBuffer byteBuffer=channel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        messageDigest.update(byteBuffer);
        byte tmp[]=messageDigest.digest();
        int len=tmp.length;
        StringBuffer stringBuffer=new StringBuffer(2*len);
        for(int i=0;i<len;i++){
            char c0=hexDigits[(tmp[i] & 0xf0)>>4];
            char c1=hexDigits[(tmp[i] & 0xf)];
            stringBuffer.append(c0);
            stringBuffer.append(c1);
        }
        return stringBuffer.toString();

    }
>>>>>>> 第一次更新
}
