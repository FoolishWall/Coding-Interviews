package offer46;

import java.util.Stack;

/**
 * @author wall
 * @date 2018/11/1  10:50
 * @description 把数字翻译成字符串
 * 题目描述：规定：0翻译成"a",1翻译成"b",......,25翻译成"z",一个数字可能有多个翻译。
 * 示例：
 * 输入: 12258(5中不同的翻译"bccfi","bwfi","bczi","mcfi","mzi")
 * 输出: 5
 *
 * 思路：自下而上的思想
 * 记f(i)表示从第i位数字开始的不同翻译的数目，则f(i+1)分以下两种情况考虑
 * 1.若第i+1位与第i位的组合小于等于25时，则f(i+1)=f(i)+f(i-1)
 * 2.否则f(i+1)=f(i)
 */
public class GetTranslationCount {
    //测试
    public static void main(String[] args) {
        int number =12258;
        System.out.println(getTranslationCount_mysolution(number));
    }

    /**
     * @param number 需要翻译的数字
     * @return 总共可以翻译的类别数
     */
    private static int getTranslationCount_mysolution(int number){
        //考虑边界条件
        if (number<0){
            return 0;
        }
        //自下而上统计可以翻译的总数
        Stack<String> stack = new Stack<>();

        char [] numberArr =String.valueOf(number).toCharArray();
        //记录每一步的可以翻译的类别数
        int [] countArr = new int[numberArr.length];
        //只有一个数字时，count为1
        countArr[0]=1;
        //记录翻译数数组的下标
        int index=1;
        for (int i = numberArr.length-1; i >= 0; i--) {

            char aNumberArr = numberArr[i];
            if (!stack.empty()) {
                //组合出栈元素
                String newNumber = String.valueOf(aNumberArr) + stack.peek();
                int newIntNumber = Integer.valueOf(newNumber);
                if (newIntNumber <= 25) {
                    if (index==1){
                        countArr[index]=2;
                    }
                    else {
                    countArr[index]=countArr[index-1]+countArr[index-2];}
                }else {
                    countArr[index]=countArr[index-1];
                }
                index++;
            }
            //入栈
            stack.push(String.valueOf(aNumberArr));

        }

        return countArr[countArr.length-1];
    }
}
