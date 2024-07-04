package thread;

class Point {

}

class PointBuilder {
    public static Point makePointByXY(double x, double y) {
        Point p = new Point();
//        p.setX(x);
//        p.setY(y);
        return p;
    }

    public static Point makePointByRA(double r, double a) {
        Point p = new Point();
//        p.setR(r);
//        p.setA(a);
        return p;
    }
}

public class Demo33 {
    public static void main(String[] args) {
        Point p = PointBuilder.makePointByXY(10, 20);
    }
}