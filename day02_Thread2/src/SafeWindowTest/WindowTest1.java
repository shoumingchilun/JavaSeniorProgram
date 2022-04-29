package SafeWindowTest;

/**
 * @auther 齿轮
 * @create 2022-03-04-10:28
 * 3个窗口共同售卖100张票
 *
 * 存在线程安全问题
 * 解决方法：当一个线程在操作(即使sleep)的时候，其他线程不能参与，直到操作完，其他线程才能开始操作
 * 同步机制：
 * 1、同步代码块
 * synchronized(同步监视器){
 *     需要被同步的代码：操作共享数据的代码
 * }
 * 同步监视器：锁，可以由任意对象充当，多个线程必须用同一把锁
 * 接口实现多线程时，可用this充当锁
 * 在继承Thread类创建多线程时，慎用this当锁,可以用当前类当同步监视器
 *
 * 2、同步方法
 * 当操作共享数据的代码完整声明在同一个方法中，则可以将方法声明为同步的
 * 同步方法加上前缀synchronized
 * 非静态同步方法监视器：this
 * 静态同步方法监视器：class
 *
 *
 *
 * 同步优点：解决了线程安全的好处
 * 同步缺点：近似于单线程，效率低
 *
 */

public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window1 implements Runnable {
    private int ticket = 100;
//    Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (this){
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket--);
                } else {
                    break;
                }
            }
            //Thread.currentThread().yield();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}