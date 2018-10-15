package offer12;

import java.util.Arrays;

/**
 * @author wall
 * @date 2018/10/11  11:21
 * @description 矩阵中的路径
 */
public class HasPath {
    public static void main(String[] args) {
        char [] str = new char[]{'a','c','j','d','f','b','c'};
        char [][] matrix = new char[][]{{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};
        System.out.println(hasPath_solution(str,matrix,0,0));
    }

    /**
     * 由于路径不能重复进入矩阵的格子，所以还需要定义和字符矩阵大小一样的布尔值矩阵，用来标识路径是否已经进入了每个格子。
     * @param str 路径
     * @param matrix 矩阵
     * @param row 矩阵的行
     * @param col 矩阵的列
     * @return
     */
    private static boolean hasPath_solution(char[] str,char [][] matrix,int row,int col){
        //考虑边界问题
        if (matrix==null||str==null){
            return false;
        }
        //定义布尔值矩阵
        boolean [] visited = new boolean[matrix.length*matrix[0].length];
        //初始化布尔值矩阵的值
        Arrays.fill(visited,false);
        int pathLength = 0;//路径上的第一个节点
        //遍历矩阵中的每个字符，选取路径的起点
        for (row = 0;row<matrix.length;++row){
            for (col =0;col<matrix[row].length;++col){
                //从起点出发，递归寻找路径
                if (hasPathCore(pathLength,str,matrix,row,col,visited)){
                    return true;
                }
            }
        }

        return false;
    }
    private static boolean hasPathCore(int pathLength,char[] str,char [][] matrix,int row,int col,boolean [] visited){
        boolean hasPath=false;
        //递归出口
        if (pathLength==str.length){
            return true;
        }

        /**
         * 1.路径中的值要与矩阵中的值相等
         * 2.没有被访问过
         * 3.不能超出矩阵边界
         */
        if (row>=0&&col>=0&&row<matrix.length&&col<matrix[0].length&&
                matrix[row][col]==str[pathLength]&&
                !visited[row * matrix.length + col]){
            ++pathLength;//寻找路径上的下一个字符
            visited[row * matrix.length + col]=true;

            //递归实现向左右上下移动一格
            hasPath =hasPathCore(pathLength,str,matrix,row,col-1,visited)||
                    hasPathCore(pathLength,str,matrix,row,col+1,visited)||
                    hasPathCore(pathLength,str,matrix,row+1,col,visited)||
                    hasPathCore(pathLength,str,matrix,row-1,col,visited);

            if (!hasPath){
                --pathLength;
                visited[row * matrix.length + col]=false;
            }
        }

        return hasPath;
    }
}
