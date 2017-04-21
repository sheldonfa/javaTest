package Java基础.c16_IO流.Demo1_文件拷贝;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class MyUtil {
    /**
     * 同样是拷贝方法，你为什么这么丑陋
     */
    public static void fileCopy(String source, String target) throws IOException {
        InputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(target);
        byte[] buffer = new byte[1024];
        // 读出
        int length;
        while ((length=in.read(buffer))!=-1){
            // 写入
            out.write(buffer,0,length);
        }
        in.close();
        out.close();

    }

    /**
     * 这种方式太帅，一时让我无法忘怀，推荐
     *
     */
    public static void fileCopyNIO(String source, String target) throws IOException {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(target);
        FileChannel inChannel = in.getChannel();
        FileChannel outChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(inChannel.read(buffer)!=-1){
            // 我的理解就是，读入的时候改变了buffer的指针，position表示你读到什么位置了。如果还要读入，应该从position的下一位开始。
            // 但是写出时，position就是你最大能读到的位置了，变成了limit，而position应该变成0才对。
            // 这个动作就是flip
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
    }

    /**
     * 实现拷贝文件
     */
    public static void main(String[] args){
        try {
            fileCopy("G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo1_文件拷贝\\test1","G:\\1工作\\1项目\\javaTest2\\src\\main\\java\\fangxin\\c16_IO流\\Demo1_文件拷贝\\test2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * flip
     * 此方法位于：java.nio.Buffer Buffer是一个用于特定基本类型数据的容器。
     缓冲区是特定基本类型元素的线性有限序列。除内容外，缓冲区的基本属性还包括容量（capacity）、限制（limit）和位置（position）：
     缓冲区的capacity是它所包含的元素的数量。缓冲区的capacity不能为负并且不能更改。
     缓冲区的limit 是第一个不应该读取或写入的元素的索引。缓冲区的limit不能为负，并且不能大于其capacity。
     缓冲区的position是下一个要读取或写入的元素的索引。缓冲区的位置不能为负，并且不能大于其limit。对于每个非 boolean 基本类型，此类都有一个子类与之对应。

     在使用缓冲区进行输入输出数据之前，必须确定缓冲区的position，limit都已经设置了正确的值。

     如果现在想用这个缓冲区进行信道的写操作，由于write()方法将从position指示的位置开始读取数据，在limit指示的位置停止，因此在进行写操作前，先要将limit的值设为position的当前值，再将position的值设为0。这个操作可以通过这个flip()方法实现。
     flip()使缓冲区为一系列新的通道写入或相对获取 操作做好准备：它将限制设置为当前位置，然后将位置设置为0，即上边的要求（红色字体表示）。

     所以，上边的操作步骤为：buffer.flip();
     out.write(buffer);
     */
}
