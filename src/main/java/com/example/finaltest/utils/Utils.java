package com.example.finaltest.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.Random;

public class Utils {
    private  static final char[] i= "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public  static  String NanoId(){
        int size = 12;
        return NanoIdUtils.randomNanoId(new Random(),i, size);
    }
}
