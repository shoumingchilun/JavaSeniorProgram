package ThreadCommunication;

/**
 * @auther 齿轮
 * @create 2022-03-04-21:59
 *
 *
 * wait()           使调用wait()方法的线程进入阻塞状态,并释放当前锁
 * notify()         唤醒被wait的一个线程(优先唤醒优先级高的
 *notifyAll()      唤醒被wait的所有线程
 *
 * 线程通信：
 * 1、以上三种方法必须于同步代码块或同步方法中
 * 2、以上三种方法的调用者必须是同步代码块或同步方法中的同步监视器否则抛出IllegalMonitorStateException异常
 * 3、以上三种方法定义在Object中
 *
 *wait()与sleep()的区别：
 * 1、sleep()于Thread中声明，wait()于Object中声明
 * 2、sleep()可于任意场景调用，wait()于同步代码块或同步方法中调用
 * 3、sleep()不会释放监视器，wait()会释放
 *
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }

}
class Number implements  Runnable{
    private int number = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                if(number<=100){
                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
