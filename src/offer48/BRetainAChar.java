package offer48;


import java.util.ArrayList;
import java.util.List;

/**
 * @author wall
 * @date 2018/12/4  11:21
 * @description A,B两个字符串,去除B中不存在于A中的字符
 */
public class BRetainAChar {
    //测试
    public static void main(String[] args) {
        String A = "ABC";
        String B = "ABCCDEFGA";
        System.out.println(bRetainAChar_solution(A,B));
    }

    private static String bRetainAChar_solution(String A,String B){
        StringBuilder stringBuilder = new StringBuilder();
        char [] aArr = A.toCharArray();
        char [] bArr = B.toCharArray();
        ArrayList<Character> aList = new ArrayList<>();
        List<Character> bList = new ArrayList<>();
        for (char a:aArr) {
            aList.add(a);
        }
        for (char b: bArr) {
            bList.add(b);
        }
        bList.iterator();
        //lambda表达式
        bList.removeIf(x -> !aList.contains(x));

        for (char b:bList) {
            stringBuilder.append(b);
        }
        return stringBuilder.toString();
    }
}
