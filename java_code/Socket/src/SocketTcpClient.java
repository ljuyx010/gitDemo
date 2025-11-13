import java.io.*;
import java.net.Socket;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/13 14:06
 */
public class SocketTcpClient {
    public static void main(String[] args) throws  IOException {
        System.out.println("客户端启动");
        // 实例化一个Socket对象，连接服务器的9999端口
        Socket socket = new Socket("localhost", 9999);
        System.out.println("连接服务器成功"+socket.getClass());
        //发送hello 给服务器
        OutputStream outputStream = socket.getOutputStream();
        // 使用字符流发送消息给服务器
        BufferedWriter OSW = new BufferedWriter(new OutputStreamWriter(outputStream));
        OSW.write("hello server");
        OSW.newLine(); // 发送换行符，结束消息,但对方必须使用readLine()方式接收才能生效
        OSW.flush(); // 使用字符流，需要手动刷新缓存，否则消息不会发送到服务器
        //outputStream.write("hello".getBytes());
        //设置输出流结束标记
        //socket.shutdownOutput();
        // 获取Socket的输入流
        InputStream inputStream = socket.getInputStream();

        // 读取服务端发送的消息
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            //根据读取到是实际长度，截取有效数据
            System.out.println(new String(bytes, 0, readLen));
        }

        //关闭输入流
        inputStream.close();
        //关闭输出流
        outputStream.close();
        //关闭socket
        socket.close();
    }
}
