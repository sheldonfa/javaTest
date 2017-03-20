package com.algorithmsforimock.c4;

import com.algorithms.model.Tlt;

/**
 * 最大索引堆
 */
public class IndexMaxHeap {

    private Integer[]       data;
    // 索引堆
    private Integer[]       indexes; // indexes[i] = j,索引堆中i位置的索引是j
    private Integer[]       reverse; // reverse[j] = i,索引j在索引堆中的位置是i。reverse[indexes[i]] = i;
    private int             count;
    private int             capacity;

    public IndexMaxHeap(int capacity) {
        data = new Integer[capacity+1];
        indexes = new Integer[capacity+1];
        reverse = new Integer[capacity+1];
        for(int i= 0;i<=capacity;i++){
            reverse[i] = 0; // 索引i在堆中不存在，因为该类的索引是从1开始计数的。
        }
        count = 0;
        this.capacity = capacity;
    }

    // 新的构造函数
    public IndexMaxHeap(Integer[] arr, int n) {
        this.data = new Integer[n+1];
        this.capacity = n;
        for(int i=0;i<n;i++){
            data[i+1] = arr[i];
        }
        count = n;

        for(int i=count/2;i>=1;i--){// Heapify算法。将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)；heapify的过程，算法复杂度是O(n)
            shiftDown(i);
        }
    }

    int size(){
        return count;
    }

    boolean isEmpty(){
        return count == 0;
    }

    // 传入的i对用户而言，是从0索引的
    void insert(int i, int item){
        assert(count+1<=capacity);
        assert(i+1>=1 && i+1<=capacity);
        i+=1;
        // 体会data和indexes存储的差别
        data[i] = item;
        indexes[count+1] = i;
        reverse[i] = count+1;
        count++;
        shiftUp(count);
    }

    public int extractMax(){
        assert (count>0);
        Integer ret = data[indexes[1]];
        Tlt.exch(indexes,1,count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;//count--就是为了删除该值。
        count--;
        shiftDown(1);
        return ret;
    }

    public int extractMaxIndex(){
        assert (count>0);
        // 对于外部，索引从0开始
        int ret = indexes[1]-1;
        Tlt.exch(indexes,1,count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;//count--就是为了删除该值。
        count--;
        shiftDown(1);
        return ret;
    }

    boolean contain(int i){
        assert (i+1>=1 && i+1 <=capacity);
        return reverse[i+1]!=0; //客户索引i从0开始
    }

    Integer getItem(int i){
        assert (contain(i));
        return data[i+1];
    }

    void change(int i, Integer newItem){
        // i索引的元素真的存在吗？i在capacity范围内，并不意味着i索引在堆中。堆可能并没有装满。
        assert(contain(i));

        i += 1;
        data[i] = newItem;
        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j),再shiftDown(j)
//        for(int j=1;j<=count;j++){//时间复杂度 on+ologn级别 约等于 on级别
//            if(indexes[j]==i){
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }
//        }

        int j = reverse[i]; // 通过反向查找，将级别降到了logn
        shiftDown(j);
        shiftDown(j);
    }

    private void shiftUp(int k) {
        // 比较和交换的都是索引，data数据不变
        while(k>1 && data[indexes[k/2]] <data[indexes[k]]){
            Tlt.exch(indexes,k/2,k);
            reverse[indexes[k/2]] = k/2;
            reverse[indexes[k]] = k;
            k/=2;
        }
    }

    private void shiftDown(int k) {
        while(2*k<=count){// 保证有子节点
            int j = 2*k; // 此轮循环中，data[k]和data[j]交换
            if(j+1 <= count && data[indexes[j+1]]>data[indexes[j]]){
                j +=1;
            }
            if(data[indexes[k]]>=data[indexes[j]]){
                break;
            }
            Tlt.exch(indexes,k,j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    public static void main(String[] args) {

    }
}
