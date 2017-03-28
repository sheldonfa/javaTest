package com.algorithmsforimock.c7;

import java.util.Vector;

/**
 * @author fangxin
 * @date 2017/3/24.
 */
public class SparseGraph {
    int n,m;
    boolean directed;
    private Vector<Vector<Integer>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for(int i=0;i<n;i++){
            g.add(new Vector<Integer>());
        }
    }

    int V(){
        return n;
    }
    int E(){
        return m;
    }

    void addEdge(int v, int w){
        assert (v>=0 && v<n);
        assert (w>=0 && w<n);
        g.get(v).add(w);
        if(v!=w && !directed){
            g.get(w).add(v);
        }
    }

    boolean hasEdge(int v,int w){
        assert (v>=0 && v<n);
        assert (w>=0 && w<n);
        for(int i=0;i<g.get(v).size();i++){
            if(g.get(v).get(i)==w){
                return true;
            }
        }
        return false;
    }


}
