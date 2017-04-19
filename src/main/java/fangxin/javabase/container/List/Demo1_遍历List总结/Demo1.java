package fangxin.javabase.container.List.Demo1_遍历List总结;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author fangxin
 * @date 2017/4/16.
 */
public class Demo1 {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("aa");
        arr.add("bb");

        /**排序**/
        // 默认
        Collections.sort(arr);
        // 自定义排序规则
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        /**迭代**/
        // 通过增强foreach迭代
        for(String s: arr){
            System.out.println(s);
        }
        // iterator迭代器进行迭代
        for(Iterator<String> it = arr.iterator();it.hasNext();){
            String s = it.next();
            System.out.println(s);
        }
    }
}
