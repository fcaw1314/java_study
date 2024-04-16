package demo2;

/**
 * @ClassName: Text
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  11:11
 */
abstract class Shape{
    public abstract void draw();
}
class Rect extends Shape{
    @Override
    public void draw() {
        System.out.println("矩形!！！");
    }
}
public class Text {
    public static void main(String[] args) {
        Shape shape = new Rect();
        shape.draw();
    }
}
