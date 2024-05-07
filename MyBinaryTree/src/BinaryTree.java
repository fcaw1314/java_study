import java.util.LinkedList;
import java.util.Queue;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @ProjectName: MyBinaryTree
 * @Package: PACKAGE_NAME
 * @ClassName: BinaryTree
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/4 19:16
 * @Version: 1.0
 */
public class BinaryTree {
    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
      //  E.right = H;
        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;//空树是不需要遍历的
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int nodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    void size(TreeNode root) {
        if(root == null){
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);

    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    int size2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int tmp = size2(root.left) +
                size2(root.right)+1;
        return tmp;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    void getLeafNodeCount1(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafNodeCount1(root.left);
        getLeafNodeCount1(root.right);

    }

    /*
     获取叶子节点的个数：子问题
     */
    int getLeafNodeCount2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left)
                + getLeafNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        } else {
            k--;
            return getKLevelNodeCount(root.left, k) +
                    getKLevelNodeCount(root.right, k);
        }
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = getHeight2(root.left);
        if(leftH < 0){
            return -1;
        }
        int rightH = getHeight2(root.right);
        if(leftH >=0 && rightH >= 0 && Math.abs(leftH-rightH) <= 1){
            return Math.max(leftH,rightH)+1;
        }
        return -1;

    }

    // 检测值为value的元素是否存在
    TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode leftVal = find(root.left, val);
        if(leftVal != null){
            return leftVal;
        }
        TreeNode rightVal = find(root.right, val);
        if(rightVal != null){
            return rightVal;
        }
        return null;
    }

    //层序遍历
    static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }


    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
      while (!queue.isEmpty()){
          TreeNode cur = queue.poll();
          if(cur != null){
              return false;
          }
      }
        return true;
    }

}