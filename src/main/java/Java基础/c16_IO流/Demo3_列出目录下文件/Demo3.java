package Java基础.c16_IO流.Demo3_列出目录下文件;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Demo3 {

    /**
     * java7列出目录下文件很简单
     *
     */
    public static void main(String[] args) throws IOException {
        String filename = "H:\\1工作\\1项目\\4测试项目\\javaTest2\\src\\main\\java\\Java基础\\c16_IO流\\Demo3_列出目录下文件";
        Path initPath = Paths.get(filename);
        Files.walkFileTree(initPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                System.out.println(file.getFileName().toString());
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
