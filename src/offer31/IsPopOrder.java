package offer31;

import java.util.Stack;

/**
 * @author wall
 * @date 2019/1/7  14:55
 * @description 栈的压入，弹出序列
 * 题目描述:输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序。
 * 例如：压栈序列{1,2,3,4,5}，出栈序列{4,5,3,2,1} 匹配
 * 假设所有数字均不相等
 */
public class IsPopOrder {

    //测试
    public static void main(String[] args) {
        int [] pushArr = new int[]{1,2,3,4,5};
        int [] popArr = new int[]{5,4,3,2,1};
        System.out.println(isPopOrder_solution(pushArr,popArr));
    }

    private static boolean isPopOrder_solution(int [] pushArr,int [] popArr){
        if (pushArr==null || popArr==null || pushArr.length != popArr.length){
            return false;
        }
        //定义辅助栈
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0;i < popArr.length; i++){
            if (stack.isEmpty()&&j < pushArr.length){
                stack.push(pushArr[j]);
                j++;
            }
            while(stack.peek() != popArr[i] && j < pushArr.length){
                stack.push(pushArr[j]);
                j++;
            }
            if (stack.peek() == popArr[i]){
                stack.pop();
            }

        }
        return stack.empty();
    }
}
