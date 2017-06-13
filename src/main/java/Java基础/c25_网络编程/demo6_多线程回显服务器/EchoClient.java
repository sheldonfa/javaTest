package Java基础.c25_网络编程.demo6_多线程回显服务器;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 测试
 */
class EchoClient implements Runnable{

    private static final int ECHO_SERVER_PORT = 10086;

    @Override
    public void run() {
        Socket client = null;
        try {
            FileReader fis = new FileReader("G:\\1工作\\1项目\\4测试项目\\javaTest2\\src\\main\\java\\Java基础\\c25_网络编程\\demo6_多线程回显服务器\\test");
            BufferedReader reader = new BufferedReader(fis);
            String line;
            while((line = reader.readLine())!=null){
                client = new Socket("localhost",ECHO_SERVER_PORT);
                PrintWriter pw = new PrintWriter(client.getOutputStream());
                pw.println(line);
                pw.flush();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
