package com.algorithms.c1_5;

import com.algorithms.model.In;
import com.algorithms.model.StdOut;
import java.util.Arrays;


public class QuickFindUF {
    /**
     * 定义：将对象称为触点，将等价的节点 称为分量
     *
     * 每个分量都是由它的触点之一表示的
     */
    private int[] id;    // 分量
    private int count;   // 分量数量

    /**
     * 一开始我们有n个分量，每个触点都构成了一个只含有自己的分量。
     * 因此将id[i]初始化为i，其中i在0到n-1之间
     */
    public QuickFindUF(int n) {
        count = n; // 初始化的分量数量是n
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param  p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IndexOutOfBoundsException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same component;
     *         {@code false} otherwise
     * @throws IndexOutOfBoundsException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    /**
     * Merges the component containing site {@code p} with the
     * the component containing site {@code q}.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     * @throws IndexOutOfBoundsException unless
     *         both {@code 0 <= p < n} and {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];   // needed for correctness
        int qID = id[q];   // to reduce the number of array accesses

        // p and q are already in the same component
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input,
     * where each integer represents some site;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        String tinyUF = "http://algs4.cs.princeton.edu/15uf/tinyUF.txt";
        String mediumUF = "http://algs4.cs.princeton.edu/15uf/mediumUF.txt";
        String largeUF = "http://algs4.cs.princeton.edu/15uf/largeUF.txt";
        int[] info = In.readInts(mediumUF);
        int[] arr = Arrays.copyOfRange(info, 1, info.length);
        int n = info[0]; // 触点数
        QuickFindUF uf = new QuickFindUF(n);
        for(int i=0;i<arr.length;i+=2){
            int p = arr[i];
            int q = arr[i+1];
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }

}

