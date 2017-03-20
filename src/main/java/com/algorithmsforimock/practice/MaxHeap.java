package com.algorithmsforimock.practice;

import com.algorithms.model.StdRandom;
import com.algorithms.model.Tlt;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/3/20 0020.
 */
public class MaxHeap {

    private Comparable[] data;
    private int capacity;
    private int count;


    public MaxHeap(int capacity){
        this.capacity = capacity;
        count = 0;
        data = new Comparable[capacity];
    }

    public void insert(Comparable item){
        assert count+1 <= capacity;
        data[count+1] = item;
        count++;
        shiftUp(data,count);
    }

    private void shiftUp(Comparable[] data, int k) {
        while(k>1 && Tlt.less(data[k/2],data[k]) ){
            Tlt.exch(data,k,k/2);
            k/=2;
        }
    }

    public Comparable extractMax(){
        assert count >0;
        Comparable res = data[1];
        Tlt.exch(data,1,count);
        count--;
        shiftDown(1);
        return res;
    }

    private void shiftDown(int k) {
        while(2*k<=count){
            int j = 2*k;
            if(j+1 <=count && Tlt.less(data[j],data[j+1])){
                j+=1;
            }
            if(Tlt.less(data[j],data[k])){
                break;
            }
            Tlt.exch(data,k,j);
            k = j;
        }
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);
        for(int i=0;i<99;i++){
            maxHeap.insert(StdRandom.uniform(0,100));
        }
        for(int i=0;i<99;i++){
            System.out.print(maxHeap.extractMax()+",");
        }

    }

    public boolean isEmpty(){
        return count==0;
    }

    public int size(){
        return capacity;
    }
}
