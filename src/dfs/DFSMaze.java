package dfs;

/**
 * 走迷宫
 *
 * 给定一个M*N的矩阵（二维数组），分别用0和1表示通路和障碍物。即 0 表示 通路；1 表示 障碍物。
 * 从矩阵的左上角开始，每次只能向右，下，左，上移动位置，不能斜着走。请给出从入口到出口的路线。
 *
 * @author wall
 * @data 2019/9/2 9:16
 **/
public class DFSMaze {
    private static String shortPath = "";
    public static void main(String[] args) {
        //测试
        // 初始化一个迷宫地图
        // 0: 表示通路
        // 1:表示死路
        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        //不可使用StringBuilder记录路径，StringBuilder为引用传递，会记录值的修改记录。
        dfs(0,0,maze,"");
        System.out.println(shortPath);
    }
    //1.首先确定dfs函数的参数
    private static void dfs(int i,int j ,int [][] maze,String path){
        //2.接着确认递归的结束条件
        //行
        int m = maze.length;
        //列
        int n = maze[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 1){
            return;
        }
        //输出结果(到达终点)
        if (i == m -1&& j == n-1){
            //输出路径
            path = path + "(" + i + "," + j + ")";
            if (shortPath.length() == 0 || path.length() < shortPath.length()){
                shortPath = path;
            }
//            System.out.println(path);
            return;
        }
        //记录上一步的路径，方便回溯
        String temp = path;
        path = path + "(" + i + "," + j + ")" + "-"; // 记录路线
        maze[i][j] = 1;
        //3.向不同方向进行DFS,右下上左
        dfs(i+1,j,maze,path);
        dfs(i,j+1,maze,path);
        dfs(i-1,j,maze,path);
        dfs(i,j-1,maze,path);

        //回溯
        maze[i][j] = 0;
        path = temp;
    }
}

