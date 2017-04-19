package fangxin.c16_IO流.Demo3_列出目录下文件;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Demo3 {

    /**
     * java7列出目录下文件很简单
     *
     */
    public static void main(String[] args) throws IOException {
        String filename = "G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo3_列出目录下文件";
        Path initPath = Paths.get(filename);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return super.postVisitDirectory(dir, exc);
            }
        });
    }
}
