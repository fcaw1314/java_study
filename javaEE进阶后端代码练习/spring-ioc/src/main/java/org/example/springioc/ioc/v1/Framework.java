package org.example.springioc.ioc.v1;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 19:52
 */
public class Framework {
    private Bottom bottom;
    public Framework(int size) {
        bottom = new Bottom(size);
        System.out.println("Framework init...");
    }
}
