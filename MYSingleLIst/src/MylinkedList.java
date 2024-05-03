/**
 * @ProjectName: MYSingleLIst
 * @Package: PACKAGE_NAME
 * @ClassName: MylinkedList
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/3 8:44
 * @Version: 1.0
 */
public class MylinkedList implements IinkList{
    static class ListNode{
        public int val = 0;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            last = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            last =node;
        }else {
            last.next = node;
            node.prev =last;
            last = node;
        }
    }

    @Override
    public boolean addIndex(int index, int data) {
        return false;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public void removeAllKey(int key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void display() {

    }

    @Override
    public void clear() {

    }
}