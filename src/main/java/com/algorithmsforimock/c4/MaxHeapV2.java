package com.algorithmsforimock.c4;

import com.algorithms.model.Tlt;

/**
 * 实现 最大堆 结构，索引从0开始
 * @author fangxin
 * @description ${END}
 * @date 2017/3/21 0021.
 */
public class MaxHeapV2 {

    private Integer[]   data;
    private int         count;
    private int         capacity;

    public MaxHeapV2(int capacity) {
        this.capacity = capacity;
        count = 0;
        data = new Integer[capacity];
    }

    public MaxHeapV2(Integer[] arr){
        int n = arr.length;
        this.capacity = n;
        this.count = n;
        data = new Integer[capacity];
        for(int i=0;i<arr.length;i++){
            data[i] = arr[i];
        }
        // Heapify算法。将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)；heapify的过程，算法复杂度是O(n)
        for(int k=(n-2)/2;k>=0;k--){// 2k+1<=n-1 左子节点不能越界。
            shiftDown(k);
        }
    }

    public void insert(Integer item){
        assert count<capacity;
        count++;
        data[count-1] = item; // 索引比数量小1
        shiftUp(count-1);
    }

    public Integer extractMax(){
        assert(count>0);
        Integer max = data[0];
        // 最后一位顶上
        data[0] = data[count-1];
        // 减数量
        count--;
        shiftDown(0);
        return max;
    }

    private void shiftDown(int k) {
        while(2*k+1<count){
            int sun = 2*k+1;
            if(sun+1<count && data[sun]<data[sun+1]){
                sun+=1;
            }
            if(data[k]>data[sun]){
                break;
            }
            Tlt.exch(data,k,sun);
            k = sun;
        }
    }

    private void shiftUp(int k) { // 父节点 2*k+1 子节点 (p-1)/2
        while((k-1)/2>=0 && data[k]>data[(k-1)/2]){
            Tlt.exch(data,k,(k-1)/2);
            k = (k-1)/2;
        }
    }

    public static void main(String[] args) {
        Integer[] random = Tlt.random(100, 0, 1000);
        MaxHeapV2 heap = new MaxHeapV2(random);
        for(int i=0;i<100;i++){
            Integer max = heap.extractMax();
            System.out.print(max+", ");
        }
    }
}
