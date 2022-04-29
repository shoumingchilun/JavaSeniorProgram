package Collection2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @auther 齿轮
 * @create 2022-03-10-15:46
 *
 * 集合元素遍历使用迭代器Iterator接口
 * (迭代器：设计模式的一种)
 * 迭代器的方法：
 * hasNext()
 * next()
 *remove()
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));

        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
//Iterator中的remove()
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("QIQI", 29));

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("Tom"))iterator.remove();
        }
        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
