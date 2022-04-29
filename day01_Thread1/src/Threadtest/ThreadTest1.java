package Threadtest;

/**
 * @auther 齿轮
 * @create 2022-03-04-10:13
 * <p>
 * 创建多线程的方式二：实现Runnable接口
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类实现Runnable中的抽象方法：run()
 * 3.创建此类对象(可共用
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.新创建的对象调用start()
 * <p>
 * start():(1)启动当前线程(2)调用当前线程的run()
 *
 * 两种多线程创建方式区别：
 * 接口实现更合适(java为单继承
 * 接口实现更容易实现共享数据
 *
 *开发中更宜选择接口实现的方式
 *
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);
        t1.start();
        t2.start();
    }
}

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "\t:" + i);
            }
        }
    }
}
