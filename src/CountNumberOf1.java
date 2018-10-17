import java.util.Stack;

/**
 * @author wall
 * @date 2018/10/17  10:20
 * @description 位运算(二进制中1的个数)
 */
public class CountNumberOf1 {
    //测试
    public static void main(String[] args) {
        System.out.println(numberOf1_solution(10));
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
}
