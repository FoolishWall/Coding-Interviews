package offer50;


import java.util.*;

/**git
 * @author wall
 * @date 2019/1/7  16:48
 * @description 第一个只出现一次的字符
 * 例如：输入"abaccdeff",输出b
 */
public class FirstNotRepeating {
    //测试
    public static void main(String[] args) {
        String string = "abaccdeff";
        System.out.println(firstNotRepeating_mysolution(string));
    }

    /**
     * 统计字符串中字符的个数（利用map）
     * @param string
     * @return
     */
    private static char firstNotRepeating_mysolution(String string){
        char [] strArr = string.toCharArray();
        //Map序列有序
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (char tempChar:strArr) {
            map.put(tempChar,map.getOrDefault(tempChar,0)+1);
        }
        //利用Lambda表达式遍历map
        //遍历时无序
        map.forEach((key,value)-> {
            System.out.println(key+":"+value);
        });

        System.out.println("===");
        //遍历map
        for (Map.Entry<Character,Integer> tempMap:map.entrySet()) {
            System.out.println(tempMap.getKey()+":"+tempMap.getValue());
//            if (tempMap.getValue()== 1){
//                return tempMap.getKey();
//            }
        }

        return '\0';
    }
}
