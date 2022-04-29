package SafeWindowTest;

/**
 * @auther 齿轮
 * @create 2022-03-04-13:56
 *
 *  使用同步代码块解决Thread继承类的线程安全问题
 */

public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        t1.start();
        t2.start();
        t3.start();

    }
}

class Window2 extends Thread {
    private static int ticket = 100;
//    private static Object obj = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized (obj){
            synchronized (Window2.class){
                if (ticket > 0) {
                    System.out.println(getName() + ":卖票，票号为：" + ticket--);
                } else {
                    break;
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}