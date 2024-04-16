package demo1;

/**
 * @ClassName: Mouse
 * @Description: TODO
 * @author: 派大星
 * @date: 2024/4/16  16:20
 */
public class Mouse implements USB {

    @Override
    public void openDevice() {
        System.out.println("打开鼠标！！！");
    }

    public void click() {
        System.out.println("鼠标疯狂点击！！！");
    }

    @Override
    public void cloasedevice() {
        System.out.println("关闭鼠标！！！");
    }
}
