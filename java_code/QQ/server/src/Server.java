import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/*
 * 服务器类
 */
public class Server {
    private final int port = 8888;
    private final ServerSocket serverSocket;
    private boolean running = true;
    // 此处使用可以处理并发的集合ConcurrentHashMap更合适，没有线程安全问题，HashMap在多线程情况下是不安全的。
    private static ConcurrentHashMap<String,User> users = new ConcurrentHashMap<String,User>();

    static{
        users.put("admin",new User("admin","123456"));
        users.put("至尊宝",new User("至尊宝","123456"));
        users.put("紫霞仙子",new User("紫霞仙子","123456"));
        users.put("牛魔王",new User("牛魔王","123456"));
        users.put("白晶晶",new User("白晶晶","123456"));
        users.put("菩提老祖",new User("菩提老祖","123456"));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Server();
    }

    // 验证用户的用户名和密码
    private boolean checkUser(String username,String password){
        User user = users.get(username);
        if (user == null){
            return false;
        }
        if (!user.getPassword().equals(password)){
            return false;
        }
        return true;
    }

    public Server() throws IOException, ClassNotFoundException {
        serverSocket = new ServerSocket(port);
        while (running) {
            // 当服务端和客户端建立连接后，会继续循环监听
            Socket socket = serverSocket.accept(); // 如果没有客户端连接则会阻塞在这里
            // 得到一个和socket关联的输入流
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            // 读取客户端发送的消息
            User user = (User) ois.readObject();
            // 构建一个message对象准备回复客户端
            Message message = new Message();
            if(checkUser(user.getUserId(),user.getPassword())){
                System.out.println("登录成功");
                // 登录成功后，设置message的状态为SUCCESS
                message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEES);
                oos.writeObject(message);
                //socket.shutdownOutput(); 需要阻塞等待，故不能发送结束标记
                oos.flush();
                ServerThreads serverThreads = new ServerThreads(user.getUserId(),socket);
                //启动对应uid的服务器线程
                serverThreads.start();
                // 把线程放入集合中统一管理
                ManageThreads.addThread(user.getUserId(),serverThreads);

            }else{
                System.out.println("登录失败");
                // 登录失败后，设置message的状态为FAILURE
                message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                oos.writeObject(message);
                socket.shutdownOutput();
                oos.flush();
                oos.close();
                ois.close();
                socket.close();
            }
        }
        serverSocket.close();
    }
}
