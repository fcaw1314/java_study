package io;

import java.io.File;
import java.io.IOException;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 14:15
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File f = new File("./text.txt");

        // 调用创建文件方法, 把它创建出来.
        f.createNewFile();

        System.out.println(f.exists());
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());
    }
}
