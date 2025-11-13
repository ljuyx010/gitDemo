import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/13 16:41
 */
public class UdpReceiver {
    public static void main(String[] args) throws IOException {
      //创建一个DatagramSocket对象，准备在8888接收数据
      DatagramSocket socket = new DatagramSocket(8888);
      //构建一个DatagramPacket对象，准备接收数据
      byte[] bytes = new byte[64*1024]; //udp数据报最大64k
      DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
      //调用socket的receive方法，将数据接收在packet中，当本机的8888端口有数据时，就会自动接收，
        // 如果没有数据，就会阻塞等待
      socket.receive(packet);
      //从packet中拆包提取数据
      int len = packet.getLength(); //实际接收到的数据长度
      byte[] data = packet.getData();
      System.out.println(new String(data, 0, len));
      // 接收结束
      // 回复发送端
      byte[] sendData = "好的 明天见".getBytes();
      //构建一个DatagramPacket对象，准备发送数据
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, packet.getAddress(), packet.getPort());
      //调用socket的send方法，将数据发送到packet中
      socket.send(sendPacket);
      //关闭socket
      socket.close();
    }
}
