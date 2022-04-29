package DAOTest;

import org.junit.Test;

import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-03-16-15:10
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);

    }
}
