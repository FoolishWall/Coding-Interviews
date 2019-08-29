package Tencent_2;

/**
 * @author wall
 * @date 2019/4/8  20:02
 * @description 腾讯常规批 编程题第三道
 *
 *
 * 题目描述:3.穿越怪兽谷
 *
 * 在怪兽谷依次会遇到N只怪兽
 *
 * 会给出每只怪兽的武力值和贿赂这只怪兽的金币数。
 *
 * 贿赂了某只怪兽，该怪兽就会护送我们继续前进；
 *
 * 如果不贿赂某只怪兽，该怪兽武力值大于护送我们的怪兽武力值之和，那我们就会被怪兽打。
 *
 * 要想成功穿越怪兽谷还不被怪兽打，最少需要准备多少金币?
 *
 *
 *
 * 输入样例:
 * 第一行N，代表怪兽数。(N[1,50])
 * 第二行输入N个整数d1,d2,...,dn,代表武力值。
 * 第三行输入N个整数p1，p2,...pn,代表收买N只怪兽所需的金币。（p[1,2]）
 *
 *输出:
 * 输出一个整数，代表所需最小金币数
 *
 *
 *
 * 输入
 * 3
 * 8 5 10
 * 1 1 2
 *
 * 输出
 * 2
 *
 * 输入
 * 4
 * 1 2 4 8
 * 1 2 1 2
 *
 * 输出
 * 6
 *
 */
public class Monster {

    private static int minMoney = Integer.MAX_VALUE;
    //测试
    public static void main(String[] args) {
        int N = 4;
        int [] force = new int[]{8,5,10,12};
        int [] money = new int[]{1,1,2,2};
        boolean [] bool = new boolean[4];
        DFS(N,force,bool,0,money);
        System.out.println(minMoney);
    }

    private static void DFS(int N,int[] force,boolean [] bool,int step,int [] money){
        if (step == N){
            int sum = 0;
            for (int i = 0 ; i < N ;i++) {
               if (bool[i]){
                   sum += money[i];
               }
            }

            if (sum <= minMoney){
                minMoney = sum;
            }
            return;
        }


        //遍历所有可能
        if (!isOK(force, bool, step) && !bool[step]) {
            //标记已雇佣
            bool[step] = true;
            DFS(N, force, bool, step + 1, money);
            //回溯，找出所有可能
            bool[step] = false;
        }else {
            DFS(N, force, bool, step + 1, money);
        }
    }

    /**
     * 判断当前拥有的武力值是否可以击败当前的怪兽
     * @param force
     * @param bool
     * @param step
     * @return
     */
    private static boolean isOK(int [] force,boolean[] bool,int step){
        //当前拥有的武力值
        int cur = 0;
        for (int j = 0;j < step;j++){
            if (bool[j]){
                cur += force[j];
            }
        }

        return cur > force[step];
    }
}
