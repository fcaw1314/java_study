package org.example.springioc.ioc.v1;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 17:32
 */
public class Car {
    private Framework framework;

    public Car(int size) {
        framework = new Framework(size);
        System.out.println("Car init....");
    }

    public void run() {
        System.out.println("Car run....");
    }
}
