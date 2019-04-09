package Tencent_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/4/8  14:24
 * @description
 * 循环找到最大的小于等于sum的值为a[i]，则sum+a[i]之内的都可以组成；
 */
public class MinCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int sum = 1;
        int res = 0;
        if (a[0] != 1) {
            System.out.println(-1);
        } else {
            while (true) {
                if (sum >= m) {
                    System.out.println(res);
                    return;
                }
                for (int i = n - 1; i >= 0; i--) {
                    if (a[i] <= sum) {
                        sum += a[i];
                        res++;
                        break;
                    }
                }
            }
        }
    }
}
