import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/21 16:47
 */
public class ClientMessage {
    private Socket socket;
    private OutputStream out;
    Message message = new Message();

    public ClientMessage(String username) {
        this.socket = ManageThreads.getThread(username).getClient();
        this.message.setSender(username);
        this.message.setSendtime(new Date().toString());
        try {
            this.out = this.socket.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 获取在线好友列表
    public void getOnlineFriend() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(this.out);
            message.setMesType(MessageType.MESSAGE_ONLINE_FRIEND);
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String type,String content,String getter) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(this.out);
            message.setMesType(type);
            message.setGetter(getter);
            message.setMessage(content);
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String type,String getter,String src,String dst) {
        try {
            File file = new File(src);
            FileInputStream fis = new FileInputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(this.out);
            byte[] fileData = new byte[(int)file.length()];
            // 把文件的二进制数据写入到数组
            fis.read(fileData);
            message.setMesType(type);
            message.setGetter(getter);
            message.setSrc(src);
            message.setDest(dst);
            message.setFileDate(fileData);
            oos.writeObject(message);
            fis.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 退出系统
    public void exit() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(this.out);
            message.setMesType(MessageType.MESSAGE_EXIT);
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
