import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/13 14:02
 */
public class SocketTcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器启动，监听9999端口");
        // 实例化一个ServerSocket对象，监听9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        // 调用accept()方法，等待客户端连接
        // 这个serverSocket可以通过accept()返回多个Socket连接【多个客户端同时连接服务器】
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接"+socket.getClass());
        // 建立输入流，读取客户端发送的消息
        InputStream inputStream = socket.getInputStream();
        // 读取客户端发送的消息
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1) {
            //根据读取到是实际长度，截取有效数据
            System.out.println(new String(bytes, 0, readLen));
        }
        // 获取Socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        // 发送消息给客户端
        outputStream.write("hello client".getBytes());
        // 发送完信息，必须设置结束标记，否则客户端会一直阻塞等待
        socket.shutdownOutput();
        // 关闭输出流
        outputStream.close();
        // 关闭输入流
        inputStream.close();
        // 关闭socket
        socket.close();
    }
}
