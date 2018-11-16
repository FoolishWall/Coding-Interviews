package offer58;

import java.util.Arrays;

/**
 * @author wall
 * @date 2018/11/16  11:04
 * @description 翻转字符串
 * 题目一：翻转单词顺序。
 * 例如输入字符串"I am a student."
 * 输出"student. a am I"
 *
 * 题目二：左旋转字符串
 * 例如输入字符串"abcdefg"和数字2
 * 输出"cdefgab"
 */
public class ReverseSentence {
    //测试
    public static void main(String[] args) {
        String s = "I am a student.";
        System.out.println(reverseSentence_mysolution(s));
        String t = "abcdefg";
        int number = 2;
        System.out.println(leftReverse_mysolution(t,2));
    }

    private static String reverseSentence_mysolution(String s){
        if (s==null|| "".equals(s)){
            return "";
        }

        String [] sArr = s.split(" ");
        StringBuilder tempStr = new StringBuilder();
        for (int i = sArr.length-1;i>=0;i--){
            tempStr.append(sArr[i]);
            tempStr.append(" ");
        }
        return tempStr.toString().trim();
    }

    private static String leftReverse_mysolution(String t,int number){
        if (t==null||"".equals(t)||number>t.length()||number<0){
            return "输入错误";
        }

        char [] tArr = t.toCharArray();
        StringBuilder resultStr = new StringBuilder();

        for (int i = number;i<tArr.length;i++){
            resultStr.append(tArr[i]);
        }

        for (int i = 0;i<number;i++){
            resultStr.append(tArr[i]);
        }

        return resultStr.toString();
    }

    //字符串旋转
    private static void reverseString(String t){
        //...
        char [] tArr = t.toCharArray();
        char temp;
        int left = 0;
        int right = tArr.length-1;
        while (left<right){
            temp = tArr[left];
            tArr[left] = tArr[right];
            tArr[right] = temp;
            left++;
            right--;
        }

    }
}
