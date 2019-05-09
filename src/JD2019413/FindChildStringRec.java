package JD2019413;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/5/9  10:44
 * @description 寻找子串的递归解法
 */
public class FindChildStringRec {
    public static void main(String[] args) {

//        ArrayList<String> list = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        for (int i = 0; i < n; i++) {
//            String str = scanner.next();
//            list.add(str);
//        }
//        String string = scanner.next();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("bbaac");
        list.add("aa");
        list.add("b");
        list.add("ac");
        System.out.println(process(list, stringBuilder));


    }

    private static int process(ArrayList<String> list, StringBuilder stringBuilder){
        for (int i = 0; i < list.size(); i++) {
            int index = stringBuilder.indexOf(list.get(i));
            if (index != -1){
                StringBuilder t = stringBuilder.delete(index, index + list.get(i).length());
                return 1 + process(list, t);
            }
        }
        return 0;
    }

}
