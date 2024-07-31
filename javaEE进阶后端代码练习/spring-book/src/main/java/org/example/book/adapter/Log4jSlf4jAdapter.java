package org.example.book.adapter;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/29 16:43
 */
public class Log4jSlf4jAdapter implements Slf4jApi{

    private Log4j log4j;

    public Log4jSlf4jAdapter(Log4j log4j) {
        this.log4j = log4j;
    }

    @Override
    public void log(String msg) {
        log4j.print(msg);
    }
}
