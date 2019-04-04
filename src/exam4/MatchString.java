package exam4;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author wall
 * @date 2019/4/4  10:01
 * @description 百度笔试:字符串的匹配
 */
public class MatchString {
    //测试
    public static void main(String[] args) {
        List<String> dictWords = new ArrayList<>();
        dictWords.add("rocs");
        System.out.println(wordsByDeleting("rocksock",1,dictWords));
    }

    //匹配字典中的单词
    private static List<String> wordsByDeleting(String mWord,int numWord,List<String> dictWords){
        //TreeSet可以实现字符串的自动排序
        TreeSet<String> treeSet = new TreeSet<>();
        for (String temp : dictWords){
            if (match(mWord,temp)){
                treeSet.add(temp);
            }
        }

        return new ArrayList<>(treeSet);
    }

    /**
     * 匹配两个字符串
     * @param mWord
     * @param dictWord
     * @return
     */
    private static boolean match(String mWord,String dictWord){
        char [] mWordChar = mWord.toCharArray();
        char [] dictWordChar = dictWord.toCharArray();
        int mLen = 0;
        int dLen = 0;
        while (mLen < mWordChar.length && dLen < dictWordChar.length){
            if (mWordChar[mLen] == dictWordChar[dLen]) {
                mLen++;
                dLen++;
            }
            else{
                mLen++;
            }
        }

        return dLen == dictWordChar.length;
    }
}
