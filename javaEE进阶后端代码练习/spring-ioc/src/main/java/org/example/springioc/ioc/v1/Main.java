package org.example.springioc.ioc.v1;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 17:31
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car(17);
        car.run();
    }
}
