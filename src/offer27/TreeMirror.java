package offer27;

import java.util.LinkedList;

/**
 * @author wall
 * @date 2018/11/26  10:30
 * @description 二叉树的镜像
 * 输入：
 * 1
 * 2 3
 * 4 5 6 7
 * 8 9 10 11 12 13 14 15
 * 输出：
 * 1
 * 3 2
 * 7 6 5 4
 * 15 14 13 12 11 10 9 8
 */
//二叉树的数据结构
class TreeNode{
    int value;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int value){
        this.value = value;
    }
}
public class TreeMirror {
    //测试
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);
        TreeNode node15 = new TreeNode(15);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;

        printFromTopToBottom(node1);
        treeMirror_solution(node1);
        printFromTopToBottom(node1);
    }

    /**
     * 思路：前序遍历,交换非叶节点的左右子树
     * @param root 根节点
     */
    private static void treeMirror_solution(TreeNode root){
        if (root.left==null&&root.right==null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left!=null){
            treeMirror_solution(root.left);
        }
        if (root.right!=null){
            treeMirror_solution(root.right);
        }
    }

    //按层打印二叉树
    private static void printFromTopToBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int current = 1;
        int next = 0;
        while (!treeNodes.isEmpty()) {
            TreeNode temp = treeNodes.pop();
            System.out.print(temp.value + " ");

            if (temp.left != null) {
                treeNodes.add(temp.left);
                next++;
            }
            if (temp.right != null) {
                treeNodes.add(temp.right);
                next++;
            }
            current--;
            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }
        }
    }

}
