package com.algorithms.c1_5.practice;

import com.algorithms.model.In;
import com.algorithms.model.StdOut;

import java.util.Arrays;

/**
 * @author fangxin
 * @date 2017/3/29.
 */
public class QuickFindUFTest1 {

    private int[] id;
    private int count;

    public QuickFindUFTest1(int n) {
        count = n;
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i] = i; // 初始化id值，各不相同代表不相互连接
        }
    }

    public int find(int p){
        validate(p);
        return id[p];
    }

    public boolean isConnected(int p, int q){
        // id相等代表相互连接
        return find(p)==find(q);
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if(pId==qId){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(id[i]==pId){
                id[i] = qId;
            }
        }
        count--;
    }

    public int count(){
        return count;
    }

    private void validate(int p) {
        int n = id.length;
        if( p<0 || p>=n ){
            throw new IndexOutOfBoundsException("数值越界了");
        }
    }

    public static void main(String[] args) {
        String tinyUF = "http://algs4.cs.princeton.edu/15uf/tinyUF.txt";
        String mediumUF = "http://algs4.cs.princeton.edu/15uf/mediumUF.txt";
        String largeUF = "http://algs4.cs.princeton.edu/15uf/largeUF.txt";
        int[] info = In.readInts(mediumUF);
        int[] arr = Arrays.copyOfRange(info, 1, info.length);
        int n = info[0]; // 触点数
        QuickFindUFTest1 uf = new QuickFindUFTest1(n);
        for(int i=0;i<arr.length;i+=2){
            int p = arr[i];
            int q = arr[i+1];
            if (uf.isConnected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}
