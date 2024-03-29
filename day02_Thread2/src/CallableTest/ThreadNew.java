package CallableTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @auther 齿轮
 * @create 2022-03-04-23:08
 *
 * 创建线程的方法三：
 * 1、创建一个实现Callable的实现类
 * 2、实现call()方法，将此线程需要执行的操作声明在call()中
 * 3、创建Callable接口实现类的对象
 * 4、将Callable接口类的对象传递到FutureTask构造器中，创建FutureTask对象
 * 5、将FutureTask对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
 *  (6、获取Callable中call()方法的返回值：FutureTask.get())
 *
 * Callable接口实现优点：
 * 1、call()可以有返回值
 * 2、call()可以抛出异常
 * 3、Callable支持泛型
 *
 */
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();

        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}