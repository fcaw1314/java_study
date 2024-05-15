/**
 * @author yxb
 * @version 1.0
 * @description:
 * @date 2024/5/15 17:01
 */
public class BinarySearchTree {
    static class TreeNode{
       public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public boolean search(int val) {
        TreeNode cur = root;
        while(cur != null) {
            if(cur.val < val){
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }else {
                return true;
            }
        }
        return false;
    }

    public void insert(int val) {
        if(root == null) {
            root = new TreeNode(val);
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            } else if (cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else{
                return;
            }
        }
        //cur必须为空才能插入
        TreeNode node = new TreeNode(val);
        if(parent.val < val){
            parent.right = node;
        } else {
            parent.left = node;
        }
    }

    public void remove(int val) {
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null) {
            if(cur.val < val) {
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val) {
                parent = cur;
                cur = cur.left;
            }else {
                removeNode(parent,cur);
                return;
            }
        }
    }

    public void removeNode(TreeNode parent, TreeNode cur) {

        if(cur.left == root) {

        }else if(cur.right == root) {

        }else {

        }
    }
}
