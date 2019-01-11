package offer51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wall
 * @date 2019/1/10  11:38
 * @description 数组中的逆序对
 * 题目：例如数组{7,5,6,4}，一共存在5个逆序对，分别是(7,5)(7,6)(7,4)(5,4)(6,4)
 */
public class InverseParis {
    //测试
    public static void main(String[] args) {
        int [] data = new int[]{7,7,6,6};
        inverseParis_solution(data,0,data.length-1);
        System.out.println(count);
    }

    /**
     * 暴力方法
     * @param data
     * @return
     */
    private static List<List<Integer>> inverseParis_mysolution(int [] data){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < data.length;i++){
            for (int j = i+1;j<data.length;j++){
                if (data[i] > data[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(data[i]);
                    temp.add(data[j]);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    /**
     * 优化方法:归并思想
     * @param data
     * @return
     */
    private static void inverseParis_solution(int [] data,int start,int end){
        if (data == null || start == end ){
            return;
        }
        int mid = (start+end)/2;
        inverseParis_solution(data,start,mid);
        inverseParis_solution(data,mid+1,end);
        merge(data,start,end);
    }

    /**
     * 合并两个子数组
     * @param data
     * @param start
     * @param end
     */
    private static int count = 0;
    private static void merge(int [] data,int start,int end){
        //临时数组
        int [] temp = new int[end-start+1];
        int mid = (start+end)/2;
        //第一个子数组的尾部
        int p1 = (start+end)/2;
        //第二个子数组的尾部
        int p2 = end;
        //临时数组的索引
        int k = end-start;
        while(p1 >= start && p2 >=mid+1){
            if (data[p1] > data[p2]) {
                //记录逆序对的个数
                count += p2-mid;
                //排序
                temp[k--] = data[p1];
                //输出部分逆序对
                System.out.println("(" + data[p1] + "," + data[p2] + ")");
                p1--;
            }else {
                temp[k--] = data[p2--];
            }
        }

        //将剩下的数组存入临时数组
        while (p1 >= start){
            temp[k--] = data[p1--];
        }
        while (p2 >= mid+1){
            temp[k--] = data[p2--];
        }


        //排序原数组
        for (int i = 0;i < temp.length;i++){
            data[start+i] = temp[i];
        }
    }
}
