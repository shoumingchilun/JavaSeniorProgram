package Threadtest;

/**
 * @auther 齿轮
 * @create 2022-03-03-22:38
 * 多线程创建
 * 1.子类继承Thread
 * 2.重写run()-->此线程将声明于run()
 * 3.创建该子类对象
 * 4.此对象调用start()
 *
 * 创建线程需要调用start，不能直接调run
 * 可用Thread.currentThread().getName()取得当前运行线程的名字
 * 不能重复调用同一个对象的start()来再启动一个线程(illegalThreadStateException)
 *
 *
 * 例子：遍历1000以内偶数
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        MyThread myThread2 = new MyThread();
        myThread2.start();
        for (int i = 0; i < 1000; i++) {
            if (i%2!=0){
                System.out.println(i);
            }
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}