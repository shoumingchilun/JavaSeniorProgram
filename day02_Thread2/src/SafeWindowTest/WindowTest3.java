package SafeWindowTest;

/**
 * @auther 齿轮
 * @create 2022-03-04-14:29
 * <p>
 * 使用同步方法解决接口实现多线程的线程安全问题
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
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

class Window3 implements Runnable {
    private int ticket = 100;
    private synchronized void show(){//同步监视器：this
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket--);
        }
    }

    @Override
    public void run() {

        while (ticket>0) {
            show();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
