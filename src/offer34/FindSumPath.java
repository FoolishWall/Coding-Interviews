package offer34;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2018/11/23  11:21
 * @description 二叉树中和为某一值的路径
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
public class FindSumPath {
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

        int sum = 18;
        findSumPath_mysolution(node1,sum);

    }
    private static ArrayList<Integer> path = new ArrayList<>();
    private static int temp = 0;
    private static void findSumPath_mysolution(TreeNode root,int sum){
        if (root==null){
            return;
        }
        path.add(root.value);
        temp += root.value;
        //到达叶节点
        if (root.left==null&&root.right==null){
            if (sum==temp){
                System.out.println(path);
            }
        }
        if (root.left!=null)
        findSumPath_mysolution(root.left,sum);
        if (root.right!=null)
        findSumPath_mysolution(root.right,sum);
        //清空路径
        path.remove(path.size()-1);
        //temp置零
        temp -= root.value;

    }

}
