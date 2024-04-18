package demo2;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  17:39
 */
class Animal {
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

interface IFly {
    void fly();
}

interface IRun {
    void run();
}

interface ISwim {
    void swim();
}

class Dog extends Animal implements IRun {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println(this.name + "正在用4条腿跑！！！");
    }
}

class Frog extends Animal implements IRun, ISwim {

    public Frog(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println(this.name + "跳跳跳跑跑跑！！！！！");
    }

    @Override
    public void swim() {
        System.out.println(this.name + "青蛙游泳！！！");
    }
}

class Duck extends Animal implements IRun, ISwim, IFly {

    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println(this.name + "鸭子飞！");
    }

    @Override
    public void run() {
        System.out.println(this.name + "鸭子跑！");

    }

    @Override
    public void swim() {
        System.out.println(this.name + "鸭子游泳！");

    }
}

public class Test {
    public static void Running(IRun iRun) {
        iRun.run();
    }

    public static void Flying(IFly iFly) {
        iFly.fly();
    }

    public static void Swimming(ISwim iSwim) {
        iSwim.swim();
    }

    public static void main(String[] args) {
        Running(new Duck("唐老鸭",1));
        Running(new Dog("二狗子",1));
        Running(new Frog("青蛙",1));

    }
}
