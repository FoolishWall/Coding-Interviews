package 并查集;

import java.util.ArrayList;

/**
 * @author wall
 * @data 2019/8/29 13:22
 **/
public class FindGroup {
    private static int count;
    private static int index;
    public static void main(String[] args) {
        int [] data = new int[]{1,2,3,4,5,11};
        if (findGroup_solution(data) == 1){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
    private static int findGroup_solution(int [] data){
        int n = data.length;
        count = n;
        int [] id = new int[n];
        int [] sz = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i ++){
            list.add(data[i]);
            id[i] = i;
            sz[i] = 1;
        }
        //遍历data数组
        for (int i = 0 ; i < n; i ++){
            //判断是否连通
            if (connect(i,list,data)){
                union(i,index,id,sz);
            }else {
                return 0;
            }
        }

        return count;
    }
    private static int find(int i , int [] id){
        //返回父节点
        while (i!=id[i])
            i = id[i];
        return i;
    }
    private static void union(int i ,int j ,int [] id ,int [] sz){
        //i的根节点
        int iRoot = find(i,id);
        //j的根节点
        int jRoot = find(j,id);
        if (iRoot == jRoot)
            return;
        //根据群组中的个数决定将谁合并
        if (sz[iRoot] < sz[jRoot]) {
            id[iRoot] = jRoot;
            sz[jRoot] += sz[iRoot];
        } else {
            id[jRoot] = iRoot;
            sz[iRoot] += sz[jRoot];
        }
        count--;
    }
    //判断节点是否连通
    private static boolean connect(int i ,ArrayList<Integer> list,int [] data){
        //判断list中是否有i的相邻节点
        //左右上下
        int right = data[i] + 1;
        int left = data[i] -1;
        int up = data[i]- 10;
        int down = data[i] + 10;
        if (right>=1&&right<=45&&list.contains(right)){
            index = list.indexOf(right);
            return true;
        }
        if (left>=1&&left<=45&&list.contains(left)){
            index = list.indexOf(left);
            return true;
        }
        if (up>=1&&up<=45&&list.contains(up)){
            index = list.indexOf(up);
            return true;
        }
        if (down>=1&&down<=45&&list.contains(down)){
            index = list.indexOf(down);
            return true;
        }
        return false;
    }
}
