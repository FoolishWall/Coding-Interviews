package offer13;

import java.util.Stack;

/**
 * @author wall
 * @date 2018/10/16  9:31
 * @description 机器人的运动范围
 */
public class RobertMoveCount {
    //测试
    public static void main(String[] args) {
        int rows=3;
        int cols=3;
        int k=2;
        System.out.println(movingCount(rows,cols,k));
    }

    //定义一个全局count计数变量，防止count随递归变化。
    private static int count=0;

    /**
     *
     * @param rows 行
     * @param cols 列
     * @param k 行坐标和列坐标的位数之和不大于k
     * @return 返回机器人能够到达的格子数
     */
    private static int movingCount(int rows,int cols,int k){
        //考虑边界条件
        if (rows<=0||cols<=0||k<=0){
            return 0;
        }
        //定义一个布尔值数组，防止重复计数,布尔值数组在准备阶段的值为false。
        boolean [] visited = new boolean[rows*cols];
        //从坐标(0,0)开始移动
        return movingCountCore(0,0,rows,cols,k,visited);
    }

    /**
     *
     * @param row 当前行
     * @param col 当前列
     * @param rows 总行数
     * @param cols 总列数
     * @param k k值
     * @param visited 防止重复访问的布尔值数组
     * @return 返回机器人能够到达的格子数
     */
    private static int movingCountCore(int row,int col,int rows,int cols,int k,boolean[] visited){

        if (row>=0&&col>=0&&row<rows&&col<cols&&!visited[row*cols+col]&&getDigitNum(row,col)<=k){

            visited[row*cols+col]=true;
            ++count;

            //向左右上下移动一格
            movingCountCore(row,col-1,rows,cols,k,visited);
            movingCountCore(row,col+1,rows,cols,k,visited);
            movingCountCore(row+1,col,rows,cols,k,visited);
            movingCountCore(row-1,col,rows,cols,k,visited);

        }
        return count;
    }

    /**
     * 数位相加
     * @param row 行
     * @param col 列
     * @return 数位相加的和
     */
    private static int getDigitNum(int row,int col){
        //定义一个栈,存储一个数的数位
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        //分别对行列数进行数位入栈
        while (row!=0){
            stack.push(row%10);
            row=row/10;
        }
        while (col!=0){
            stack.push(col%10);
            col=col/10;
        }
        //数位相加
        while (!stack.empty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
