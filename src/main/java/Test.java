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

        Human human = new Human() {
            @Override
            public void cry() {
                System.out.println("哦哦哦哦");
            }
        };


        Human human1 = new Human();
        Human human2 = human1.new OOO();

    }

}

class  Human{

    class OOO extends Human {
        public void cry(){
            System.out.println("aasdfa");
        }
    }

    void cry() {

    }

}


