package offer30;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author wall
 * @date 2019/1/3  9:21
 * @description 包含min函数的栈
 * min函数能够得到栈的最小元素
 */
@SuppressWarnings("unchecked")
class StackWithMin_solution{
    private Integer[] data;
    private int maxSize = 2;
    private int top = -1;
    //问题：如果当前最小的元素被弹出栈，那么无法得到下一个最小的元素。（解决思路:定义一个辅助栈,
    // 辅助栈与数据栈同进同出，辅助栈遇到比栈顶元素大的元素，则在栈顶再添加辅助栈的栈顶元素；否则直接添加到栈顶）
    //private int minValue = Integer.MAX_VALUE;

    //辅助栈
    //注意：类在加载的过程中的顺序为：

    /**
     * 1. 父类静态变量初始化
     * 2. 父类静态语句块
     * 3. 子类静态变量初始化
     * 4. 子类静态语句块
     * 5. 父类变量初始化
     * 6. 父类语句块
     * 7. 父类构造函数
     * 8. 子类变量初始化
     * 9. 子类语句块
     * 10. 子类构造函数
     */

    private Stack stack = new Stack();

    StackWithMin_solution(){
        this.data = new Integer[maxSize];
    }
    //判空
    boolean isEmpty(){
        return top == -1;
    }
    //入栈
    boolean push(int t){
        /**
         * 排序辅助栈，将最小元素置于栈顶
         */
        if (stack.isEmpty()){
            stack.push(t);
        }else if ((int)stack.peek() >= t){
            stack.push(t);
        }else {
            stack.push(stack.peek());
        }

        if (this.top < maxSize-1){
            data[++top] = t;
            return true;
        }else {
            /**
             * 扩容
             */
            this.maxSize = this.maxSize*2;
            this.data = Arrays.copyOf(this.data,this.maxSize);
            data[++top] = t;
            return true;
        }

    }
    //出栈
    int  pop(){
        if (!isEmpty()){
            int t = data[top];
            data[top--] = null;/* to let gc do its work */
            stack.pop();
            return t;
        }
        throw new RuntimeException("栈为空");
    }
    int peek(){
        if (!isEmpty()){
            return data[top];
        }
        throw new RuntimeException("栈为空");
    }
    //min函数
    int min(){
        return (int)stack.peek();
    }
}
public class StackWithMin {
    //测试
    public static void main(String[] args) {
        StackWithMin_solution stackWithMin_solution = new StackWithMin_solution();
        stackWithMin_solution.push(5);
        stackWithMin_solution.push(2);
        stackWithMin_solution.push(3);
        stackWithMin_solution.push(1);
        stackWithMin_solution.push(6);
        stackWithMin_solution.push(3);
        stackWithMin_solution.push(1);
        stackWithMin_solution.push(6);
        System.out.println(stackWithMin_solution.min());
        stackWithMin_solution.pop();
        stackWithMin_solution.pop();
        stackWithMin_solution.pop();
        stackWithMin_solution.pop();
        stackWithMin_solution.pop();
        System.out.println(stackWithMin_solution.min());
    }
}
