package thread;

/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/6/22 9:12
 */

class MyBlockingQueue {
    private String[] elems = null;
    //[head,tail)
    //head 指的是第一个元素,tail指的是最后一个元素的下一个元素
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public MyBlockingQueue(int capacity) {
        elems = new String[capacity];
    }

    void put(String elem) throws InterruptedException {
        synchronized (this) {
            while (size >= elems.length) {
                //队列满了
                this.wait();
            }
            // 把新的元素放到 tail 所在的位置上.
            elems[tail] = elem;
            tail++;
            if (tail >= elems.length) {
                //到达末尾,就回到开头
                tail = 0;
            }
            //更新size值
            size++;

            //唤醒下面take阻塞的wait操作
            this.notify();
        }
    }

    //出队列
    String take() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                //队列为空
                this.wait();
            }
            //取出head指向的元素
            String result = elems[head];
            head++;
            if (head >= elems.length) {
                head = 0;
            }
            size--;

            //take成功一个元素,就唤醒上面的put中的wait操作
            this.notify();
            return result;
        }
    }
}

public class Demo31 {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(1000);

        Thread t1 = new Thread(() -> {
            try {
                int count = 1;
                while (true) {
                    queue.put(count + "");
                    System.out.println("生产" + count);
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    String result = queue.take();
                    System.out.println("消费" + result);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}
