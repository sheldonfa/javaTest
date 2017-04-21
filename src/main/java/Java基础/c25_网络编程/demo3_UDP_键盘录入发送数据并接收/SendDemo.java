package Java基础.c25_网络编程.demo3_UDP_键盘录入发送数据并接收;


import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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


    }
}
