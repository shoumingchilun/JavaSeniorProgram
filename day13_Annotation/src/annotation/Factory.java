package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther 齿轮
 * @create 2023-03-11-16:31
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Factory {
    Class type();//用于标记是哪个工厂
    String id();//指明要生成的类
}
