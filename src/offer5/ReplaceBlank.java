package offer5;

/**
 * @author wall
 * @date 2018/10/18  9:39
 * @description 替换空格(把字符串中的每个空格替换成"%20")
 */
public class ReplaceBlank {
    //测试
    public static void main(String[] args) {
        String string = "we are happy.";
        System.out.println(replaceBlank(string));
    }


    //粗暴解法
    //思路:找到空格，然后替换掉
    private static StringBuffer replaceBlank(String string){
        char [] strChars = string.toCharArray();
        StringBuffer resStr = new StringBuffer();
        for (char aStrChars:strChars) {
            if (aStrChars==' '){
                resStr.append("%20");
            }
            else {
            resStr.append(aStrChars);
            }
        }

        return resStr;
    }



}
