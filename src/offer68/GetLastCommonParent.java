package offer68;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2019/2/25  16:47
 * @description 树中两个节点的最低公共祖先
 */
//二叉树的数据结构
class TreeNode<T>{
    T value;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(T value){
        this.value = value;
    }
}
public class GetLastCommonParent {
    //测试
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
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

        System.out.println(getLastCommonParent_solution(node1,node12,node14));
    }

    /**
     * 树中8,10的最低公共祖先为2
     * @param root 树的根节点
     * @return 返回最低公共祖先(-1表示程序出错)
     */
    @SuppressWarnings("unchecked")
    private static int getLastCommonParent_solution(TreeNode root,TreeNode pNode1,TreeNode pNode2){
        //从根节点中序遍历树到指定节点(8)，并将路径保存到辅助内存（这里使用ArrayList）
        ArrayList pNode1_path = new ArrayList();
        ArrayList pNode2_path = new ArrayList();
        getPath(root, (Integer) pNode1.value,pNode1_path);
        found = false;
        getPath(root, (Integer) pNode2.value,pNode2_path);

//        pNode1_path.forEach(System.out::println);
//        pNode2_path.forEach(System.out::println);
        return getLastCommonNode(pNode1_path,pNode2_path);
    }



    private static boolean found = false;
    @SuppressWarnings("unchecked")
    /**
     * 保存根节点到指定节点的路径（中序遍历）
     * @param root 根节点
     * @param target 目标值
     * @param result 路径
     * @return 路径
     */
    private static ArrayList getPath(TreeNode root, int target, ArrayList result) {

        if (root.value.equals(target)) {
            found = true;
            return result;
        }

        if (!found) {
            result.add(root.value);
            if (!found && root.left != null) {
                result = getPath(root.left, target, result);
            }
            if (!found && root.right != null) {
                result = getPath(root.right, target, result);
            }
            //删除不在路径中的节点
            if (!found){
            result.remove(root.value);
            }
        }

        return result;
    }

    /**
     * 获取两个ArrayList的最后一个公共节点
     * @param arrayList1
     * @param arrayList2
     * @return
     */
    private static int getLastCommonNode(ArrayList arrayList1, ArrayList arrayList2) {
        int size = arrayList1.size() >= arrayList2.size() ? arrayList2.size() : arrayList1.size();
        int result = -1;
        for (int i = 0 ; i < size; i++){
            if (arrayList1.get(i) == arrayList2.get(i)){
                result = (int) arrayList1.get(i);
            }
        }
        return result;
    }
}
