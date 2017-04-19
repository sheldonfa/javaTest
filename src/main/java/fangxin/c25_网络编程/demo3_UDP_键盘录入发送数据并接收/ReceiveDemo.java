package fangxin.c25_网络编程.demo3_UDP_键盘录入发送数据并接收;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议接收数据
 * @author fangxin
 * @date 2017/4/19.
 */
public class ReceiveDemo {

    public static void main(String[] args) throws IOException {
        receive(10086);
    }

    public static void receive(int port) throws IOException {
        // 创建socket
        DatagramSocket ds = new DatagramSocket(port);
        while(true){
            // 创建接收数据包
            byte[] data = new byte[1024];
            DatagramPacket dp = new DatagramPacket(data,data.length);
            // 接收数据
            // 此方法在接收到数据前一致阻塞
            ds.receive(dp);
            InetAddress address = dp.getAddress();
            String ip = address.getHostAddress();
            byte[] receiveData = dp.getData();
            System.out.println("from "+ip+":"+new String(receiveData));
            // 释放资源
        }
//        ds.close();

    }
}
