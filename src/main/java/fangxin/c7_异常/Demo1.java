package fangxin.c7_异常;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/19 0019.
 */


class Annoyance extends Exception {}
class Sneeze extends Annoyance {}

public class Demo1 {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}

