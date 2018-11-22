package offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wall
 * @date 2018/11/21  9:59
 * @description 从上到下打印二叉树
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
public class PrintFromTopToBottom {
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


        System.out.println(printFromTopToBottom_solution(node1));
        printFromTopToBottomByRow_solution(node1);
        printZ_mysolution(node1);
        printZ_solution(node1);
    }

    //从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

    /**
     * 思路：定义一个队列(先序遍历)
     * @param root 从根节点开始
     * @return
     */
    private static ArrayList<Integer> result = new ArrayList<>();
    private static LinkedList<TreeNode> linkedList = new LinkedList<>();
    private static ArrayList<Integer> printFromTopToBottom_solution(TreeNode root){
        if (root != null) {
            result.add(root.value);
            if (root.left != null) {
                linkedList.add(root.left);
            }
            if (root.right != null) {
                linkedList.add(root.right);
            }
            if (linkedList.size()>0) {
                printFromTopToBottom_solution(linkedList.pop());
            }
        }
        return result;
    }


    //分行从上到下打印二叉树
    //1.当层需要打印的节点数2.下层需要打印的节点数
    private static void printFromTopToBottomByRow_solution(TreeNode root){
        if (root == null) {
            return;
        }
        linkedList.add(root);
        //1.当层需要打印的节点数
        int current = 1;
        //2.下层需要打印的节点数
        int next = 0;
        while (linkedList.size() > 0) {
            TreeNode temp = linkedList.peek();
            linkedList.pop();
            System.out.print(temp.value+" ");

            if (temp.left != null) {
                next++;
                linkedList.add(temp.left);
            }
            if (temp.right != null) {
                next++;
                linkedList.add(temp.right);
            }
            current--;
            if (current == 0) {
                current = next;
                //下层节点重新计数
                next = 0;
                System.out.println();
            }
        }
    }


    //之字形打印二叉树
    //第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印。
    private static void printZ_mysolution(TreeNode root){
        //记录每层的节点数
        ArrayList<Integer> countList = new ArrayList<>();
        //记录每层的节点
        ArrayList<Integer> tempList = new ArrayList<>();
        if (root==null){
            return ;
        }
        //利用队列实现按层打印
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        //初始化
        linkedList.add(root);
        countList.add(1);
        //记录打印到第几个节点
        int count = 0;
        //判断是奇数层还是偶数层
        int index = 1;
        //记录每层的节点数
        int current = 1;
        int next = 0 ;
        while (linkedList.size()>0){

            TreeNode temp = linkedList.pop();
            tempList.add(temp.value);

            if (temp.left!=null){
                linkedList.add(temp.left);
                next++;
            }
            if (temp.right!=null){
                linkedList.add(temp.right);
                next++;
            }
            current--;

            count++;
            if (current==0){

                if (next!=0){
                countList.add(next);
                }
                //奇数层
                if (index%2!=0){
                    for (int i =count-countList.get(index-1);i <count;i++){
                        System.out.print(tempList.get(i)+" ");
                    }
                }
                //偶数层
                else {
                    for (int i =count-1;i >count-1-countList.get(index-1);i--){
                        System.out.print(tempList.get(i)+" ");
                    }
                }


                current = next;
                next=0;

                index++;
                System.out.println();
            }
        }
    }

    //按之字形顺序打印二叉树需要两个栈
    private static void printZ_solution(TreeNode root){
        if (root==null){
            return;
        }

        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        //初始化为奇数层(1)
        int isOddOrEven = 1;

        int current = 1;
        int next = 0;
        TreeNode temp;

        stackOdd.add(root);
        while (!stackOdd.empty()||!stackEven.empty()){

            //奇数层,先保存左节点，后保存右节点
            if (isOddOrEven%2!=0){
                temp = stackOdd.pop();
                System.out.print(temp.value+" ");
                if (temp.left!=null){
                    stackEven.add(temp.left);
                    next++;
                }
                if (temp.right!=null){
                    stackEven.add(temp.right);
                    next++;
                }
            }
            //偶数层,先保存右节点，后保存左节点
            else {
                temp = stackEven.pop();
                System.out.print(temp.value+" ");
                if (temp.right!=null){
                    stackOdd.add(temp.right);
                    next++;
                }
                if (temp.left!=null){
                    stackOdd.add(temp.left);
                    next++;
                }
            }


            current--;
            if (current==0){
               //判断是奇数层还是偶数层
                isOddOrEven++;

                current = next;
                next = 0;
                System.out.println();
            }
        }
    }
}
