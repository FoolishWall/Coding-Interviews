package offer12;




import java.util.ArrayList;

/**
 * @author wall
 * @date 2018/10/10  21:48
 * @description 全组合(利用二进制的特性)
 * 思路：当n大于2时，n个数的全组合一共有(2^n)-1种。当对n个元素进行全组合的时候，可以用一个n位的二进制数表示取法。
 * 1 表示在该位取，0 表示不取。例如，对ABC三个元素进行全组合，用二进制表示如下  
 * 000,001,010,011,100,101,110,111。
 * 对应输出组合结果为：
 * 空,a, b ,ab,c,ac,bc,abc.
 */
public class Combination {
    public static void main(String[] args) {
        String str = "ABC";
        char[] strArr = str.toCharArray();
        System.out.println(combination_solution(strArr));

    }
    private static ArrayList<StringBuffer> combination_solution(char [] strArr){
        ArrayList<StringBuffer> result = new ArrayList<>();
        //利用左移运算符计算全组合的总数(包括空集)
        int nBit = 1<<strArr.length;
        //外层循环从1开始，去除空集的情况
        for (int i = 1;i<nBit;++i){
            //为每一种组合定义一个StringBuffer，然后添加到ArrayList中
            StringBuffer tempStr = new StringBuffer();
            for (int j = 0;j<strArr.length;++j){
                int temp =1<<j;
                //核心代码(可以依此输出二进制位上为1的位置，然后输出数组中在这个位置上的元素，例如101和001,010,100的与运算，
                // 可以输出数组中第一，三个位置上的元素)
                if ((temp&i)!=0){
                    tempStr.append(strArr[j]);
                }
            }
            result.add(tempStr);
        }

        return result;
    }
}
