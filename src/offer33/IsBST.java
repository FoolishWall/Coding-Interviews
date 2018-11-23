package offer33;

/**
 * @author wall
 * @date 2018/11/22  21:06
 * @description 判断一数组是不是某二叉搜索树的后序遍历结果。7,4,6,5
 * 思路:后序遍历结果的最后一个数为根节点，比根节点小的为左子树，比根节点大的为右子树，
 * 左右子树又为二叉搜索树，递归判断所有的数。
 */
public class IsBST {
    //测试
    public static void main(String[] args) {
        int [] arr = new int[]{};
        int end = arr.length;
        //System.out.println(isBST_solution(arr,0,end));
        System.out.println(VerifySquenceOfBST(arr));
    }

    private static boolean isBST_solution(int [] arr,int start,int end){
        if (arr==null||end<start||start<0||end>arr.length){
            return false;
        }
        int root = arr[end-1];
        int i = start;
        for(;i<end-1;i++){
            if (arr[i]>root)break;
        }
        int j = i;
        for (;j<end-1;j++){
            if (arr[j]<root)return false;
        }
        //判断左子树
        boolean left = true;
        if (i>start){
        left = isBST_solution(arr,start,i);}
        //判断右子树
        boolean right = true;
        if (i<end-1){
        right = isBST_solution(arr,i,end-1);}

        return (left&&right);
    }


    private static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence==null||sequence.length==0)return false;
        return isBST_solution(sequence,0,sequence.length);
    }
}
