package Java基础.c25_网络编程.demo6_多线程回显服务器;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket多线程回显
 * Created by mrf on 2016/3/17.
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 10086;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)) {
            System.out.println("=================================");
            System.out.println("============服务启动 =============");
            while (true){
                Socket client = server.accept();
                // 开启一个新的线程回显信息
                new Thread(new ClientHandler(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class ClientHandler implements Runnable{
        private Socket client;
        public ClientHandler(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            // 自动释放资源
            try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter pw = new PrintWriter(client.getOutputStream())
            ) {
                String msg = br.readLine();
                System.out.println("收到"+client.getInetAddress()+"发送的："+msg);
                pw.println(msg);
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

