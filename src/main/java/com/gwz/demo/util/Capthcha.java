package com.gwz.demo.util;

public class Capthcha {
    public String getRandomString(){
        final char[] charArrays="0123456789qwertuiopasfghjklzcxvbnmy".toCharArray();
        char []randomChars=new char[4];
        for(int i=0;i<4;i++){
            randomChars[i]=charArrays[(int)(Math.random()*charArrays.length)];
        }
        return (String.valueOf(randomChars));
    }
}
