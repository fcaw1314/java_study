/**
 * @ProjectName: Hash
 * @Package: PACKAGE_NAME
 * @ClassName: HashBuck2
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/17 7:58
 * @Version: 1.0
 */
public class HashBuck2 <K,V>{
    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array = (Node<K,V>[])new Node[10];
    public int usedSize;
    public static final double  LOAD_FACTOR = 0.75;

    public void push(K key,V val) {
        Node<K,V> node = new Node<K,V>(key, val);

        int hash = key.hashCode();
        int index = hash % array.length;

        Node<K,V> cur = array[index];

        while (cur != null) {
            if(cur.key.equals(key)) {
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        node.next = array[index];
        array[index] = node;
        usedSize++;
        //重新哈希
    }

    public V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur != null) {
            if(cur.key.equals(key)) {
                return  cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}