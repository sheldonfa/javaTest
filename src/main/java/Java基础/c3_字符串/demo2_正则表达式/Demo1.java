package Java基础.c3_字符串.demo2_正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 如果要从字符串中截取第一个英文左括号之前的字符串，
 * 例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？
 * @author fangxin
 * @description ${END}
 * @date 2017/4/20 0020.
 */
public class Demo1 {

    public static String getValue(String str){
        Pattern pattern = Pattern.compile(".*?(?=\\()");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return matcher.group();
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        String value = getValue(str);
        System.out.println(value);
    }

}

/**
 *
 *  x(?=y)
        ▲表示：右边紧跟y的x，但只包含x，不包含y
    x(?=y|z)
        ▲表示：右边紧跟y或z的x，但只包含x，不包含y或z
    x(?!y)
        ▲表示：右边不跟y的x，只包含x
 */
