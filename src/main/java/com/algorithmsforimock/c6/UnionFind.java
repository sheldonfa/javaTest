package com.algorithmsforimock.c6;

import com.algorithms.model.StdIn;
import com.algorithms.model.StdOut;

/**
 * 并查集
 *
 * ele  1 2 3 4 5 6 7 8 9
 * id   1 2 3 4 5 6 7 8 9
 *
 * @author fangxin
 * @date 2017/3/23.
 */
public class UnionFind {

    private int[] id;
    private int count;

    public UnionFind(int n){
        count = n;
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i] = i;
        }
    }

    int find(int p){
        assert (p>=0 && p<count);
        return id[p];
    }

    boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    void union(int p,int q){
        int pId = find(p);
        int qId = find(q);
        if(pId==qId){
            return;
        }
        for(int i=0;i<count;i++){
            if(id[i]==pId){
                id[i]=qId;
            }
        }
    }

    public int count(){
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.isConnected(p,q)){
                continue;
            }
            uf.union(p,q);
            StdOut.println(StdIn.isEmpty());
        }
        StdOut.println(uf.count()+"components");
    }
}
