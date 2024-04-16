package demo1;

/**
 * @ClassName: KeyBoard
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  16:21
 */
public class KeyBoard implements USB {

    @Override
    public void openDevice() {
        System.out.println("打开键盘盘！！！");
    }

    public void inPut() {
        System.out.println("键盘输入！");
    }

    @Override
    public void cloasedevice() {
        System.out.println("关闭键盘盘！！！");
    }
}
