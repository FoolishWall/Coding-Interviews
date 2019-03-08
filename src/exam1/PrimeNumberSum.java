package exam1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/3/7  22:12
 * @description 题目描述
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000. 如，输入为10，程序应该输出结果为2。
 * （共有两对质数的和为10，分别为（5,5）,（3,7））
 */
public class PrimeNumberSum {
    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        ArrayList<Integer> temp = getPrimeNumbers(input);
        ArrayList<String> result = getSum(temp, input);
        result.forEach(System.out::println);
    }

    /**
     * 获取指定范围内的素数
     *
     * @param input
     * @return
     */
    private static ArrayList<Integer> getPrimeNumbers(int input) {
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        int i, j;
        for (i = 1; i <= input; i++) {
            if (isPrime(i)){
                primeNumbers.add(i);
            }
        }

        return primeNumbers;
    }

    /**
     * 判断一个数是否为素数
     *
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        }

        int sqrt = (int) Math.sqrt((int) n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    /**
     * 获取等于输入数字的素数对
     * 思路：采用二分计算
     *
     * @param temp
     * @return
     */
    private static ArrayList<String> getSum(ArrayList<Integer> temp, int input) {
        ArrayList<String> result = new ArrayList<>();

        //从有序排列的素数list数组的中间位置开始计算，若大于输入值，则pre向前移动一位，若小于输入值，则next向后移动一位。
        int pre = temp.size() >> 1;
        int next = temp.size() >> 1;

        if ((input % 2) == 0 && temp.contains((input >> 1))) {
            result.add("(" + (input >> 1) + "," + (input >> 1) + ")");
            if ((pre - 1) >= 0)
                pre--;
            if ((next + 1) < temp.size())
                next++;
        }


        while (pre >= 0 && next < temp.size()) {
            int sumValue = temp.get(pre) + temp.get(next);
            if (sumValue == input) {
                result.add("(" + temp.get(pre) + "," + temp.get(next) + ")");
                pre--;
            } else if (sumValue < input) {
                if ((next + 1) < temp.size())
                    next++;
                else
                    break;
            } else {
                if ((pre - 1) >= 0)
                    pre--;
                else
                    break;
            }
        }
        return result;
    }
}

