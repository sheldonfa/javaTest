package Java基础.c3_字符串.demo3;

/**
 *
 * 如何把一段逗号分割的字符串转换成一个数组?
 * @author fangxin
 * @date 2017/5/9.
 */
public class MainTest {

    public static String[] sub(String str){
        String[] strArry = str.split(",");
        return strArry;
    }

    public static void main(String[] args) {
        String[] sub = sub("asd,fdas,bd,e,w,e,,,");
        for(String str: sub){
            System.out.println(str);
        }
    }
}
