package org.example.springioc.ioc.v2;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 20:02
 */
public class Car {
    private Framework framework;

    public Car(Framework framework) {
        this.framework = framework;
        System.out.println("car init...");
    }

    public void run() {
        System.out.println("car run...");
    }
}
