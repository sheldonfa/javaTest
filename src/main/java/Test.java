import org.apache.commons.logging.impl.WeakHashtable;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author fangxin
 * @date 2017/4/11.
 */
public class Test extends Date{

    public static void main(String[] args) {
        new Test().test();
    }

    public void test(){
        System.out.println(super.getClass().getName());
    }
}

