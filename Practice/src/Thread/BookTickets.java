package Thread;

/**
 * @auther 齿轮
 * @create 2022-03-28-12:24
 */
public class BookTickets {
    public static void main(String[] args) {
        Window window = new Window();
        Thread[] windows = new Thread[3];
        windows[0] = new Thread(window);
        windows[1] = new Thread(window);
        windows[2] = new Thread(window);
        windows[0].start();
        windows[1].start();
        windows[2].start();
    }
}
class Window implements Runnable{
    int ticket_number = 100;
    @Override
    public void run() {
        for(;ticket_number>0;){
            book();
        }
        synchronized (this){
            notifyAll();
        }
    }
    public synchronized void book(){
        notifyAll();
        if (ticket_number>0) {
            System.out.println(Thread.currentThread().getName()+" book: the id"+ticket_number--+" ticket.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}