package fangxin.c25_网络编程.demo1_ip地址对象;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author fangxin
 * @date 2017/4/19.
 */
public class InetAddressDemo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.0.100");
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println(hostAddress);
        System.out.println(hostName);
    }
}
