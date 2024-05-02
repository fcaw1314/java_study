import IndexException.IndexException;

/**
 * @ProjectName: MYSingleLIst
 * @Package: PACKAGE_NAME
 * @ClassName: MySingleList
 * @author: Yxb
 * @Description:
 * @Date: 2024/4/29 17:56
 * @Version: 1.0
 */
public class MySingleList implements IinkList{

    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val){
            this.val = val;
        }
    }

    //链表的属性  链表的头节点
    public ListNode head;//null

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
        }else {
            ListNode cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    @Override
    public boolean addIndex(int index, int data) throws IndexException {
        if(index < 0 || index > size()) {
            throw new IndexException("index不合法的: "+index);
        }
        ListNode node = new ListNode(data);
        if(head == null) {
            head = node;
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return false;
        }
        if(index == size()) {
            addLast(data);
            return false;
        }
        //中间插入
        ListNode cur = searchPrevIndex(index);
        node.next = cur.next;
        cur.next = node;
        return false;
    }

    private ListNode searchPrevIndex(int index) {
        ListNode cur = head;
        int count = 0;
        while (count != index-1) {
            cur = cur.next;
            count++;
        }
        return cur;

    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if(head == null) {
            return;
        }
        if(head.val == key) {
            head = head.next;
            return;
        }
        ListNode cur = findPrevKey(key);
        if(cur == null) {
            return;//没有你要删除的数字
        }
        ListNode del = cur.next;
        cur.next = del.next;
    }

    private ListNode findPrevKey(int key) {
        ListNode cur = head;
        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }else {
                cur = cur.next;
            }
        }
        return null;

    }

    @Override
    public void removeAllKey(int key) {
        if(head == null) {
            return;
        }
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        //除了头节点都删除完成了
        if(head.val == key) {
            head = head.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        head = null;
    }


}