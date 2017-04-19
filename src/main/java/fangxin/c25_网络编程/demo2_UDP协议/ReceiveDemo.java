package fangxin.c25_网络编程.demo2_UDP协议;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP协议接收数据
 * @author fangxin
 * @date 2017/4/19.
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        // 创建socket
        DatagramSocket ds = new DatagramSocket(10086);
        // 创建接收数据包
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        // 接收数据
        // 此方法在接收到数据前一致阻塞
        ds.receive(dp);
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();
        byte[] receiveData = dp.getData();
        System.out.println("从"+ip+"接受到的数据是"+receiveData);
        // 释放资源
        ds.close();
    }
}
