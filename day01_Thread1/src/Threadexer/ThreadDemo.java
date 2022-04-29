package Threadexer;

/**
 * @auther 齿轮
 * @create 2022-03-03-23:07
 *
 * 创建两个线程，一个遍历1000以内偶数，一个遍历1000以内奇数
 */
public class ThreadDemo {
    public static void main(String[] args) {
/*        ThreadOddTraverse t1 = new ThreadOddTraverse();
        ThreadEvenTraverse t2 = new ThreadEvenTraverse();
        t1.start();
        t2.start();*/
        // new ThreadOddTraverse().start();
        //new ThreadEvenTraverse().start();
        new Thread(){
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+"\t:"+i);
                    }
                }
            }
        }.start();
        new Thread(){
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+"\t:"+i);
                    }
                }
            }
        }.start();

    }
}
/*class ThreadEvenTraverse extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+"\t:"+i);
            }
        }
    }
}
class ThreadOddTraverse extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+"\t:"+i);
            }
        }
    }
}*/

