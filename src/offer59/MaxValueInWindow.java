package offer59;

import java.util.*;


/**
 * @author wall
 * @date 2018/11/17  16:02
 * @description 队列的最大值
 */
public class MaxValueInWindow {
    public static void main(String[] args) {
        int [] data = new int[]{16,22,12,24,8,15,4};
        int windowSize = 0;
//        System.out.println(maxValueInWindow_solution(data,windowSize));
        maxValueInWindow_priorityQueue(data,3).forEach(System.out::println);
    }

    /**
     * 我的解法(没有通过测试用例)如:(16,14,12,10,8,6,4)5
     * @param num 原数组
     * @param size 窗口大小
     * @return 每个窗口的最大值
     */
    private static List<Integer> maxValueInWindow_mysolution(int [] num,int size){
        if (num==null||size>num.length||size<1){return null;}
        List<Integer> resultList = new ArrayList<>();
        int left = 0 ;
        int right = 0;
        int maxValue = Integer.MIN_VALUE;
        int secValue = Integer.MIN_VALUE;
        for (int aData:num){
            if (aData>maxValue){
                maxValue = aData;
            }
            else if (aData>secValue){
                secValue=aData;
            }

            right++;
            if ((right-left)==size){
                resultList.add(maxValue);
                //如果窗口移动之后，上个窗口的最大值被移出窗口，
                // 则最大值为上一个窗口的第二大值
                if (num[left]==maxValue){
                    maxValue=secValue;
                }
                //否则最大值不变
                left++;
            }
        }
        return resultList;
    }

    /**
     * (16,14,12,10,8,6,4)5
     * (2,3,4,2,6,2,5,1)3
     */
    private static List<Integer> maxValueInWindow_solution(int[] num, int size) {
        //存储窗口最大值
        List<Integer> resultList = new ArrayList<>();
        if (num == null || size > num.length || size < 1) {
            return resultList;
        }

        LinkedList<Integer> temp = new LinkedList<>();
        //初始化队列
        for (int i = 0;i<size;i++){
            while (!temp.isEmpty()&&num[i]>num[temp.peekLast()]){
                temp.pollLast();
            }
            temp.add(i);
        }
        resultList.add(num[temp.peek()]);
        for (int i = size;i<num.length;i++){
            while (!temp.isEmpty()&&num[i]>num[temp.peekLast()]){
                temp.pollLast();
            }
            if (!temp.isEmpty()&&size<=(i-temp.peek())){
                temp.pop();
            }
            temp.add(i);
            resultList.add(num[temp.peek()]);
        }

        return resultList;
    }

    /**
     * 利用优先级队列实现窗口的最大值
     * @param num
     * @param size
     * @return
     */
    private static List<Integer> maxValueInWindow_priorityQueue(int[] num, int size){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        List<Integer> result = new ArrayList<>();
        int i;
        for (i = 0 ; i < num.length; i++){
            if (priorityQueue.size() == size){
                result.add(priorityQueue.peek());
                priorityQueue.remove(num[i-size]);
                priorityQueue.add(num[i]);
            }else {
                priorityQueue.offer(num[i]);
            }
        }
        result.add(priorityQueue.peek());
        return result;
    }

}
