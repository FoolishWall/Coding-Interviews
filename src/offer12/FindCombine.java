package offer12;

import java.util.ArrayList;

/**
 * @author wall
 * @date 2018/10/10  19:29
 * @description 题目：两个整数 n和k，从1-n中选择k个数字的组合。比如n=4，那么从1,2,3,4中选取两个数字的组合。(回溯法)
 */
public class FindCombine {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        findCombine_solution(1, 4, 3,list);
        System.out.println(list);
    }
    private static ArrayList<Integer> temp = new ArrayList<>();
    private static void findCombine_solution(int index, int n, int k, ArrayList<ArrayList<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n; ++i) {
            temp.add(i);
            findCombine_solution(i + 1, n, k, result);
            //使用ArrayList实现栈的弹出功能
            temp.remove(temp.get(temp.size()-1));
        }
    }
}
