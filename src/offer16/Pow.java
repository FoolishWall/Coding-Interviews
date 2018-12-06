package offer16;

/**
 * @author wall
 * @date 2018/12/6  17:01
 * @description 数值的整数次方
 */
public class Pow {
    //测试
    public static void main(String[] args) {
        double base = 3;
        int exponent = -4;
        //类库中的方法
        System.out.println(Math.pow(base,exponent));

        System.out.println(power_mysolution(base,exponent));
    }

    /**
     * 求base的exponent次方(最简单的解法)
     * 未考虑情况
     * ①指数为负数
     * ②底数为0
     * @param base
     * @param exponent
     * @return
     */
    private static double power_base(double base,int exponent){
        double product = 1.0;
        for (int i = 1;i <= exponent;i++){
            product *= base;
        }
        return product;
    }
    /**
     * 求base的exponent次方（考虑边界情况）
     * @param base
     * @param exponent
     * @return
     */
    private static double power_mysolution(double base,int exponent){
        double product = 1.0;
        if (exponent<0&&base!=0){
            product = 1/pow_solution(base,-exponent);
            return product;
        }else {
            for (int i = 1; i <= exponent; i++) {
                product *= base;
            }
        }
        return product;
    }


    /**
     * 判断奇数偶数的高效方法(number&1)==1
     * @param number
     */
    private static void isOddOrEven(int number){
        if ((number&1)==1){
            System.out.println("奇数");
        }else {
            System.out.println("偶数");
        }
    }

    /**
     * 高效算法：求32次方只需要做5次乘法
     * ：先求平方，在平方的基础上求4次方，在4次方的基础上求8次方。。。
     * @param base
     * @param exponent
     * @return
     */
    private static double pow_solution(double base,int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = pow_solution(base,exponent>>1);
        result *= result;
        if ((exponent&1)==1){
            result *= base;
        }
        return result;
    }
}
