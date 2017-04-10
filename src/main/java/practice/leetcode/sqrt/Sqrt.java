package practice.leetcode.sqrt;


import java.math.BigDecimal;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/10 0010.
 */
public class Sqrt {


    public static void main(String[] args) {
        Sqrt sqrt1 = new Sqrt();
        int sqrt = sqrt1.mySqrt(9);
        System.out.println(sqrt);
    }

    // 整数的
    public int mySqrt(int square){
        int n = square / 2 + 1;
        int value = -1;
        for(int i=0;i<=n;i++){
            if(i*i==square){
                value = i;
                break;
            }else if(i*i>square){
                value = i-1;
                break;
            }
        }
        return value;
    }

    // double的
    public static double mySqrt(double square) {
        int n = (int) (Math.floor(square / 2) + 1);
        int value = -1;
        boolean isFind = false;
        for(int i=0;i<=n;i++){
            if(i*i==square){
                value = i;
                isFind = true;
                break;
            }else if(i*i>square){
                value = i-1;
                isFind = false;
                break;
            }
        }
        if(isFind){
            return value;
        }else{
            return recSqrt(value,square,1);
        }
    }

    public static double recSqrt(double value,double square,int dotLen){
        double rank = 1;
        for(int i=0;i<dotLen;i++){
            rank = rank *10;
        }
        boolean isFind = false;
        double  tempValue = value;
        for(int i=1;i<10;i++){
            double sn = i/rank;
            // 逐级增大小数部分
            tempValue = add(value,sn);
            if(tempValue*tempValue==square){
                isFind = true;
                value = tempValue;
                break;
            }else if(tempValue*tempValue>square){
                isFind = false;
                value = add(value,(i-1)/rank);
                break;
            }
        }
        if(isFind){
            return value;
        }else{
            if(dotLen>=6){
                return value;
            }else{

                return recSqrt(value,square,dotLen+1);
            }
        }
    }

    public static double add(double a,double b){
        BigDecimal newa = new BigDecimal(Double.toString(a));
        BigDecimal newb = new BigDecimal(Double.toString(b));
        BigDecimal value = newa.add(newb);
        return value.doubleValue();
    }
}
