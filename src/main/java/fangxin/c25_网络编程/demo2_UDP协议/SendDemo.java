package fangxin.c25_网络编程.demo2_UDP协议;

import java.io.IOException;
import java.net.*;

/**
 * UDP协议发送数据：
 * @author fangxin
 * @date 2017/4/19.
 */
public class SendDemo {

    public static void main(String[] args) throws IOException {
        // 创建Socket对象
        DatagramSocket ds = new DatagramSocket();
        // 创建数据
        byte[] data = "hello fangxin".getBytes();
        // 数据打包
        InetAddress address = InetAddress.getByName("192.168.0.100");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(data,data.length,address,port);
        // 发送数据
        ds.send(dp);
        // 释放资源
        ds.close();
    }
}
