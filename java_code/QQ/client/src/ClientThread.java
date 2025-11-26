import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/*
 * 客户端线程，该线程持有Socket
 *
 */
public class ClientThread extends Thread {
    private Socket client;
    private String username;

    public ClientThread(String username,Socket client) {
        this.username=username;
        this.client = client;
    }

    public Socket getClient() {
        return client;
    }

    @Override
    public void run() {
        // 因为Thread需要再后台和服务器通信，因此需要我们while循环
        // 如果服务器没有发送消息过来，则会一直阻塞在readObject()
        while (true) {
            // System.out.println("客户端"+username+"的线程已启动，等待从服务器发送来的消息");
            try {
                ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
                Message message = (Message) ois.readObject();
                String sender = message.getSender(); //发送人
                String getter = message.getGetter();  // 接收人
                String content = message.getMessage(); // 消息内容
                String sendtime = message.getSendtime(); // 发送时间
                // 处理从服务器发送来的消息
                if (message.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIEND)) {
                    // 处理获取到的在线好友列表
                    System.out.println("\n======当前在线好友列表======");
                    String message1 = message.getMessage();
                    String[] onlineFriends = message1.split(" ");
                    for (String friend : onlineFriends) {
                        System.out.println(friend);
                    }
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ONE)) {
                    // 处理服务器发来的私聊消息
                    System.out.println("\n" + sendtime + " " + sender + "对" + getter + "说:" + content);
                } else if (message.getMesType().equals(MessageType.MESSAGE_TO_ALL)) {
                    System.out.println("\n" + sendtime + " " + sender + "对大家说:" + content);
                } else if (message.getMesType().equals(MessageType.MESSAGE_FILE)) {
                    // 接收文件
                    String src = message.getSrc();
                    String dest = message.getDest();
                    byte[] fileDate = message.getFileDate();
                    System.out.println("\n" + sendtime + " " + sender + "给" + getter + "发送了文件:" + src + "文件保存在" + dest);
                    FileOutputStream fos = new FileOutputStream(dest);
                    fos.write(fileDate);
                    fos.close();
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

}
