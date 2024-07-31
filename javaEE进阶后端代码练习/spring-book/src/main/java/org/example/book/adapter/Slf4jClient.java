package org.example.book.adapter;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/30 10:49
 */
public class Slf4jClient {
    public static void main(String[] args) {
//        Log4j log4j = new Log4j();
//        log4j.print("Log4j打印日志");
//
//        LogBack logBack = new LogBack();
//        logBack.out();

        Slf4jApi api = new Log4jSlf4jAdapter(new Log4j());
        api.log("测试打印日志");

        Slf4jApi api2 = new LogBackSlf4jAdapter(new LogBack());
        api2.log("测试打印日志");
    }
}
