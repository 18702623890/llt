package com.gwz.demo;

import com.jfinal.core.JFinal;

public class myWebApp {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 70, "/");

    }
}
