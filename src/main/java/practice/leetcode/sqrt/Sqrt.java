package practice.leetcode.sqrt;


import java.math.BigDecimal;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/10 0010.
 */
public class Sqrt {


    public static void main(String[] args) {
        Sqrt s = new Sqrt();
        int sqrt = s.sqrt2(234213412);
        System.out.println(sqrt);
    }


    // 代码简洁的
    public int sqrt1(int x){
        if(x==0){
            return 0;
        }
        int l = 1;
        int r = x;
        while(true){
            int mid = l+(r-l)/2;
            if(mid>x/mid){
                r = mid-1;
            }else{
                if(mid+1>x/(mid+1)){
                    return mid;
                }
                l = mid+1;
            }
        }
    }

    // 优化初始值x
    public int sqrt2(int x){
        if(x==0){
            return 0;
        }
        int l = 1;
        int r = x;
        r = youhuaR(x);
        while(true){
            int mid = l+(r-l)/2;
            if(mid>x/mid){
                r = mid-1;
            }else{
                if(mid+1>x/(mid+1)){
                    return mid;
                }
                l = mid+1;
            }
        }
    }

    private int youhuaR(int x){
        // 小于两位不考虑
        if(Integer.toString(x).length()<2){
            return x;
        }

        int wei = (Integer.toString(x).length()+1)/2;
        int n = 1;
        // 取值9999....，不如多一位取10000...，例如wei=3 要求三位，则取四位1000
        for(int i=0;i<wei;i++){
            n = n * 10;
        }
        return n;
    }



    // double的
    public static double sqrt3(double square) {
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
