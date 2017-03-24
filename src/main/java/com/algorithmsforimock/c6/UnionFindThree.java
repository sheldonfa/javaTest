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
public class UnionFindThree {

    private int[] parent;
    private int[] rank;  // rank[i]表示以i为根的集合的树的层数
    private int count;

    public UnionFindThree(int n){
        count = n;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
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

    // (4-->3-->8,9)将元素少的集合根节点 指向 元素多的集合的根节点
    void union(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot==qRoot){
            return;
        }
        if(rank[pRoot]< rank[qRoot]){
            parent[pRoot] = qRoot;
        }else if(rank[pRoot]> rank[qRoot]){
            parent[qRoot] = pRoot;
        }else{
            parent[pRoot] = qRoot;
            rank[qRoot]+=1;
        }
    }
}
