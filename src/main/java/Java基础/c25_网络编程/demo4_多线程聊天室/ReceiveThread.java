package Java基础.c25_网络编程.demo4_多线程聊天室;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author fangxin
 * @date 2017/4/19.
 */
public class ReceiveThread implements Runnable{

    @Override
    public void run() {
        try{
            // 创建socket
            DatagramSocket ds = new DatagramSocket(10086);
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
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
