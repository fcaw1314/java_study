package io;

import java.io.File;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 15:54
 */
public class Demo5 {
    public static void main(String[] args) {
        File f1 = new File("./text2.txt");
        File f2 = new File("./text8.txt");

        f1.renameTo(f2);
    }
}
