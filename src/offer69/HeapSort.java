package offer69;

/**
 * @author wall
 * @date 2019/2/28  9:32
 * @description 堆排序（大根堆，小根堆） 时间复杂度都为O(nlog2n)
 * 堆是一棵顺序存储的完全二叉树。
 * 其中每个结点的关键字都不大于其孩子结点的关键字，这样的堆称为小根堆。
 * 其中每个结点的关键字都不小于其孩子结点的关键字，这样的堆称为大根堆。
 *
 * 完全二叉树与数组一一对应
 * 设当前元素在数组中以R[i]表示，那么，
 * (1) 它的左孩子结点是：R[2*i+1];
 * (2) 它的右孩子结点是：R[2*i+2];
 * (3) 它的父结点是：R[(i-1)/2];
 *
 *
 *最大堆进行升序排序的思想
 * 1.初始化堆，将数组a[0...n-1]构造成最大堆
 * 2.交换a[0]与a[n-1],这时a[n-1]为最大值，调整a[0...n-2]为最大堆，接着交换a[0]与a[n-2],再调整a[0...n-3],
 * 以此类推，直到a[0]与a[1]交换，
 * 这时数组是从小到大排序的有序数组。
 */
public class HeapSort {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{1, 3, 4, 5, 2, 6, 9, 7, 8, 0,15,24,23,18,0};
        heapSort_solution(data);
        for (int temp: data) {
            System.out.print(temp+" ");
        }
    }

    /**
     * 调整数组(从小到大的排序)
     * @param data 数组
     * @param parent 父节点需要与其左右孩子进行比较
     * @param length 数组长度
     */
    private static void heapAdjust_max(int [] data,int parent,int length){
        //获取左孩子数组下标
        int child = 2*parent+1;

        while (child<length){
            //如果右孩子比左孩子大，则将右孩子与父节点进行比较
            if ((child+1) < length&& data[child+1]>data[child]){
                child++;
            }
            //如果父节点比孩子节点都大，则结束循环
            if (data[parent] >= data[child]){
                break;
            }
            //将父节点的值与孩子节点的值互换
            swap(data,parent,child);

            //将左孩子节点作为父节点继续循环
            parent = child;

            child = 2*parent+1;
        }
    }

    /**
     * 调整数组(从大到小的排序)
     * @param data 数组
     * @param parent 父节点需要与其左右孩子进行比较
     * @param length 数组长度
     */
    private static void heapAdjust_min(int [] data,int parent,int length){
        //获取左孩子数组下标
        int child = 2*parent+1;

        while (child<length){
            //如果右孩子比左孩子大，则将右孩子与父节点进行比较
            if ((child+1) < length&& data[child+1]<data[child]){
                child++;
            }
            //如果父节点比孩子节点都大，则结束循环
            if (data[parent] <= data[child]){
                break;
            }
            //将父节点的值与孩子节点的值互换
            swap(data,parent,child);

            //将左孩子节点作为父节点继续循环
            parent = child;

            child = 2*parent+1;
        }
    }


    /**
     * @param data 待排序的数组
     */
    private static void heapSort_solution(int[] data){
        int length = data.length;
        //初始化最大堆
        for (int i = (length >> 1)-1;i >= 0;i--){
            //从第一个非叶子结点从下至上，从左至右调整结构
            heapAdjust_min(data,i,length);
        }

        for (int j = length-1;j>0;j--){
            swap(data,0,j);
            //从上至下调整结构
            heapAdjust_min(data,0,j);
        }

    }

    /**
     *  交换函数
     * @param data
     * @param i
     * @param j
     */
    private static void swap(int [] data ,int i,int j){
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
