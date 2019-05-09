package offer12;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author wall
 * @date 2019/5/9  14:15
 * @description 利用DFS解决将n分为k份
 * 示例：
 * 将3个礼物分给3个小朋友，例如 *||** 代表第一个小朋友分到一个礼物，
 * 第二个小朋友没有分到礼物，第三个小朋友分到两个礼物。
 * 3 3
 * 10
 * *||**
 * *|**|
 * ||***
 * |*|**
 * |***|
 * ***||
 * **|*|
 * |**|*
 * *|*|*
 * **||*
 */
public class NKDFS {
    //使用HashSet去重
    private static HashSet<String> hashSet = new HashSet<>();
    private static StringBuilder result = new StringBuilder();
    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        //初始化礼物
        for (int i = 0 ; i < n ; i ++){
            result.append('*');
        }
        DFS(n,0,k);

        System.out.println(hashSet.size());
        hashSet.forEach(System.out::println);
    }

    private static void DFS(int n,int step,int k) {

        if (step == k-1){
            hashSet.add(new String(result));
            return;
        }
        //n+1个位置可以插入
        for (int i = 0; i < n+1; i++) {
            result.insert(i,'|');
            DFS(n,step + 1,k);
            result.deleteCharAt(i);
        }
    }
}
