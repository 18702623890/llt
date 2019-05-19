package test;

import java.io.File;
import java.io.IOException;

public class TestFileRename {
    public static void main(String args[]){
        File file = new File("D:\\1.txt");
        if (!file.isFile()) {
            try {
                System.out.println(323);
            file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //调用renameTo()前
        System.out.println(file.exists());
        file.renameTo(new File("D:\\2.txt"));
        //调用renameTo()后
        System.out.println(file.exists());
    }

    }

