package io;

import java.io.File;
import java.io.IOException;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 11:04
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //File f = new File("d:/text.txt");
        File f = new File("./text.txt");
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
    }
}
