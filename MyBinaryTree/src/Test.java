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

    }
}