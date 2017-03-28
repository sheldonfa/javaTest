package com.algorithmsforimock.c7;


import java.util.Vector;

/**
 * @author fangxin
 * @date 2017/3/24.
 */
public class DenseGraph {

    private int n,m;
    private boolean directed;
    private Vector<Vector<Boolean>> g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        for(int i=0;i<n;i++){
            g.add(new Vector<Boolean>());
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
        g.get(v).add(true);
        if(!directed){
            g.get(w).add(true);
        }
        m++;
    }
    boolean hasEdge(int v,int w){
        assert (v>=0 && v<n);
        assert (w>=0 && w<n);
        return g.get(v).get(w);
    }
}
