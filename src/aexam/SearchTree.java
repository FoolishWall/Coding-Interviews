package aexam;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author wall
 * @date 2019/7/31  9:32
 * @description
 * 题目：输出二叉搜索树的层序遍历
 * 输入：
 * 第一行：N（二叉搜索树的节点数）
 * 第二行：N个节点的值，空格隔开，换行结束
 * 输出：
 * 二叉搜索树的层序遍历结果
 * 例子：
 * 输入：
 * 9
 * 8 3 1 6 4 7 10 14 13
 * 输出：
 * 8 3 10 1 6 14 4 7 13
 *
 * 思路:1.构建二叉搜索树2.层次遍历
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
public class SearchTree {
    public static void main(String[] args) {
        int [] data = new int[]{8,3,1,6,4,7,10,14,13};
        TreeNode root = buildTree(data);
        showTreeInline(root);
    }

    /**
     * 构建二叉搜索树
     * @param data
     * @return
     */
    private static TreeNode buildTree(int [] data){
        TreeNode root = new TreeNode(data[0]);
        TreeNode currentTreeNode = root;
        //判断是否插入成功
        boolean insert = false;
        //遍历数组
        for(int i = 1;i < data.length;i++){
            while (!insert) {
                if (data[i] < currentTreeNode.value) {
                    if (currentTreeNode.left == null) {
                        currentTreeNode.left = new TreeNode(data[i]);
                        insert = true;
                    } else {
                        currentTreeNode = currentTreeNode.left;
                    }
                } else if (data[i] > currentTreeNode.value) {
                    if (currentTreeNode.right == null) {
                        currentTreeNode.right = new TreeNode(data[i]);
                        insert = true;
                    } else {
                        currentTreeNode = currentTreeNode.right;
                    }
                }
            }
            //遍历下一个节点，继续从根点开始比较
            insert = false;
            currentTreeNode = root;
        }
        return root;
    }

    /**
     * 层次遍历二叉搜索树
     * @param root
     */
    private static void showTreeInline(TreeNode root){
        //利用队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode currentTreeNode = null;
        //add方法向队列中添加元素,返回布尔值，add方法添加失败时会抛异常,不推荐使用
        //queue.add(root);
        // offer方法向队列中添加元素，返回布尔值
        queue.offer(root);
        while (!queue.isEmpty()){
            currentTreeNode = queue.peek();
            if (currentTreeNode.left != null){
                queue.add(queue.peek().left);
            }
            if (currentTreeNode.right != null){
                queue.add(currentTreeNode.right);
            }
            System.out.print(currentTreeNode.value+" ");
            queue.poll();
        }
    }
}
