package io;

import java.io.File;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 14:17
 */
public class Demo3 {
    public static void main(String[] args) {
        //文件删除
        File f = new File("./text.txt");
        //f.delete();
        //进程结束之后再删除
        f.deleteOnExit();
        System.out.println(f.exists());
    }
}
