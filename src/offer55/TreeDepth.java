package offer55;

/**
 * @author wall
 * @date 2018/11/20  9:23
 * @description 二叉树的深度
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
public class TreeDepth {
    //测试
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(5);


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node6.right = node7;
        node7.left = node8;


    }

    /**
     *
     * @param node 从根节点开始
     * @return
     */
    private static int count = 0;
    private static int depth = 0;
    private static int treeDepth_mysolution(TreeNode node){
        //递归遍历
        if (node==null){
            return count;
        }
        count++;
        if (count>depth){
            depth = count;
        }
        treeDepth_mysolution(node.left);
        treeDepth_mysolution(node.right);
        count--;
        return depth;
    }

    private static int treeDepth_solution(TreeNode node){
        if (node==null){
            return 0;
        }
        int nLeft = treeDepth_solution(node.left);
        int nRight = treeDepth_solution(node.right);
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }


    private static boolean isBalance_solution(TreeNode node){
        if (node==null){
            return true;
        }
        int nLeft = treeDepth_solution(node.left);
        int nRight = treeDepth_solution(node.right);
        if (Math.abs(nLeft-nRight)>1){
            return false;
        }
        return isBalance_solution(node.left)&&isBalance_solution(node.right);
    }
}
