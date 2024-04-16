package demo1;

/**
 * @ClassName: Computer
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  16:21
 */
public class Computer {


    public void powerOn() {
        System.out.println("打开笔记本电脑！！！");
    }


    public void powerOff() {
        System.out.println("关闭笔记本电脑！！！");
    }

    public void useDevice(USB usb) {
        usb.openDevice();
        if (usb instanceof Mouse) {
            Mouse mouse = (Mouse) usb;
            mouse.click();
        } else if (usb instanceof KeyBoard) {
            KeyBoard keyBoard = (KeyBoard) usb;
            keyBoard.inPut();
        }
        usb.cloasedevice();
    }
}
