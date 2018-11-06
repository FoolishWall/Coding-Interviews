package offer62;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wall
 * @date 2018/11/6  9:43
 * @description 圆圈中最后剩下的数字(约瑟夫环问题)
 * 思路：核心公式：
 * int index = 0;
 * index = (index+m)%list.size()-1;
 */
public class LastRemaining {
    //测试
    public static void main(String[] args) {
        int n =4000;
        int m =997;
        System.out.println(lastRemaining_mysolution(n,m));
        System.out.println(lastRemaining_mysolution1(n,m));
    }

    /**
     * 利用list数组模拟圆圈
     * @param n n个数字排成一个圆圈
     * @param m 每次从这个圆圈里删除第m个数字
     * @return 圆圈里剩下的最后一个数字
     */
    private static int lastRemaining_mysolution(int n,int m){
        //边界条件
        if (n<=0||m<=0){
            return -1;
        }
        List<Integer> list = new ArrayList<>();
        //将圆圈存储在list集合中
        for (int i=0;i<n;i++){
            list.add(i);
        }
        int index = 0;
        while (list.size()!=1){
            index = (index+m)%list.size()-1;
            if (index==-1){
                index=list.size()-1;
            }
            list.remove(index);

        }

        return list.get(0);
    }

    //思路：要得到n个数字的序列中最后剩下的数字，只需要得到n-1个数字的序列中最后剩下的数字
    //n=1时，f(n,m)=0;
    //n>1时,f(n,m)=[f(n-1,m)+m]%n。
    private static int lastRemaining_mysolution1(int n,int m){
        //特殊测试
        if (n<1||m<1){return -1;}
        int last = 0;
        for (int i=2;i<=n;i++){
            last=(last+m)%i;
        }
        return last;
    }
}
