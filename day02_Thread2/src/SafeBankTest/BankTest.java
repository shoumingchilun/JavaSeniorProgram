package SafeBankTest;

/**
 * @auther 齿轮
 * @create 2022-03-04-14:52
 *
 *  使用同步机制将单例模式中的懒汉式改写为线程安全
 *
 */
public class BankTest {
    public static void main(String[] args) {

    }
}
class Bank{
    private Bank(){}

    private static Bank instance = null;

    public  static Bank getInstance(){
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
