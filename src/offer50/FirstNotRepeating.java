package offer50;


import java.util.*;

/**
 * @author wall
 * @date 2019/1/7  16:48
 * @description 第一个只出现一次的字符
 * 例如：输入"abaccdeff",输出b
 */
public class FirstNotRepeating {
    //测试
    public static void main(String[] args) {
        String string = "abcabc";
        String str1 = "We are students.";
        String str2 = "aeiou";
        System.out.println(delContainsInAnotherStr_mysolution(str1,str2));
    }

    /**
     * 统计字符串中字符的个数（利用map）
     * @param string
     * @return
     */
    private static char firstNotRepeating_mysolution(String string){
        if (string == null){
            return '\0';
        }

        char [] strArr = string.toCharArray();
        //Map序列有序
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (char tempChar:strArr) {
            map.put(tempChar,map.getOrDefault(tempChar,0)+1);
        }
        //利用Lambda表达式遍历map
        map.forEach((key,value)-> {
            System.out.println(key+":"+value);
        });

        System.out.println("===");
        //遍历map
        for (Map.Entry<Character,Integer> tempMap:map.entrySet()) {
            if (tempMap.getValue()== 1){
                return tempMap.getKey();
            }
        }
        return '\0';
    }

    /**
     * 相关题目：1.从第一个字符串中删除在第二个字符串中出现过的所有字符。
     * 例如：第一个字符串："We are students.",第二个字符串："aeiou"
     * 所得结果是"W r Stdnts."
     */
    private static String delContainsInAnotherStr_mysolution(String str1,String str2){
        if (str1 == null){
            return null;
        }
        if (str2 == null){
            return str1;
        }
        char [] str1Arr = str1.toCharArray();
        char [] str2Arr = str2.toCharArray();
        List<Character> list = new ArrayList<>();
        //利用list的contains方法
        for (char tempStr1:str1Arr) {
            list.add(tempStr1);
        }
        for (char tempStr2:str2Arr) {
            for (int i = 0; i < list.size(); i++) {
                if (list.contains(tempStr2)) {
                    list.remove(list.indexOf(tempStr2));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (char resultTemp:list){
            result.append(resultTemp);
        }

        return String.valueOf(result);
    }
}
