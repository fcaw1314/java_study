/**
 * @ProjectName: MyBinaryTree
 * @Package: PACKAGE_NAME
 * @ClassName: Test
 * @author: Yxb
 * @Description:
 * @Date: 2024/5/4 19:57
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        binaryTree.preOrder(root);
        System.out.println();
        System.out.println("第k层结点个数:");
        System.out.println(binaryTree.getKLevelNodeCount(root,4));
        System.out.println("高度");
        System.out.println(binaryTree.getHeight(root));
        System.out.println("层序遍历");
        BinaryTree.levelOrder(root);
    }
}