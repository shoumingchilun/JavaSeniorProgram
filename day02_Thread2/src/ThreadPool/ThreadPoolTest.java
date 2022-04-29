package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther 齿轮
 * @create 2022-03-05-0:07
 *
 * 创建多线程的方法四：
 * 1、提供指定线程数量的线程池
 * 2、执行指定的线程的操作。需要提供实现Runnable或Callable接口实现类的对象
 * 3、关闭线程池
 *
 * 优点：
 * 1、提高响应速度(减少创建新线程的时间)
 * 2、降低资源消耗(不用频繁创建线程)
 * 3、便于线程管理(可以设置线程池属性)
 *
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new NumberThread());//Runnable
        service.execute(new NumberThread1());

//        service.submit();//Callable
        service.shutdown();
    }
}
class NumberThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":\t"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<=100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+":\t"+i);
            }
        }
    }
}