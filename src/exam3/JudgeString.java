package exam3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/4/4  9:47
 * @description 华为笔试第二题：判断合法非法字符串。合法字符串需要去重，排序，循环左移10次
 */
public class JudgeString {

    //测试
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<String> list = new ArrayList<>();
//        String line;
//        while (!"".equals(line =scanner.nextLine())){
//            list.add(line);}
//        checkString(list);

//        List<String> list = new ArrayList<>();
//        list.add("abcddddd");
//        list.add("123asdfg");
//        list.add("we@");
//        list.add("!23");
//        checkString(list);
    }

    /**
     * 输出结果
     * @param str
     */
    private static void checkString(List<String> str){
        //判断合法和非合法
        String regex = "\\w*";
        //合法结果
        List<String> legal = new ArrayList<>();
        //不合法结果
        List<String> illegal = new ArrayList<>();
        //去重后的合法结果
        List<String> resultLegal = new ArrayList<>();

        //去重后，循环左移的合法结果
        List<String> resultLegalMove = new ArrayList<>();
        for (String temp:str) {
            //合法
            if (temp.matches(regex)){
                legal.add(temp);
            }else {
                illegal.add(temp);
            }
        }

        //将合法的字符串去重
        for (String dRep:legal) {
            resultLegal.add(deleteRep(dRep));
        }


        //循环左移十次
        for (String move:resultLegal) {
            resultLegalMove.add(leftMove(move));
        }

        //对合法结果进行排序
        resultLegalMove.sort(String::compareTo);

        //输出合法结果
//        System.out.println(resultLegalMove);

        resultLegalMove.forEach((s) -> {
            System.out.print(s+" ");
        });
        //输出非法结果
//        System.out.println(illegal);
        System.out.println();
        illegal.forEach((s)->{
            System.out.print(s+" ");
        });
    }

    /**
     * 去重
     * @param str
     * @return
     */
    private static String deleteRep(String str){
        String[] strChar = str.split("");
        List<String> list = new ArrayList<>();
        for(String c:strChar){
            if(!list.contains(c))
                list.add(c);
        }
        return String.join("",list);

    }

    /**
     * 循环左移10次
     * @param str
     * @return
     */
    private static String leftMove(String str){
        //左移一次
        char [] strChar = str.toCharArray();
        //需要循环的次数(去重)
        int count = 10*(strChar.length-1)%(strChar.length);
        int j = 0 ;
        while (j < count) {
            char temp;
            temp = strChar[strChar.length - 1];
            System.arraycopy(strChar, 0, strChar, 1, strChar.length - 1);
            strChar[0] = temp;
            j++;
        }
        return String.valueOf(strChar);
    }
}
