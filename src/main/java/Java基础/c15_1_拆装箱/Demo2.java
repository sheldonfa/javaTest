package Java基础.c15_1_拆装箱;

/**
 * Integer什么时候用缓存
 */
public class Demo2 {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        Integer e = 150;
        Integer f = 150;
        System.out.println(a==b);
        System.out.println(c==d);
        System.out.println(e==f);

        String aa = "aa";
        switch (aa){
            case "bb":
                break;
        }
    }
}
