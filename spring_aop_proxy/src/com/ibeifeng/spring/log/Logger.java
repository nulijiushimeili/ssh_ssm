package com.ibeifeng.spring.log;

import java.util.Date;

/**
 * Created by zmzy on 2017/2/16.
 */
public class Logger {
    public static void log(String info){
        System.out.println(">>>>>>"+new Date()+"-----"+info);
    }
}
