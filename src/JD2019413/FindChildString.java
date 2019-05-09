package JD2019413;

import java.util.Scanner;

/**
 * @author wall
 * @date 2019/5/9  9:55
 * @description 寻找子串
 * 思路：充分利用Java类库
 * 示例：
 * 输入
 * 3
 * aa
 * b
 * ac
 * bbaac
 *
 * 输出
 * 3
 */
public class FindChildString {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //子串的个数
//        int n = scanner.nextInt();
//        String [] cs = new String[n];
//        for (int i = 0 ; i < n ; i++ ){
//            cs[i] = scanner.nextLine();
//        }
//
//        String t = scanner.nextLine();
//        StringBuilder stringBuilder = new StringBuilder(t);
        String [] cs = new String[]{"aa","b","ac"};
        StringBuilder stringBuilder = new StringBuilder("bbaac");
        System.out.println(recursionDel(cs,stringBuilder));

    }

    private static int recursionDel(String [] cs,StringBuilder t){
        int i = 0 ;
        for (String c : cs) {
            while (t.indexOf(c) != -1) {
                t.delete(t.indexOf(c), t.indexOf(c) + c.length());
                i++;
            }
        }
        return i;
    }
}
