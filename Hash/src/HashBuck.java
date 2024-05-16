/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/5/16 15:24
 */
public class HashBuck {
    static class Node{
        public int key;
        public int val;

        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node[] array = new Node[10];
    public int usedSize;
    public static final double  LOAD_FACTOR = 0.75;


    public void push(int key,int val) {

        Node node = new Node(key,val);
        //1、找到位置
        int index = key % array.length;
        //2、遍历数组
        Node cur = array[index];
        /*if(cur == null) {
            //采用头插法插入数据
            array[index] = node;
            usedSize++;
            return;
        }*/
        while (cur != null) {
            if(cur.key == key) {
                //更新val
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        //我写的是 头插法
        node.next = array[index];
        array[index] = node;
        usedSize++;
        if( doLoadFactor() >= 0.75) {
            //处理了 重新哈希
            reSize();
        }
    }

    private void reSize() {
        Node[] newArray = new Node[array.length*2];
        //处理重新哈希
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                //记录下来 之前的cur.next
                Node curNext = cur.next;
                //进行头插法,插入到新数组
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }
        //把数据给到原数组 array
        array = newArray;
    }

    private double doLoadFactor() {
        return usedSize*1.0 / array.length;
    }


    public int get(int key) {
        //1、找到位置
        int index = key % array.length;
        //2、遍历数组
        Node cur = array[index];
        while (cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }

        return -1;
    }
}
