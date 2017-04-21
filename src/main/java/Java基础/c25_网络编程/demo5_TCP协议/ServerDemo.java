package Java基础.c25_网络编程.demo5_TCP协议;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议接收数据：
 * A:创建接收端Socket对象
 * B:监听客户端连接。返回一个对应的Socket对象
 * C:释放输入流，读取数据显示在控制台
 * D:释放资源
 * @author fangxin
 * @date 2017/4/19.
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        // 阻塞方法
        Socket s = ss.accept();
        InputStream in = s.getInputStream();

        byte[] bytes = new byte[1024];
        int len = in.read(bytes);// 阻塞方法
        String str = new String(bytes,0,len);
        System.out.println(str);
        // 释放资源
        s.close();
//        ss.close();// 服务端不应该关闭
    }
}
