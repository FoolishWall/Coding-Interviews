package offer11;

/**
 * @author wall
 * @date 2018/10/18  14:47
 * @description 经典排序算法
 * 思路：实现的思路是选择一个元素，将比他小的放在他的左边，比他大的放右边，递归完所有未完成排序的数组即可完成最后的目标。
 */
public class Sort_Core {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{6,1,2,7,9,3,4,5,10,8,5,6,7,8,9};
        quickSort_core(0,data.length-1,data);
        for (int aData:data){
            System.out.println(aData);
        }
    }

    /**
     * 思路：以数组的第一个元素为基准数，接着分别从数组的左右两侧开始“探测”，将比基准数小的元素放左边，
     * 比基准数大的元素放右边
     * @param head 指向数组的最左侧
     * @param tail 指向数组的最右侧
     * @param data 数组
     */
    private static void quickSort_core(int head,int tail,int [] data){
        int start = head;
        int end = tail;
        //基准数
        int standard = data[head];
        //当head与tail相遇的时候，将基准数放到相遇的位置上

        while(start<end){
            //当右边的值大于基准数，继续右移
            while (start<end&&data[end]>=standard){
                end--;
            }
            while (start<end&&data[start]<=standard){
                start++;
            }
            swap(data,start,end);
        }

        swap(data,head,start);
        //第一次排序结束之后，递归排序左右两侧的数组
        if (start>head)quickSort_core(head,start-1,data);
        if (end<tail)quickSort_core(end+1,tail,data);

    }

    /**
     * 交换数据
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int []data,int i,int j){
        int temp ;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
