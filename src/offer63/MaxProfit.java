package offer63;

/**
 * @author wall
 * @date 2018/11/7  13:00
 * @description 股票的最大利润
 * 例如：
 * 一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
 * 思路：滑动窗口
 */
public class MaxProfit {
    //测试
    public static void main(String[] args) {
        int [] stockPrice = new int[]{9,11,8,5,7,12,16,14};
        System.out.println(maxProfit_mysolution(stockPrice));
        System.out.println(maxProfit_solution(stockPrice));
    }
    //暴力方法
    private static int maxProfit_mysolution(int [] stockPrice){
        //边界条件
        if (stockPrice==null||stockPrice.length<2){
            return 0;
        }
        //正常功能
        //股票的最大利润
        int maxProfit = 0;
        //int maxProfit_start = 0;
        //int maxProfit_end = 0;
        for (int start=0;start<stockPrice.length;++start){
            int end = stockPrice.length-1;
            while (start<end){
               if (stockPrice[end]-stockPrice[start]>maxProfit){
                   maxProfit = stockPrice[end]-stockPrice[start];
                   //maxProfit_start = start;
                   //maxProfit_end = end;
               }
                end--;
            }
        }
        //System.out.println(stockPrice[maxProfit_start]);
        //System.out.println(stockPrice[maxProfit_end]);
        return maxProfit;
    }

    //优化思路
    //假设diff(i)为最大利润，当扫描到数组中的第i个位置时，
    //只需知道i之前的i-1个数字中最小的数字，即可求得diff(i)
    private static int maxProfit_solution(int [] stockPrice){
        if (stockPrice==null||stockPrice.length<2){
            return 0;
        }
        //记录i之前的最小数字
        //初始化
        int minBeforeI = stockPrice[0];
        int maxProfit = stockPrice[1]-stockPrice[0];

        for (int i=2;i<stockPrice.length;++i){
            if (stockPrice[i-1]<minBeforeI){
                minBeforeI=stockPrice[i-1];
            }
            if (stockPrice[i]-minBeforeI>maxProfit){
                maxProfit=stockPrice[i]-minBeforeI;
            }
        }

        return maxProfit;
    }
}
