package offer40;

/**
 * @author wall
 * @date 2019/3/14  21:18
 * @description 基于堆的最小的k个数
 */
public class GetLeastNumbersByHeap {
    //测试
    public static void main(String[] args) {
        int[] data = new int[]{4, 5, 1, 6, 2, 7, 3, 8, 9, 10, 15, 12};
        int[] result = getLeastNumbersByHeap(data,1);

        for (int temp : result) {
            System.out.println(temp);
        }
    }

    /**
     * 获取最小的k个数
     *
     * @param data 数组
     * @param k
     * @return
     */
    private static int[] getLeastNumbersByHeap(int[] data, int k) {
        int[] result = new int[k];

        if (data == null|| k < 1 ||data.length < 1){
            return result;
        }

        //遍历一遍data数组，将最小的k个数写入result数组

        System.arraycopy(data, 0, result, 0, k);
        //将result数组调整为大顶堆，初始化
        for (int j = k / 2 - 1; j >= 0; j--) {
            adjustHeap(result, j);
        }
        for (int t = k; t < data.length; t++) {
            //如果存在比result数组中还小的数，写入result数组
            if (result[0] > data[t]) {
                result[0] = data[t];
                adjustHeap(result, 0);
            }
        }

        return result;
    }

    private static void adjustHeap(int[] result, int parent) {
        int child = 2 * parent + 1;

        while (child < result.length) {
            if (child + 1 < result.length && result[child + 1] > result[child]) {
                child++;
            }
            if (result[parent] > result[child]) {
                break;
            }

            //将比较大的子节点与父节点交换
            swap(result, child, parent);

            parent = child;

            child = 2 * child + 1;
        }
    }

    /**
     * 交换函数
     *
     * @param result
     * @param i
     * @param j
     */
    private static void swap(int[] result, int i, int j) {
        int temp = result[j];
        result[j] = result[i];
        result[i] = temp;
    }
}
