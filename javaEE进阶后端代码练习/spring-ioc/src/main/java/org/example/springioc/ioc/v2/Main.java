package org.example.springioc.ioc.v2;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/7/16 20:03
 */
public class Main {
    public static void main(String[] args) {
        Tire tire = new Tire(250);
        Bottom bottom = new Bottom(tire);
        Framework framework = new Framework(bottom);
        Car car = new Car(framework);
        car.run();
    }
}
