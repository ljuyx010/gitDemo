import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/17 14:22
 */
public class ServerThreads extends Thread{
    private Socket socket;
    private String username;
    public ServerThreads(String username,Socket socket){
        this.username=username;
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("服务器端链接"+username+"的线程启动");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message mes = (Message) ois.readObject();
                // 处理从客户端发送来的消息
                if(mes.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIEND)){
                    String sender = mes.getSender();
                    HashMap<String, ServerThreads> map = ManageThreads.getMap();
                    String content = "";
                    for(String key:map.keySet()){
                        if(!key.equals(sender)){
                            content += key+" ";
                        }
                    }
                    Message message = new Message();
                    message.setMesType(MessageType.MESSAGE_ONLINE_FRIEND);
                    message.setMessage(content);
                    message.setGetter(sender);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                }else{
                    // 处理其他类型的消息
                    System.out.println(mes);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
