package offer48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wall
 * @date 2018/10/29  20:56
 * @description 最小覆盖子串
 * 题目描述：给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 * 解题思路：
 * 这道题的要求是要在O(n)的时间度里实现找到这个最小窗口字串，那么暴力搜索Brute Force肯定是不能用的，
 * 我们可以考虑哈希表，其中key是T中的字符，value是该字符出现的次数。
 *
 * - 我们最开始先扫描一遍T，把对应的字符及其出现的次数存到哈希表中。
 * left right记录当前子字符串的左右下标值，
 * min minleft minright 变量存储当前子字符串的最小长度以及左右下标。
 * count记录当前子字符串是否包含了T中的全部字符。
 * 第一：left = 0, right = 5时出现一个可以覆盖ABC的最小子串。
 * 第二：从left = 1开始，right需要退回吗？答案是不需要，
 * 因为left=0到right=5之间的情况已经判断过了，不需要再判断left=1到right=5之间的情况。
 * 不断更新minLength minleft minright
 *
 * 对于字符ch，map[ch]表示的是当前滑动窗缺少几个ch
 * 如果map[ch]大于0，说明缺少map[ch]个ch
 * 如果map[ch]小于0，说明滑动窗中富余|map[ch]|个ch(map[ch]的绝对值个)
 * 如果map[ch]等于0，说明滑动窗中不缺少字符ch，也不富余字符ch
 */
public class MinWindow {
    //测试
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(minWindow_solution(S,T));
    }

    private static String minWindow_solution(String S,String T){
        if (S==null){
            return null;
        }

        //其中key是T中的字符，value是该字符出现的次数。
        Map<Character,Integer> map = new HashMap<>();
        char [] tArr = T.toCharArray();
        //计算T中字符出现的次数。
        for (char aTArr : tArr) {
            map.put(aTArr, map.getOrDefault(aTArr, 0) + 1);
        }
        //记录当前子字符串的左右下标值
        int left =0;
        int right =0;
        //记录当前子字符串是否全部包含T中的字符
        int count=0;
        //min minleft minright 变量存储当前子字符串的最小长度以及左右下标。
        int minLength =Integer.MAX_VALUE;
        int minleft =0;
        int minright=0;
        //S字符串
        char [] sArr = S.toCharArray();
        for (char aSArr:sArr) {
            //如果当前字符在T中，map中的value减一
            // 例如aedbbac找abc时，b连续出现过两次，在count++的时候只在b出现的第一次++， 第二次不+，因为我们只需要一个b。
            // 如果map中的value>0,则count++，
            if (map.containsKey(aSArr)){
               count=map.get(aSArr)>0?count+1:count;
               map.put(aSArr,map.get(aSArr)-1);
            }
            //当前字符串包含T中的全部字符
            //ADOBEC
            while(count==tArr.length){
                //更新minLength minleft minright
                if (right-left<minLength){
                    minLength=right-left;
                    minleft=left;
                    minright=right;
                }
                //left收缩，map更新
                if (map.containsKey(sArr[left])){
                    count=map.get(sArr[left])<0?count:count-1;
                    map.put(sArr[left],map.get(sArr[left])+1);
                }
                left++;
            }
            right++;
        }

        return S.substring(minleft,minright+1);
    }
}
