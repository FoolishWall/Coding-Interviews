package offer21;

/**
 * @author wall
 * @date 2018/11/5  19:18
 * @description 调整数组顺序使奇数位于偶数前面
 */
public class ReorderOddEven {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{8,4,3,1,5,6,2,7,9};
        reorderOddEven_mysolution(data);

        for (int aData:data) {
            System.out.println(aData);
        }
    }
    //初级程序员

    //思路：参考快速排序
    //从数组的头部开始遍历数组，如果遇到偶数，则停在这个位置。
    //然后从数组的尾部开始向前遍历，如果遇到奇数，则停在这个位置。
    //接着交换这两个位置上的数字。
    //再从数组头部开始遍历，依此这样循环下去，直到头部的下标与尾部的下标相遇。
    private static void reorderOddEven_mysolution(int [] data){
        //考虑边界条件
        if (data==null||data.length==0){
            return;
        }
        int start = 0;
        int end = data.length-1;

        while (start<end){
            //如果不是偶数，继续向后遍历
            while (start<end&&!isEven(data[start])){
                start++;
            }
            while (start<end&&isEven(data[end])){
                end--;
            }
            swap(data,start,end);
        }

    }


    //交换函数
    private static void swap(int [] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //代码的可重用性
    private static boolean isEven(int n){
        return n%2==0;
    }


}
