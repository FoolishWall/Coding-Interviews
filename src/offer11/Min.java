package offer11;

/**
 * @author wall
 * @date 2018/10/23  10:06
 * @description 旋转数组的最小数字 例如：{3,4,5,1,2} 最小值为1
 * 思路:二分查找法
 * 边界值测试:
 * 1.把0个元素搬到数组的最后面
 * 2.例如：{1,1,1,0,1}与{1,0,1,1,1}
 */
public class Min {
    //测试
    public static void main(String[] args) {
        int [] rotateArr = new int[]{3,4,5,1,2,3};
        //System.out.println(min_solution(rotateArr,0,rotateArr.length-1));
        System.out.println(min_solution1(rotateArr));
    }
    //递归实现的二分查找
    private static int min_solution(int [] rotateArr,int start,int end){
        //递归出口
        if (start==end-1){
            return rotateArr[end];
        }
        //如果中间元素大于等于第一个元素，那么最小元素在后半段数组中。
        if (rotateArr[start]<=rotateArr[(start+end)/2]){
            return min_solution(rotateArr,(start+end)/2,end);
        }
        //如果中间元素小于等于第一个元素，那么最小元素在前半段数组中。
        if (rotateArr[start]>=rotateArr[(start+end)/2]){
            return min_solution(rotateArr,start,(start+end)/2);
        }
        return 0;
    }

    //循环实现的二分查找
    private static int min_solution1(int [] rotateArr){
        //考虑边界条件
        if (rotateArr==null){
            return -1;
        }
        int start = 0;
        int end = rotateArr.length-1;
        //考虑特例（数组本身）
        if (rotateArr[start]<rotateArr[end]){
            return rotateArr[start];
        }
        //特例{1,1,1,0,1}与{1,0,1,1,1},无法判断最小值是在前半段数组还是在后半段数组，因此需要顺序查找
        if (rotateArr[start]==rotateArr[end]&&rotateArr[start]==rotateArr[(start+end)/2]){
            int index =0;
            while (index<rotateArr.length-2){
                if (rotateArr[index]>rotateArr[index+1]){
                    return rotateArr[index+1];
                }
                index++;
            }
            //如果是只包含一个数字的数组，顺序查找完时输出最后一个元素
            return rotateArr[index];
        }

        //基本功能实现（二分查找的循环实现）
        while (end>start){
            //循环出口
            if (end-start==1){
                break;
            }
            int mid = (start+end)/2;
            if (rotateArr[start]<=rotateArr[mid]){
                start=mid;
            }
            else if (rotateArr[start]>=rotateArr[mid]){
                end=mid;
            }
        }
        return rotateArr[end];
    }
}
