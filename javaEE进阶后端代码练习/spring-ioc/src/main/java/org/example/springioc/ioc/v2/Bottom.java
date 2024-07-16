package org.example.springioc.ioc.v2;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 20:02
 */
public class Bottom {
    private Tire tire;
    public Bottom(Tire tire) {
        this.tire = tire;
        System.out.println("Bottom init...");
    }
}
