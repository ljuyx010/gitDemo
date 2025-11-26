import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/17 14:22
 */
public class ServerThreads extends Thread{
    private Socket socket;
    private String username;
    private ConcurrentHashMap<String, List<Message>> lineoutMessage;

    public ServerThreads(String username,Socket socket) throws IOException, ClassNotFoundException {
        this.username=username;
        this.socket = socket;
        this.lineoutMessage = Server.getLineoutMessage();
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
                Message mes = (Message) ois.readObject(); // 服务器接收客户端发来的信息
                String  sender = mes.getSender(); //发送人
                String  getter = mes.getGetter();  // 接收人
                String  content = mes.getMessage(); // 消息内容
                String hfcontent = ""; // 回复内容
                //  System.out.println(sender+"对"+getter+"说："+content);
                HashMap<String, ServerThreads> map = ManageThreads.getMap();
//                Iterator<String> iterator = this.lineoutMessage.keySet().iterator();
//                while(iterator.hasNext()){
//                    String key = iterator.next();
//                    List<Message> list = lineoutMessage.get(key);
//                    System.out.println("key:"+key);
//                    for(Message m : list){
//                        System.out.println(m.getSender()+" "+m.getMessage());
//                    }
//                }
//                System.out.println("=========================");
                // 首次登录判断是否有离线消息
                if(mes.getMesType().equals(MessageType.MESSAGE_ONLINE_FRIEND)){
                    // 处理从客户端发送来的获取在线好友列表信息
                    for(String key:map.keySet()){
                        if(!key.equals(sender)){
                            hfcontent += key+" ";
                        }
                    }
                    Message message = new Message();
                    message.setMesType(MessageType.MESSAGE_ONLINE_FRIEND);
                    message.setMessage(hfcontent);
                    message.setGetter(sender);
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                }else if(mes.getMesType().equals(MessageType.MESSAGE_TO_ONE)){
                    // 处理私聊类型的消息
                    if(!map.containsKey(getter)){
                        System.out.println(getter+"用户不在线，消息保存到离线集合中");
                        // getter 不在线就存到离线集合中
                        if(this.lineoutMessage.containsKey(getter)){
                            // getter 已经在离线集合中
                            this.lineoutMessage.get(getter).add(mes);
                        }else {
                            List<Message> messages = new ArrayList<>();
                            messages.add(mes);
                            this.lineoutMessage.put(getter, messages);
                        }
                    }else {
                        // getter 在线就直接转发
                        Socket socket = map.get(getter).getSocket(); // 获取接收人关联的socket
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(mes); // 服务器把消息转发给getter
                    }
                }else if(mes.getMesType().equals(MessageType.MESSAGE_TO_ALL)){
                    // 处理群聊类型的消息
                    for(String key:map.keySet()){
                        if(!key.equals(sender)){
                            Socket socket = ManageThreads.getMapSocket(key).getSocket(); // 遍历不是发送人的其他人关联的socket
                            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(mes);
                        }
                    }
                }else if(mes.getMesType().equals(MessageType.MESSAGE_FILE)){
                    //转发文件
                    if(!map.containsKey(getter)){
                        // getter 不在线就存到离线集合中
                        if(this.lineoutMessage.containsKey(getter)){
                            // getter 已经在离线集合中
                            this.lineoutMessage.get(getter).add(mes);
                        }else {
                            List<Message> messages = new ArrayList<>();
                            messages.add(mes);
                            this.lineoutMessage.put(getter, messages);
                        }
                    }else {
                        Socket socket = map.get(getter).getSocket(); // 获取接收人关联的socket
                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(mes); // 服务器把消息转发给getter
                    }
                }else if(mes.getMesType().equals(MessageType.MESSAGE_EXIT)){
                    // 处理退出类型的消息
                    ManageThreads.removeThread(sender);
                    System.out.println(sender+"正常退出聊天系统");
                    break;
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
