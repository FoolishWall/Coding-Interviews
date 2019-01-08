package offer48;



import java.util.HashMap;
import java.util.Map;

/**
 * @author wall
 * @date 2018/10/30  19:41
 * @description 最小覆盖字符串所有字符的子串
 * 题目描述：给定一个字符串 S ，请在 S 中找出包含 S 所有字母的最小子串。
 * 示例：
 * 输入: S = "AAAAAAAAAABCBBBCBCBBA"
 * 输出: "ABC"
 *
 * 思路：维护一个Map集合
 */
public class MinCover {
    //测试
    public static void main(String[] args) {
        String S = "AAAAAAAAAABCBBBCBCBBA";
        System.out.println(minCover_solution(S));
    }


    private static String minCover_solution(String S){
        if (S==null|| S.equals("")){
            return null;
        }
        //记录字符串中包含的所有字符
        Map<Character,Integer> map = new HashMap<>();
        char [] sArr = S.toCharArray();
        for (char aSArr:sArr) {
            map.put(aSArr,1);
        }
        //记录窗口包含的字符个数
        int count =0;
        //记录窗口的位置
        int left =0;
        int right =0;
        //记录最小覆盖字符串的子串位置
        int minLeft =0;
        int minRight=0;
        //记录最小覆盖字符串的子串长度
        int minLength=Integer.MAX_VALUE;

        //循环遍历字符串S
        for (char strArr: sArr) {

            if (map.containsKey(strArr)){
                count = map.get(strArr)>0?count+1:count;
                map.put(strArr,map.get(strArr)-1);
            }

            while (count==map.size()){
                //当找到符合条件的子串时，更新minLength minLeft minRight
                if (right-left<minLength){
                    minLeft = left;
                    minRight = right;
                    minLength = right-left;
                }

                if (map.containsKey(sArr[left])){
                count = map.get(sArr[left])<0?count:count-1;
                map.put(sArr[left],map.get(sArr[left])+1);
                }
                left++;
            }
            right++;
        }
        return S.substring(minLeft,minRight+1);
    }
}
