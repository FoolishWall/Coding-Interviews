package offer53;

/**
 * @author wall
 * @date 2018/12/18  10:14
 * @description 在排序数组中查找数字
 * 题目1：
 * 例如，输入排序数组{1,2,3,3,3,3,4,5}和数字3
 * 由于3在这个数组中出现了4次，因此输出4
 * 思路：二分查找法，
 * 首先使用二分查找法找到k第一次出现的位置，
 * 接着使用二分查找法找到k最后一次出现的位置，
 * 则k出现的次数为以上两个值的差值。
 *
 * 题目2：
 * 0~n-1中缺失的数字
 * 在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 思路：找出第一个值和下标不相等的元素
 *
 * 题目3：
 * 数组中数值和下标相等的元素
 * 思路：数字的值大于它的下标，则它的右边数字可以忽略。
 *      数字的值小于它的下标，则它的左边数字可以忽略。
 */
public class FindNumInArr {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{-1,0,1,2,3,4,5,7};
        System.out.println(getNumSameAsIndex(data));
    }

    /**
     * 使用二分查找法找到k第一次出现的位置
     * @param data 数组
     * @param k 需要查找的数字
     * @return k第一次出现的位置
     */
    private static int getFirstK(int [] data,int k){
        //循环实现
        int left = 0;
        int right = data.length;

        while(left<right){
            if (k == data[(left+right)/2]){
                //考虑数组越界问题
                if ((left+right)/2 >0&&data[(left+right)/2-1] != k||(left+right)/2==0){
                    return (left+right)/2;
                }else {
                    right = (left+right)/2-1;
                }
            }else if (k > data[(left+right)/2]){
                left = (left+right)/2+1;
            }else {
                right = (left+right)/2-1;
            }
        }
        return -1;
    }

    /**
     * 使用二分查找法找到k最后一次出现的位置
     * @param data 数组
     * @param k 需要查找的数字
     * @return k最后一次出现的位置
     */
    private static int getLastK(int [] data,int k){
        int left = 0;
        int right = data.length;

        while(left<right){
            if (k == data[(left+right)/2]){
                //考虑数组越界问题
                if ((left+right)/2 < data.length-1 &&data[(left+right)/2+1] != k || (left+right)/2 == data.length-1){
                    return (left+right)/2;
                }else {
                    left = (left+right)/2+1;
                }
            }else if (k > data[(left+right)/2]){
                left = (left+right)/2+1;
            }else {
                right = (left+right)/2-1;
            }
        }
        return -1;
    }

    private static int getNumberK(int [] data,int k){
        if (data == null || data.length <1){
            return 0;
        }
        int first = getFirstK(data,k);
        int last = getLastK(data,k);
        if (first>-1&&last>-1){
            return last-first+1;
        }
        return 0;
    }

    /**
     * 0~n-1中缺失的数字
     * @param data 数组
     * @return
     */
    private static int getMissingNum(int [] data){
        if (data==null||data.length < 1){
            return -1;
        }
        //循环实现二分查找法
        int left = 0;
        int right = data.length;

        while (left<right){
            int middleIndex = (left+right)/2;
            if (data[middleIndex]!=middleIndex){
                if (middleIndex == 0 || data[middleIndex-1] == middleIndex-1){
                    return middleIndex;
                }else {
                    right = middleIndex-1;
                }
            }else {
                left = middleIndex + 1;
            }
        }
        return -1;
    }

    /**
     * 数组中数值和下标相等的元素
     * @param data
     * @return
     */
    private static int getNumSameAsIndex(int [] data){
        if (data == null || data.length < 1){
            return -1;
        }
        int left = 0;
        int right = data.length;
        int middleIndex;
        while (left<=right){
            middleIndex = (left+right)/2;
            if (data[middleIndex] == middleIndex){
                return middleIndex;
            }else if (data[middleIndex] > middleIndex){
                right = middleIndex -1;
            }else {
                left = middleIndex + 1;
            }
        }
        return -1;
    }
}
