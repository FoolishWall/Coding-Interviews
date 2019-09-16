package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字分解
 *
 * 输入：4
 *
 * 输出：
 * 1+1+1+1
 * 1+1+2
 * 1+3
 * 2+2
 * 4
 */
public class DivNum {
    private static int  T;
    private static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        T = scanner.nextInt();
        T = 5;
        int [] data = new int[T-1];
        for (int i = 0;i <= T-2;i++){
            data[i] = i+1;
        }
        List<Integer> result = new ArrayList<>();
        DFS(data,0,result);
        System.out.println(T);
    }

    private static void DFS(int [] data, int step, List<Integer> result){
        if (T < 0){
            return;
        }
        if (T == 0){
            //去重操作
            List<Integer> tempList = new ArrayList<>(result);
            //对tempList排序
            tempList.sort(Integer::compareTo);
            StringBuilder sb = new StringBuilder();
            for (int temp : tempList){
                sb.append(temp);
            }
            if (!list.contains(sb.toString())){
                //将组合添加到list
                list.add(sb.toString());
                //输出组合
                for (int i = 0; i < result.size()-1;i++){
                    System.out.print(result.get(i)+"+");
                }
                System.out.print(result.get(result.size()-1));
                System.out.println();
            }
            return;
        }

        for (int i = 0 ; i < data.length ; i ++ ){
            //如果没被访问过
            result.add(step,data[i]);
            T -= data[i];
            DFS(data,step+1,result);
            result.remove(result.size()-1);
            T += data[i];
        }
    }
}
