package offer54;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2018/11/26  15:42
 * @description 二叉搜索树的第k大节点
 * 思路：中序遍历
 */
//二叉树的数据结构
class TreeNode{
    int value = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int value){
        this.value = value;
    }
}
public class KthTreeNode {
    //测试
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        int k = 5;
        System.out.println(kthTreeNode_mysolution(node1,k).value);

        System.out.println(kthTreeNode_solution(node1,k).value);
    }

    /**
     *
     * @param root 根节点
     * @param k 第k大节点
     * @return 返回第k大节点
     */
    private static ArrayList<TreeNode> data = new ArrayList<>();
    private static TreeNode kthTreeNode_mysolution(TreeNode root,int k){
        print_LDRTree(root);
        return data.get(k-1);
    }

    private static void print_LDRTree(TreeNode root){
        if (root==null){
            return;
        }
        if (root.left!=null){
            print_LDRTree(root.left);
        }
        data.add(root);
        if (root.right!=null){
            print_LDRTree(root.right);
        }
    }


    //优化时间效率的解法（剑指offer上的解法）
    private static int index = 0;
    private static TreeNode kthTreeNode_solution(TreeNode root,int k){
        if (root==null||k<1){
            return null;
        }
        TreeNode result = null;
        if (root.left!=null){
            result = kthTreeNode_solution(root.left,k);
        }
        if (result==null){
            index++;
            if (k==index)
                result=root;

        }
        if (result==null&&root.right!=null){
            result = kthTreeNode_solution(root.right,k);
        }
        return result;
    }

}
