package Java基础.c25_网络编程.demo5_TCP协议;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP协议发送数据
 * A：创建发送端的Socket对象
 * B：获取输出流，写数据
 * C：释放资源
 * @author fangxin
 * @date 2017/4/19.
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        Socket s = new Socket("192.168.0.100",10086);
        // 获取输出流
        OutputStream os = s.getOutputStream();
        // 写入数据
        os.write("hello".getBytes());
        // 释放资源
        s.close();
    }
}
