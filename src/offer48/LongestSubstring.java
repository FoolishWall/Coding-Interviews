package offer48;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wall
 * @date 2018/10/29  9:41
 * @description 最长不含重复字符的子字符串
 */
public class LongestSubstring {
    public static void main(String[] args) {
        String str = "araacfredtv";
        for (Map.Entry<Integer,StringBuffer> entry:longestSubstringWithoutDuplication(str).entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    private static Map<Integer,StringBuffer> longestSubstringWithoutDuplication(String str){
        Map<Integer,StringBuffer> resultMap = new HashMap<>();
        //保存最长子字符串
        StringBuffer stringBuffer = new StringBuffer();
        //记录最长子字符串的起始与结束位置
        int [] resultIndex = new int[2];

        List<Character> subString = new ArrayList<>();
        //记录子字符串的长度
        int index =0;
        int longestSubstring =0;

        int start = 0;
        int end = 0;

        char [] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            end=i;
            char aStrArr = strArr[i];
            if (subString.contains(aStrArr)) {
                //清空list集合
                subString.clear();
                start=end;
                subString.add(aStrArr);
                index = 1;
            } else {
                subString.add(aStrArr);
                index++;
                //判断最长字符串的长度
                if (index > longestSubstring) {
                    resultIndex[0]=start;
                    resultIndex[1]=end;
                    longestSubstring = index;
                }
            }
        }
        for (int i= resultIndex[0];i<=resultIndex[1];i++){
            stringBuffer.append(strArr[i]);
        }

        resultMap.put(longestSubstring,stringBuffer);

        return resultMap;
    }
}
