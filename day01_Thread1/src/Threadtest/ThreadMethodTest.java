package Threadtest;

/**
 * @auther 齿轮
 * @create 2022-03-03-23:28
 *
 * 1.start()
 * 2.run()
 * 3.currentThread()    返回当前代码执行线程:
 * 4.getName()            获取当前线程名称
 * 5.setName()             设置当前线程名称(也可以用构造器命名
 * 6.yield()                    释放当前线程的执行权(可以被再次抢到,笑死
 * 7.join()                      在线程1中调用线程2的join(),使线程1进入阻塞状态,直到线程2全部执行结束才恢复
 * 8.stop()                     强制结束当前线程(已过时
 * 9.sleep(long n)         让当前线程阻塞n毫秒
 * 10.isAlive()                判定当前线程是否存活
 *
 * 线程优先级：
 * 1、MAX_PRIORITY：10
 * 2、MIN_PRIORITY：1
 * 3、NORM_PRIORITY：5
 *
 *2、取得/设置当前线程优先级
 * getPriority()
 * setPriority()
 * 高优先级线程会抢占低优先级线程的执行权
 * 但是优先级高只是执行概率高,不是指定某个线程执行
 *
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        //主线程命名
        Thread.currentThread().setName("mainThread");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        ThreadMethodExample1 t1 = new ThreadMethodExample1();
        t1.setName("E1");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        for (int i = 1; i < 1000; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"\t:"+ Thread.currentThread().getPriority()+":"+i);
            }
            if(i%20==0) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
class ThreadMethodExample1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"\t:"+getPriority()+":"+i);
            }
        }
    }
}