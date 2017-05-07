package Java基础.c10_容器.list.demo3_ArrayList和Vector的区别;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Administrator on 2017/5/6 0006.
 */
public class Demo {
    /**
     * 相同点
     * 1、有序
     * 2、底层都是数组
     */
    @Test
    public void test1(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("zhangsan");
        list1.add("lisi");
        list1.add("wangwu");

        for (String str : list1){
            System.out.println(str);
        }
    }
    @Test
    public void test2(){
        Vector<String> list2 = new Vector<>();
        list2.add("zhangsan");
        list2.add("lisi");
        list2.add("wangwu");
        for (String str : list2){
            System.out.println(str);
        }
    }

    /**
     * 不同点
     * 1、同步性
     * 2、数据增长
     */
}
