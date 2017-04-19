package fangxin.c16_IO流.Demo3_列出目录下文件;

import java.io.File;

/**
 *
 * 只是列出文件
 */
public class Demo1 {
    public static void main(String[] args) {
        File f = new File("G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo3_列出目录下文件");
        for(File temp : f.listFiles()) {
            if(temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }
}
