package offer9;

/**
 * @author wall
 * @date 2018/12/3  10:12
 * @description 栈和队列(数组实现,基本操作包括清空,判空,求元素个数,获取栈顶,入栈和出栈)
 *用两个栈实现队列
 *实现appendTail和deleteHead
 */


import java.util.*;

/**
 * 栈的实现
 * @param <T>
 */
class MyStack<T>{
    private T[] data;
    private int maxSize = 10;//栈的容量
    private int top = -1;//栈顶指针

    //无参构造方法
    MyStack(){
        this.data = (T[]) new Object[maxSize];
    }
    //判空
    private boolean isEmpty(){
        return top == -1;
    }
    //入栈
    boolean push(T t){
        data[++top] = t;
        return true;
    }
    //出栈(获取栈顶数据,但不删除栈顶数据)
    T peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空!!!");
        }
        return data[top];
    }
    //出栈(获取栈顶数据,并且删除栈顶数据)
    // 删除的栈顶数据需要置null，这样可以让gc处理回收空间
    T pop(){
        T obj = peek();
        data[top--]=null; /* to let gc do its work */
        return obj;
    }

}

/**
 * 队列的实现
 * @param <T>
 */
class MyQueue<T>{
    private Object [] data = null;
    private int elementCount = 10;
    private int head = 0;//队首指针
    private int tail = 0;//队尾指针

    MyQueue(){
        this.data = new Object[elementCount];
    }
    //判空
    boolean isEmpty(){
        return head == tail;
    }
    //入队
    boolean push(T t){
        data[tail++] = t;
        return true;
    }
    //出队
    T peek(){
        if (isEmpty()){
            throw new RuntimeException("队列为空!!!");
        }
        return (T) data[head++];
    }
}
public class StackAndLinkedlist{
    //测试
    public static void main(String[] args) {
//        SQueue<Integer> sQueue = new SQueue<>();
//        sQueue.appendTail(1);
//        sQueue.appendTail(2);
//        sQueue.appendTail(3);
//        System.out.println(sQueue.deleteHead());
//        sQueue.appendTail(4);
//        sQueue.appendTail(5);
//        sQueue.appendTail(6);
//        System.out.println(sQueue.deleteHead());
//        System.out.println(sQueue.deleteHead());
//        System.out.println(sQueue.deleteHead());
//        sQueue.appendTail(7);
//        System.out.println(sQueue.deleteHead());
//        System.out.println(sQueue.deleteHead());
        QStack<Integer> qStack = new QStack<>();
        qStack.appendHead(1);
        qStack.appendHead(2);
        qStack.appendHead(3);
        System.out.println(qStack.deleteTail());
        qStack.appendHead(4);
        qStack.appendHead(5);
        qStack.appendHead(6);
        System.out.println(qStack.deleteTail());

    }
}

/**
 * 用两个栈实现一个队列的对象
 * @param <T>
 */
class SQueue<T>{
    //入队栈
    private  Stack<T> stackIn;
    //出队栈
    private  Stack<T> stackOut;
    //构造函数
    SQueue(){
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }
    boolean appendTail(T t){
        stackIn.push(t);
        return true;
    }
    //与pop的功能类似
    T deleteHead() {
        if (stackOut.empty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop());
            }
        }
        if (stackOut.empty()){
            throw new RuntimeException("队列为空！");
        }
        return stackOut.pop();
    }
}

/**
 * 用两个队列实现一个栈的对象
 * @param <T>
 */
class QStack<T>{
    //add()和remove()方法在失败的时候会抛出异常(不推荐)
    //Queue<String> queue = new LinkedList<String>();
    //添加元素queue.offer();
    //queue.poll()); //返回第一个元素，并在队列中删除
    //queue.peek()); //返回第一个元素
    private Queue<T> queue1;
    private Queue<T> queue2;
    QStack(){
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    //入栈
    boolean appendHead(T t){
        if (queue2.isEmpty()){
            queue1.offer(t);
        }else if (queue1.isEmpty()){
            queue2.offer(t);
        }
        return true;
    }
    //出栈
    T deleteTail(){
        if (queue2.isEmpty()){
            if (queue1.isEmpty()){
                throw new RuntimeException("栈为空！");
            }
            while (queue1.size()>1){
            queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }
        else if (queue1.isEmpty()){
            while (queue2.size()>1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return null;
    }

}