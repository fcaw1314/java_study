package org.example.springioc.ioc.v2;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 20:03
 */
public class Framework {
    private Bottom bottom;

    public Framework(Bottom bottom) {
        this.bottom = bottom;
        System.out.println("Framework init....");
    }
}
