package io;

import java.io.File;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/7 14:34
 */
public class Demo4 {
    public static void main(String[] args) {
        File dir = new File("./testDir/aaa/bbb/ccc/ddd");
        // mkdir 只能创建出一级目录
        // dir.mkdir();
        // 可以创建多级目录
        dir.mkdirs();
        System.out.println(dir.isDirectory());
    }
}
