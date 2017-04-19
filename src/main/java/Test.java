import org.apache.commons.logging.impl.WeakHashtable;

import java.util.*;

/**
 * @author fangxin
 * @date 2017/4/11.
 */

interface A{

}

interface B extends A{

}

public class Test extends Date{
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();

        Integer[] a = new Integer[]{3,5};
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }

}

