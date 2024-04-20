/**
 * @projectName: Computer.java
 * @package: PACKAGE_NAME
 * @className: Test
 * @author: Eric
 * @description: TODO
 * @date: 2024/4/19 15:18
 * @version: 1.0
 */
class Money implements Cloneable{
    public double m = 19.99;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
class Person implements Cloneable{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Money money = new Money();
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person tmp = (Person)super.clone();
        tmp.money = (Money) this.money.clone();
        return tmp;
    }
}

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("张三",23);
        Person person2 = (Person) person.clone();

        System.out.println(person.money.m);
        System.out.println(person2.money.m);
        System.out.println("==============================");
        person.money.m=99.99;
        System.out.println(person.money.m);
        System.out.println(person2.money.m);



    }
}