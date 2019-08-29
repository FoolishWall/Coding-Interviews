package 同程艺龙;

import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author wall
 * @date 2019/7/31  20:47
 * @description
 */
public class ThreadABC {
    //private static CyclicBarrier c = new CyclicBarrier(3);
    private static  StringBuilder strB;
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        strB = new StringBuilder(str);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Thread(new A()));
        executor.execute(new Thread(new B()));
        executor.execute(new Thread(new C()));
        /*Thread threadA = new Thread(new A());
        Thread threadB = new Thread(new B());
        Thread threadC = new Thread(new C());
        threadA.start();
        threadB.start();
        threadC.start();
        threadC.join();
        threadB.join();
        threadC.join();*/
        Thread.sleep(100);
        System.out.println(strB);
        executor.shutdown();
    }
   static class  A implements Runnable{
       @Override
       public void run() {
           /*try {
               c.await();
               Thread.sleep(100);
               System.out.println("线程A执行");
           } catch (InterruptedException | BrokenBarrierException e) {
               e.printStackTrace();
           }*/
            strB.append("_A");
       }
   }
    static class  B implements Runnable{
        @Override
        public void run() {
            /*try {
                c.await();
                Thread.sleep(300);
                System.out.println("线程B执行");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }*/
            strB.append("_B");
        }
    }
    static class  C implements Runnable{
        @Override
        public void run() {
            /*try {
                c.await();
                Thread.sleep(500);
                System.out.println("线程C执行");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }*/
            strB.append("_C");
        }
    }
}
