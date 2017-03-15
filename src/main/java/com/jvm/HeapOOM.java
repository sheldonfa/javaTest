package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fangxin
 * @date 2017/3/11.
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<HeapOOM>();
        while(true){
            list.add(new HeapOOM());
        }
    }
}
