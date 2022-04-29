package GenericTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2022-03-16-15:20
 * <p>
 * 1、泛型在继承方面的体现
 * <p>
 * <p>
 * 2、通配符的使用
 */
public class GenericTest2 {
    /*
     * 1、泛型在继承方面的体现
     * A为B的父类，但G<A>和G<B>不具备父子类关系
     * A为B的父类，A<G>和B<G>具备父子类关系
     *
     * 2、通配符使用
     * 通配符：？
     * */
    @Test
    public void test1() {
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
        List<Object> list1 = null;
        List<String> list2 = null;
        //list1与list2不具备子父类关系
        //编译不通过
//        list1 = list2;
        List<String> list3 = null;
        ArrayList<String> list4 = null;
        list3 = list4;
    }
    /*
    * 通配符的使用
    * 通配符：？
    *
    * 类A是类B的父类，G<A>和G<B>没有关系，G<?>是G<A>和G<B>的父类
    *
    * */
    @Test
    public void test2(){
        List<Object> list = null;
        List<String> list1 = null;

        List<?> list2 = null;
        list2 = list;
        list2 = list1;

        print(list);
        print(list1);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list2 = list3;
        //添加(写入)：对于List<?>就不能向其内部添加数据。
        //除了添加null之外。
//        list2.add("DD");
//        list2.add('?');
        list2.add(null);
        //读取：
        Object o = list2.get(0);
        System.out.println(o);
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
    /*
    * 有限制条件的通配符
    *       ? extends A:
    *           G<? extends A>可以作为G<A>和G<B>的父类，其中B是A的子类
    *       ? super A:
    *           G<? super A>可以作为G<A>和G<B>的父类，其中B是A的父类
    * */
    @Test
    public void test3(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;
        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<>();
        list1 = list3;
        list1 = list4;
//        list1 = list5;
//        list2 = list3;
        list2 = list4;
        list2 = list5;

        list1 = list3;
        //读取：
        Person p = list1.get(0);//p必须为父类，因为p需>[-无穷，Person]
//        Student student = list1.get(0);
//        Student s = list2.get(0);//
        Object o = list2.get(0);//o必须为父类，因为o需>[Person，+无穷]

    }

}
