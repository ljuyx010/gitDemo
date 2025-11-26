import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/25 15:33
 */
public class SendNews implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.print("请输入要群发的信息：");
            String news = Utility.readString(100,false);
            if(news.equals("exit")){
                // 退出群发线程
                break;
            }
            Message msg = new Message();
            msg.setMessage(news);
            msg.setSender("服务器");
            msg.setMesType(MessageType.MESSAGE_TO_ALL);
            msg.setSendtime(new Date().toString());
            // System.out.println(msg.toString());
            HashMap<String, ServerThreads> map = ManageThreads.getMap();
            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                Socket socket = map.get(key).getSocket();
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(msg);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
