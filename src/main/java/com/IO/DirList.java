package com.IO;

import java.io.File;
import java.util.Arrays;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/2/6 0006.
 */
public class DirList {

    public void getFilePath(String[] args){
        File path = new File(".");
        String[] list;
        if(args.length==0){
            list = path.list();
        }else {
            list = path.list(new DirFilter(args[0]));
        }
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem: list){
            System.out.println(dirItem);
        }
    }
}
