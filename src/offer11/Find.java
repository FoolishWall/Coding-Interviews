package offer11;

/**
 * @author wall
 * @date 2018/10/18  10:27
 * @description 查找算法
 */
public class Find {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{1,2,3,4};
    }

    /**
     * 二分查找
     * 要求：（1）必须采用顺序存储结构 （2）.必须按关键字大小有序排列
     * 思路：将数组分为三部分，依次是中值（所谓的中值就是数组中间位置的那个值）前，中值，中值后；
     * 将要查找的值和数组的中值进行比较，若小于中值则在中值前面找，
     * 若大于中值则在中值后面找，等于中值时直接返回。然后依次是一个递归过程，将前半部分或者后半部分继续分解为三部分。
     * @param data 需要查找的数组
     * @param head 数组的开始
     * @param tail 数组的结尾
     * @param result 需要查找的数据
     * @return 返回需要查找的数据
     */
    //递归实现
    private static int binarySearch(int head,int tail,int[] data,int result){
        //考虑边界条件
        if (result<data[head]||result>data[tail-1]){
            return -1;
        }
        //递归出口
        if (data[(head+tail)/2]==result){
            return data[(head+tail)/2];
        }
        //如果需要查找的数据大于中值，则在数组的右半部分查找。
        else if (result>data[(head+tail)/2]){
            return binarySearch((head+tail)/2,tail,data,result);
        }
        else{
            return binarySearch(head,(head+tail)/2,data,result);
        }
    }
    //循环实现
    private static int binarySearch_loop_solution(int [] data,int result){
        int left = 0;
        int right = data.length;

        if (result<data[0]||result>data[data.length-1]){
            return -1;
        }

        while (left<right){
            if (data[(left+right)/2]==result){
                return data[(left+right)/2];
            }
            else if (result>data[(left+right)/2]){
                left = (left+right)/2;
            }
            else {
                right=(left+right)/2;
            }
        }

        return 0;
    }

}
