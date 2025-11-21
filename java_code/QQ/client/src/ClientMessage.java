import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/21 16:47
 */
public class ClientMessage {
    private String username;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    Message message = new Message();

    public ClientMessage(String username) {
        this.username = username;
        this.socket = ManageThreads.getThread(username).getClient();
        this.message.setSender(username);
        this.message.setSendtime(new Date().toString());
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取在线好友列表
    public void getOnlineFriend() {
        try {
            message.setMesType(MessageType.MESSAGE_ONLINE_FRIEND);
            this.out.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 退出系统
    public void exit() {
        try {
            message.setMesType(MessageType.MESSAGE_EXIT);
            this.out.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
