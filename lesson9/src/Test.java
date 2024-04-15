/**
 * @ClassName: Test
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/15  14:15
 */

class Animal{
    public String name;
    public int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println(this.name+"正在吃饭\n");
    }

}
class Dog extends Animal{
    public Dog(String name,int age){
        super(name, age);
    }
    public void bark(){
        System.out.println(this.name+"汪汪叫");
    }

}
public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("圆圆",6);
        dog.bark();
    }
}
