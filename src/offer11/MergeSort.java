package offer11;

/**
 * @author wall
 * @date 2018/10/24  11:03
 * @description 归并算法
 * 思路：将两个的有序数列合并成一个有序数列，我们称之为"归并"。
 * 归并排序(Merge Sort)就是利用归并思想对数列进行排序。根据具体的实现，归并排序包括"从上往下"和"从下往上"2种方式。
 */
public class MergeSort {
    //测试
    public static void main(String[] args) {
        int [] arr = new int[]{8,4,5,7,1,3,6,2,9,2,1,3,4};
        mergesort_solution(arr,0,arr.length-1);
        for (int aArr:arr) {
            System.out.println(aArr);
        }
    }

    /**
     * 从上往下的方式,将区间一分为二
     * @param arr
     * @param start
     * @param end
     */
    private static void mergesort_solution(int [] arr,int start,int end){
        //递归出口,子区间的长度为1
        if (arr==null||start==end){
            return;
        }
        int mid = (start+end)/2;
        mergesort_solution(arr,start,mid);
        mergesort_solution(arr,mid+1,end);
        //System.out.println("开始:"+start+"结束:"+end);
        merge(arr,start,end);
    }

    /**
     * 将两个区间归并为一个有序的区间
     * @param arr
     * @param start
     * @param end
     */
    private static void merge(int [] arr,int start,int end){
        //定义临时数组，存放归并后的有序区间
        int [] tempArr = new int[end-start+1];
        //第一个有序区的索引
        int one_index = start;

        //有序区间的中间位置
        int mid = (start+end)/2;

        //第二个有序区的索引
        int two_index = mid+1;

        //临时数组的下标
        int k = 0;

        //比较两个区间的数值,将较小的数值存入临时数组中。
        while(one_index<=mid&&two_index<=end){
            if (arr[one_index]<arr[two_index]){
                tempArr[k++]=arr[one_index++];
            }
            else {
                tempArr[k++]=arr[two_index++];
            }
        }

        //如果前半段数组都存入了临时数组中，则把后半段剩下的数组元素全部存放到临时数组中
        while (two_index<=end){
            tempArr[k++]=arr[two_index++];
        }
        //否则将前半段剩下的数组元素存放到临时数组中
        while(one_index<=mid){
            tempArr[k++]=arr[one_index++];
        }

        //最后将临时数组中的有序数值覆盖原数组中的相应元素
        for (int i=0;i<k;i++){
            arr[start+i]=tempArr[i];
        }

    }
}
