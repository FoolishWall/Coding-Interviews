package offer44;

/**
 * @author wall
 * @date 2019/1/22  10:54
 * @description 数字序列中某一位的数字
 *
 * 思路：判断是几位数中的第几位
 * 例如index为1001时，为三位数中的370数字的第二位，即为7
 */
public class DigitAtIndex {
    //测试
    public static void main(String[] args) {
        String strNum = "0123456789101112131415161718";
        int index = 18;
        System.out.println(digitAtIndex_mysolution(strNum,index));
        System.out.println(digitAtIndex_solution(index));
        System.out.println(digitAtIndex_solution(1001));
    }

    private static int digitAtIndex_mysolution(String strNum,int index){
        if (strNum == null || strNum.length() < 1){
            return -1;
        }
        return Integer.valueOf(strNum.substring(index,index+1));
    }

    /**
     * 计算m位的数字总个数
     * @param m
     * @return
     */
    private static int countOfIntegers(int m){
        if (m < 1){
            return -1;
        }
        if (m == 1){
            return 10;
        }
        return (int) (9*Math.pow(10,m-1));
    }

    private static int digitAtIndex_solution(int index){
        if (index < 1){
            return -1;
        }
        //数字的位数
        int m = 1;
        int temp = countOfIntegers(m);
        while(index > temp){
            index -= temp*m;
            m++;
            temp = countOfIntegers(m);
        }
        //计算index在m位数字的第几个数字
        int i = index/m;
        int indexNumber = (int) Math.pow(10,m-1)+i;
        //找出那一位数后,从左至右第j位上的数字即为结果
        int j = index%m;

        String resultStr = String.valueOf(indexNumber);
        return Integer.parseInt(resultStr.substring(j,j+1));
    }

}
