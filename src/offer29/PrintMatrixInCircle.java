package offer29;

/**
 * @author wall
 * @date 2018/11/30  11:12
 * @description 按顺时针打印矩阵
 * 体会：尽量将同一个数值，却有不同含义的变量分开命名，这样思路更清晰。
 */
public class PrintMatrixInCircle {
    //测试
    //1.多行多列2.一行3.一列4.一行一列
    public static void main(String[] args) {
        int [][] data = new int[][]{{1,2,3},{4,5,6},{7,8,9},{10,11,12},{13,14,15}};
        printMatrixInCricle_mysolution(data);
    }

    private static void printMatrixInCricle_mysolution(int [][] data){
        //边界条件
        if (data==null||data.length<1){
            return;
        }
        int startRow = 0;
        //矩阵的列数
        int rows = data[0].length;
        //矩阵的行数
        int columns = data.length;
        while (rows > startRow*2&&columns > startRow*2) {
            int endX = rows - startRow -1;
            int endY = columns - startRow - 1;
            //从左向右打印
            for (int i = startRow; i <= endX; i++) {
                System.out.print(data[startRow][i] + ",");
            }
            //最后一圈可能退化为一行，一列，甚至只有一个数字
            //从上向下打印
            if (startRow < endY) {
                for (int i = startRow + 1; i <= endY; i++) {
                    System.out.print(data[i][endX] + ",");
                }
            }
            //从右向左打印
            if (startRow < endY&&startRow < endX) {
                for (int i = endX - 1; i >= startRow; i--) {
                    System.out.print(data[endY][i] + ",");
                }
            }
            //从下向上打印
            if (startRow < endY-1&&startRow < endX) {
                for (int i = endY - 1; i >= startRow + 1; i--) {
                    System.out.print(data[i][startRow] + ",");
                }
            }
            startRow++;
        }
    }
}
