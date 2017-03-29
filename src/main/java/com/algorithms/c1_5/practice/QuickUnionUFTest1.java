package com.algorithms.c1_5.practice;

import com.algorithms.model.In;
import com.algorithms.model.StdOut;

import java.util.Arrays;

/**
 * @author fangxin
 * @date 2017/3/29.
 */
public class QuickUnionUFTest1 {

    private int[] parent; // 父节点
    private int count;

    public QuickUnionUFTest1(int n) {
        this.count = n; // 初始化分量是n
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i; // 初始化父节点都是自己
        }
    }

    // 查询根节点
    public int find(int p){
        // 父节点不是自己
        while(p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    // 是否相连
    public boolean isConnected(int p,int q){
        // 根节点相等，表示相连
        return find(p) == find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        // 根相等即为相连
        if(rootP==rootQ){
            return;
        }
        // 否则,由于
        parent[rootP] = rootQ;
        count--;
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        String tinyUF = "http://algs4.cs.princeton.edu/15uf/tinyUF.txt";
        String mediumUF = "http://algs4.cs.princeton.edu/15uf/mediumUF.txt";
        String largeUF = "http://algs4.cs.princeton.edu/15uf/largeUF.txt";
        int[] info = In.readInts(mediumUF);
        int[] arr = Arrays.copyOfRange(info, 1, info.length);
        int n = info[0]; // 触点数
        QuickUnionUFTest1 uf = new QuickUnionUFTest1(n);
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
