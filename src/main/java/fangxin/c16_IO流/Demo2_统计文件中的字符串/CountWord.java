package fangxin.c16_IO流.Demo2_统计文件中的字符串;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author fangxin
 * @description ${END}
 * @date 2017/4/19 0019.
 */
public class CountWord {

    public static int countWordInFile(String filename, String word) throws IOException {
        int count = 0;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine())!=null){
            int index = -1;
            while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0){
                count++;
                line = line.substring(index+word.length());
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo2_统计文件中的字符串\\test";
        int count = countWordInFile(fileName, "apple");
        System.out.printf("共%d个",count);
    }
}
