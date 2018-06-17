package spring.log;

import java.util.Date;

public class Logger {
    public static void log(String info){
        System.out.println(new Date() + "添加了日志" + info);
    }
}
