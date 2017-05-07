package Java基础.c10_容器.list.demo1_遍历List;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author fangxin
 * @date 2017/4/16.
 */
public class Demo {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("aa");
        arr.add("bb");

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
