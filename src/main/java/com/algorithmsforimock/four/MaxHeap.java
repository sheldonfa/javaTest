package com.algorithmsforimock.four;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * 实现 最大堆 结构
 */
public class MaxHeap {

    private Integer[]   data;
    private int     count;
    private int     capacity;

    public MaxHeap(int capacity) {
        data = new Integer[capacity+1];
        count = 0;
        this.capacity = capacity;
    }

    int size(){
        return count;
    }

    boolean isEmpty(){
        return count == 0;
    }

    void insert(int item){
        assert(count+1<=capacity);
        data[count+1] = item;
        count++;
        shiftUp(data,count);
    }

    private void shiftUp(Integer[] data,int k) {
        while(k>1 && data[k/2] <data[k]){
            Tlt.exch(data,k/2,k);
            k/=2;
        }
    }

    public int extractMax(){
        assert (count>0);
        Integer ret = data[1];
        Tlt.exch(data,1,count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {
        while(2*k<=count){
            int j = 2*k;
            if(j+1 <= count && data[j+1]>data[j]){
                j +=1;
            }
            if(data[k]>=data[j]){
                break;
            }
            Tlt.exch(data,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);
        for(int i=0;i<15;i++){
            heap.insert(StdRandom.uniform(0,100));
        }
        while(!heap.isEmpty()){
            int max = heap.extractMax();
            System.out.print(max+" ");
        }
    }
}
