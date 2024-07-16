package org.example.springioc.ioc.v1;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 19:54
 */
public class Bottom {
    private Tire tire;
    public Bottom(int size) {
        tire = new Tire(size);
        System.out.println("Bottom init...");
    }
}
