package com.algorithmsforimock.c6;

import com.algorithms.model.In;
import com.algorithms.model.StdOut;

import java.util.Arrays;

/**
 * 路径压缩降低层级并查集，等同于UnionFindFour
 * @author fangxin
 * @date 2017/3/31.
 */
public class WeightedQucikUnionPathCompressUF {
    private int[]   parent;
    private int     count;
    private int[]     rank;

    public WeightedQucikUnionPathCompressUF(int n) {
        count = n;
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++){
            rank[i] = 1;//初始化，各节点相互独立，层级都为1
            parent[i] = i; //节点的父都是自己
        }
    }

    // 返回分量数量
    public int count(){
        return count;
    }

    // 获取根节点
    public int find(int p){
        if(p!=parent[p]){
            // 如果父节点不是根节点，找到父节点的根节点，并挂接上去
            parent[p] = find(parent[p]);
        }
        // 返回根节点
        return parent[p];
    }

    // 是否相连
    public boolean isConnected(int p, int q){
        // 根节点相连就是相连
        return find(p)==find(q);
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ){
            return;
        }
        // rootP的层级高于rootQ的层级
        if(rank[rootP]>rank[rootQ]){
            // 将rootQ挂接到rootP上
            parent[rootQ] = rootP;
        }else if(rank[rootP]<rank[rootQ]){
            parent[rootP] = rootQ;
        }else if(rank[rootP]==rank[rootQ]){
            // 随便挂，但是rank+1
            parent[rootP] = rootQ;
            rank[rootQ]++;
        }
        // 分量数因为相连 减少1
        count--;
    }

    public static void main(String[] args) {
        String tinyUF = "http://algs4.cs.princeton.edu/15uf/tinyUF.txt";
        String mediumUF = "http://algs4.cs.princeton.edu/15uf/mediumUF.txt";
        String largeUF = "http://algs4.cs.princeton.edu/15uf/largeUF.txt";
        int[] info = In.readInts(tinyUF);
        int[] arr = Arrays.copyOfRange(info, 1, info.length);
        int n = info[0]; // 触点数
        WeightedQucikUnionPathCompressUF uf = new WeightedQucikUnionPathCompressUF(n);
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
