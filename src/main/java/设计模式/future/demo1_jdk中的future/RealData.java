package 设计模式.future.demo1_jdk中的future;

import java.util.concurrent.Callable;

/**
 * @author fangxin
 * @date 2017/5/8.
 */
public class RealData implements Callable<String> {
    protected String data;

    public RealData(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        //利用sleep方法来表示真是业务是非常缓慢的
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}
