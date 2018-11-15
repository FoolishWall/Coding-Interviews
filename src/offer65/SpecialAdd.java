package offer65;

/**
 * @author wall
 * @date 2018/11/15  10:06
 * @description 不用加减乘除做加法
 * 思路：位运算
 * 第一步不考虑进位对每一位相加(异或)
 * 第二步将两个数先做位与运算，然后再向左移动一位
 * 第三步相加的过程依然是重复前面两步，直到不产生进位为止
 */
public class SpecialAdd {
    //测试
    public static void main(String[] args) {
        int n = 30;
        int m = 20;
        System.out.println(specialAdd_solution(n,m));
    }

    private static int specialAdd_solution(int n,int m){
        int xorResult = 0;
        int andResult = 0;
        do {
            xorResult = n^m;
            andResult = (n&m)<<1;
            n = xorResult;
            m = andResult;
        }while (m!=0);
        return xorResult;
    }
}
