package com.algorithmsforimock.c6;

/**
 * 并查集
 *
 * ele      1 2 3 4 5 6 7 8 9
 * parent   1 2 3 4 5 6 7 8 9
 *
 * @author fangxin
 * @date 2017/3/23.
 */
public class UnionFindTwo {

    private int[] parent;
    private int count;

    public UnionFindTwo(int n){
        count = n;
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    // 找到parent是自己为止
    int find(int p){
        assert (p>=0 && p<count);
        while(p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    boolean isConnected(int p,int q){
        return find(p)==find(q);
    }

    void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }
}
