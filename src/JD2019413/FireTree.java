package JD2019413;


import java.util.*;

/**
 * @author wall
 * @date 2019/4/15  10:23
 * @description 紧急疏散
 * 我的思路是对根节点的子树遍历，求节点数最多的子树。就是逃生的最少时间。
 */

/**
 * 任意树数据结构
 */
class Node{
    int value;
    //保存子节点
    List<Integer> list;

    Node(int value){
        this.value = value;
        this.list = new ArrayList<>();
        this.list.add(value);
    }
    //用于测试
    @Override
    public String toString() {
        return "节点："+value+"具体子节点："+list;
    }

}

public class FireTree {
    //测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //利用TreeMap
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int k = 1;k < n;k++){
            map.put(scanner.nextInt(),scanner.nextInt());
        }
        //优化方法
        getLeastTime(map);
    }

    /**
     * 进一步优化，不遍历子树，在遍历map时，直接将与当前子树相关的节点添加到一起，最后统计list的大小
     * @param map
     */
    private static void getLeastTime(TreeMap<Integer,Integer> map){
        //利用list保存根节点的子节点
        List<Node> list = new ArrayList<>();
        map.forEach((key,value)->{
            if (value == 1){
                list.add(new Node(key));
            }else {
                //遍历list
                list.forEach((t)->{
                    if (t.list.contains(value)){
                        t.list.add(key);
                    }
                });
            }
        });
        int maxSize = Integer.MIN_VALUE;
        //再次遍历list
        for (Node aList : list) {
            if (aList.list.size() > maxSize) {
                maxSize = aList.list.size();
            }
        }
        System.out.println(maxSize);
    }
}
