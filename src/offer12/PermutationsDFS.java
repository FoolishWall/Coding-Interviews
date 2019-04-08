package offer12;


/**
 * @author wall
 * @date 2019/4/8  9:11
 * @description 利用DFS算法实现全排列
 *
 * DFS算法的基本模板
 *
 * void DFS(){
 *      判断边界(例如数组遍历完){
 *          相应操作
 *      }
 *
 *     尝试每一种可能(利用for循环){
 *          满足check条件（利用if条件，例如字符是否被访问过（利用布尔数组））{
 *                记录结果
 *                标记
 *                继续下一步（DFS（step+1））
 *                恢复初始状态（回溯的时候要用到）
 *          }
 *     }
 * }
 */
public class PermutationsDFS {
    //测试
    public static void main(String[] args) {
        String str = "123A";
        char[] strChar = str.toCharArray();
        char[] result = new char[strChar.length];
        //定义一个布尔数组，记录字符串是否被访问过。
        boolean[] bool = new boolean[strChar.length];
        DFS(strChar,0,result,bool);
    }

    private static void DFS(char[] strChar,int step,char [] result,boolean [] bool) {

        if (step == strChar.length){
            System.out.println(new String(result));
        }

        for (int i = 0; i < strChar.length; i++) {
            if (!bool[i]) {
                result[step] = strChar[i];
                //标记访问过的字符
                bool[i] = true;
                DFS(strChar,step+1,result,bool);
                bool[i] = false;
            }
        }
    }
}
