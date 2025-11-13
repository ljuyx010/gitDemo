import java.io.IOException;
import java.net.*;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/13 16:42
 */
public class Udpsender {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，准备在8889发送数据
        DatagramSocket socket = new DatagramSocket(8889);
        //构建一个DatagramPacket对象，准备发送数据
        byte[] bytes = "hello 明天吃火锅".getBytes();
        //构建一个DatagramPacket对象，bytes内容字节数组，bytes.length 字节长度，ip和端口号
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 8888);
        //调用socket的send方法，将数据发送到packet中
        socket.send(packet);
        //发送结束
        // 接收接收方的回复
        byte[] receiver = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(receiver, receiver.length);
        socket.receive(datagramPacket);
        int len = datagramPacket.getLength(); //实际接收到的数据长度
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data, 0, len));
        //关闭socket
        socket.close();
    }
}
