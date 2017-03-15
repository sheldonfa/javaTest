package com.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * File文件过滤器
 * @author fangxin
 * @description ${END}
 * @date 2017/2/6 0006.
 */
public class DirFilter implements FilenameFilter {

    private Pattern pattern;

    public DirFilter(String regex){
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
