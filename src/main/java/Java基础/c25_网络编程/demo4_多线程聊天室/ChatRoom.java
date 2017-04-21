package Java基础.c25_网络编程.demo4_多线程聊天室;

/**
 * @author fangxin
 * @date 2017/4/19.
 */
public class ChatRoom {

    public static void main(String[] args) {
        Thread send = new Thread(new SendThread());
        Thread receive = new Thread(new ReceiveThread());
        send.start();
        receive.start();
    }
}
