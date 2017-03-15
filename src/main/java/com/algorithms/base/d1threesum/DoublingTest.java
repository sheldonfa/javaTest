package com.algorithms.base.d1threesum;

import com.algorithms.model.StdOut;
import com.algorithms.model.StdRandom;
import com.algorithms.model.StopWatch;

/**
 * 是stopWatch的一个更复杂的用例，能够为ThreeSum产生实验数据
 * @author fangxin
 * @description ${END}
 * @date 2017/3/15 0015.
 */
public class DoublingTest {

    public static double timeTrial(int N){
        int MAX = 1000000;
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = StdRandom.uniform(-MAX,MAX);
        }
        StopWatch timmer = new StopWatch();
        int cnt = ThreeSum.count(a);
        return timmer.elapsedTime();
    }

    public static void main(String[] args) {
        for(int N = 250;true;N+=N){
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
        }
    }

}
