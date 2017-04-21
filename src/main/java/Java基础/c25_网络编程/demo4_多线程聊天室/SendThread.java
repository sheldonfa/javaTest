package Java基础.c25_网络编程.demo4_多线程聊天室;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author fangxin
 * @date 2017/4/19.
 */
public class SendThread implements Runnable{

    @Override
    public void run() {
        try{
            // 创建Socket对象
            DatagramSocket ds = new DatagramSocket();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String info = null;

            while(StringUtils.isNotEmpty(info=buffer.readLine())){
                // 创建数据
                byte[] bytes = info.getBytes();
                // 数据打包
                InetAddress address = InetAddress.getByName("192.168.0.100");
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,10086);
                // 发送数据
                ds.send(dp);
                // 释放资源
            }
            ds.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
