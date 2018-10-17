package offer15;

import java.util.Stack;

/**
 * @author wall
 * @date 2018/10/17  10:20
 * @description 位运算(二进制中1的个数)Integer.toBinaryString为将int整数转换为二进制字符串
 */
public class CountNumberOf1 {
    //测试
    public static void main(String[] args) {
        String str1 = Integer.toBinaryString(-10);
        String str2 = Integer.toBinaryString(10);
        String string1 = Integer.toBinaryString(-2147483648);
        //System.out.println(str1);
        //System.out.println(str2);
        //System.out.println(string1);

        int n =-10;
        System.out.println(numberOf1_solution3(n));

    }
    //常规解法
    //思路：将十进制转换为二进制入栈，接着遍历栈中1的个数
    private static int numberOf1_solution(int n){
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        while (n!=0){
            stack.push(n%2);
            n=n/2;
        }

        //遍历栈
        while (!stack.empty()){
            if (stack.pop()==1)
                ++count;
        }
        return count;
    }

    //利用位运算的解法
    //思路：先判断最右边一位是不是1，然后右移，直到整数位0。
    //判断一个整数的最右边是不是1：把整数和1做位于运算，1除最右边的一位之外所有位都是0。
    //如果一个整数与1做与运算的结果是1，则表示该整数最右边一位是1，否则是0。


    //如果输入的整数为负数，可能引起死循环
    private static int numberOf1_solution1(int n){
        int count = 0;
        while (n!=0){
            if ((n&1)!=0){
                ++count;
            }
            n = n>>1;
        }
        return count;
    }

    //常规解法
    //首先把n和1做与运算，判断n的最低位是不是为1，接着把1左移一位，继续与n做与运算
    //循环的次数等于整数二进制的位数，int为32位

    private static int numberOf1_solution2(int n){
        int count = 0;
        int flag = 1;
        while (flag!=0){
            if ((n&flag)!=0){
                ++count;
            }
            flag=flag<<1;
        }
        return count;
    }


    //终极解法
    //思路：二进制数减一，（最右边的1位置之后的所有位取反）例如1100，减一之后为1011
    //再与原整数做与运算，会把该整数最右边的1变为0，二进制有多少个1就可以进行多少次这样的操作。
    private static int numberOf1_solution3(int n){
        int count = 0;
        while (n!=0){
            n=(n-1)&n;
            count++;
        }
        return count;
    }

}
