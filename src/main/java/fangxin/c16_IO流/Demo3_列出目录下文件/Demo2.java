package fangxin.c16_IO流.Demo3_列出目录下文件;

import java.io.File;

/**
 * 对文件夹继续展开
 */
public class Demo2 {
    public static void showDirectory(File f) {
        _walkDirectory(f, 0);
    }
    private static void _walkDirectory(File f, int level) {
        if(f.isDirectory()) {
            for(File temp : f.listFiles()) {
                _walkDirectory(temp, level + 1);
            }
        }
        else {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }
    public static void main(String[] args) {
        showDirectory(new File("G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo3_列出目录下文件"));
    }

}
