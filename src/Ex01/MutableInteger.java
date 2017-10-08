package Ex01;

/**
 * Created by Administrator on 2017/8/21.
 */
import edu.princeton.cs.algs4.StdOut;

import java.lang.reflect.Field;

public class MutableInteger {

    public static void main(String[] args) {
        //int x = 17;//原始数据类型不可变
        Integer x=17;//封装类型可变
        StdOut.println(x);
        mutate(x);
        StdOut.println(x);
    }

    // change the Integer to 9999999
    public static void mutate(Integer x) {
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(x, 999999999);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
