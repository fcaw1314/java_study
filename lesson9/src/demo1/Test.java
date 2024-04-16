package demo1;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  10:19
 */
class Shape {
    public void draw() {
        System.out.println("画出一个图形！！！");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形！！");
    }
}

class Tringle extends Shape {
    @Override
    public void draw() {
        System.out.println("🔺！！！");
    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("⚪！！！");
    }
}

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = {new Rect(), new Cycle(), new Rect(), new Tringle()};
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
