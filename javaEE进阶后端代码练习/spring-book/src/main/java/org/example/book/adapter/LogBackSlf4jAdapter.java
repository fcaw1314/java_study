package org.example.book.adapter;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/29 16:43
 */
public class LogBackSlf4jAdapter implements Slf4jApi{

    private LogBack logBack;

    public LogBackSlf4jAdapter(LogBack logBack) {
        this.logBack = logBack;
    }

    @Override
    public void log(String msg) {
        logBack.out(msg);
    }
}
