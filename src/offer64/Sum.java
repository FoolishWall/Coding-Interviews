package offer64;

/**
 * @author wall
 * @date 2018/11/15  9:57
 * @description 求1+2+...+n
 */
public class Sum {
    public static void main(String[] args) {
        System.out.println(sum_solution(3));
    }

    private static int sum_solution(int n){
        int sum = n;
        boolean flag = (n>0)&&((sum+=sum_solution(n-1))>0);
        return sum;
    }
}
