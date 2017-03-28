package com.algorithmsforimock.practice;

/**
 * @author fangxin
 * @date 2017/3/28.
 */
public class UnionFind {

    private int[] id;
    private int count;

    public UnionFind(int n) {
        count = n;
        for(int i=0;i<count;i++){
            id[i] = i;
        }
    }

    int find(int p){
        assert p>=0&&p<count;
        return id[p];
    }

    boolean isConnected(int p,int q){

        return find(p)==find(q);
    }

    void union(int p,int q){
        if(isConnected(p,q)){
            return;
        }
        for(int i=0;i<count;i++){
            if(id[i]==find(p)){
                id[i] = find(q);
            }
        }
    }
}
