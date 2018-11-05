package offer20;

/**
 * @author wall
 * @date 2018/11/5  15:53
 * @description 表示数值的字符串
 * 题目描述：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","123.45e+6","-.123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class RegexApply {
    //测试
    public static void main(String[] args) {
        String string = null;
        System.out.println(isNumber(string));
    }

    private static boolean isNumber(String string){
        //特殊输入测试☆☆☆☆☆
        if (string==null|| string.equals("")){
            return false;
        }
        //1.+-符号仅可以出现一次或0次 [+-]?
        //2.数字可以出现一次或是更多次
        //3.小数点可以出现一次或是0次  (\.\d)?
        //4.e可以为小写或是大写，e之后必有整数
        String regex = "[+-]?\\d*(\\.\\d+)?([eE]{1}[+-]?\\d+)?";
        return string.matches(regex);
    }
}
