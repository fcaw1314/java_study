package demo1;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  16:21
 */
public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        Mouse mouse = new Mouse();
        KeyBoard keyBoard = new KeyBoard();
        computer.useDevice(mouse);
        System.out.println("===================");
        computer.useDevice(keyBoard);
        computer.powerOff();
    }
}
