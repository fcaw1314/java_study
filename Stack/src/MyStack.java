import java.util.Arrays;

/**
 * @ProjectName: Stack
 * @Package: PACKAGE_NAME
 * @ClassName: MyStack
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/3 11:19
 * @Version: 1.0
 */
public class MyStack {

    public int[] elem;
    public int usedSize;

    public static final int DEFAULT_CAPACITY = 10;
    public MyStack() {
        this.elem = new int[DEFAULT_CAPACITY];
    }

    //压栈 入栈
    public void push(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    //出栈
    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空....");
        }
        int oldVal = elem[usedSize-1];
        usedSize--;
        //elem[usedSize] = null;
        return oldVal;
    }

    public boolean isEmpty() {
        return usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException("栈为空....");
        }
        return elem[usedSize-1];
    }
}