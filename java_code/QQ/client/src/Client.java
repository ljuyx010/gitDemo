import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 17:36
 */
public class Client {
    private static boolean loop = true;
    private static boolean sonloop = true;
    private static String username;

    public static void main(String[] args) throws IOException {
        while (loop){
                System.out.println("\n1.登录");
                System.out.println("2.注册");
                System.out.println("9.退出");
                System.out.print("请输入你的选择：");
                char c = Utility.readMenuSelection();
                switch (c) {
                    case '1':
                        if(login()){
                            System.out.println("登录成功");
                            sonMenu();
                        }
                        break;
                    case '2':
                        System.out.println("注册");
                        break;
                    case '9':
                        System.out.println("成功退出系统");
                        loop = false;
                        break;
                    default:
                        System.out.println("输入错误");
                        break;
                }
        }
    }

    public static boolean login() throws IOException {
        System.out.println("\n =====================欢迎登录多用户通信系统=====================");
        System.out.print("请输入用户名：");
        String username = Utility.readString(10,true);
        System.out.print("请输入密码：");
        String password = Utility.readString(10,true);
        Socket socket = new Socket("127.0.0.1", 8888);
        User user = new User(username,password);
        //发送用户信息给服务器
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(user); //发送用户信息给服务器
            //socket.shutdownOutput(); //发送完对象后调用shutdownOutput()，通知对方发送结束，避免阻塞等待,此处需要服务器阻塞等待，
            // 所以不能使用shutdownOutput()
            //接收服务器的响应
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message obj = (Message) ois.readObject();
            if(obj.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEES)){
                System.out.println("----登录成功----");
                Client.username = username;
                ClientThread clientThread = new ClientThread(username,socket);
                //启动socket线程
                clientThread.start();
                //添加线程到集合中
                ManageThreads.addThread(username,clientThread);
                return true;
            }else{
                System.out.println("----登录失败----");
            }
            oos.close();
            ois.close();
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
    //私聊
    public static void sendToOne() throws IOException {
        System.out.print("请输入要私聊的用户名：");
        String getter = Utility.readString(10,true);
        System.out.print("请输入要发送的消息：");
        String message = Utility.readString(100,true);
        new ClientMessage(Client.username).sendMessage(MessageType.MESSAGE_TO_ONE,message,getter);
    }
    //群聊
    public static void sendToAll() throws IOException {
        System.out.print("请输入要发送的消息：");
        String message = Utility.readString(100,true);
        new ClientMessage(Client.username).sendMessage(MessageType.MESSAGE_TO_ALL,message,"");
    }

    // 发送文件
    public static void sendFile() throws IOException {
        System.out.print("请输入要发送文件的用户名：");
        String getter = Utility.readString(10,true);
        System.out.print("请输入要发送的文件路径（如D:\\Download\\1.jpg）：");
        String src = Utility.readString(100,true);;
        // 判断文件路径是否正确
        File file = new File(src);
        while(!file.exists()){
            System.out.print("文件不存在，请重新输入要发送的文件路径（如D:\\Download\\1.jpg）：");
            src = Utility.readString(100,true);
        }
        System.out.print("请输入文件保存路径：");
        String dst = Utility.readString(100,true);
        new ClientMessage(Client.username).sendMessage(MessageType.MESSAGE_FILE,getter,src,dst);
    }

    public static void sonMenu() throws IOException {
        while (Client.sonloop){
            System.out.println("\n =====================网络通信系统二级菜单（用户"+ Client.username +"）=====================");
            System.out.println("1.在线用户列表");
            System.out.println("2.发送消息给用户");
            System.out.println("3.发送消息到群聊");
            System.out.println("4.发送文件");
            System.out.println("9.退出系统");
            System.out.print("请输入你的选择：");
            char c1 = Utility.readMenuSelection();
            ClientMessage clientMessage = new ClientMessage(Client.username);
            switch (c1) {
                case '1':
                    clientMessage.getOnlineFriend();
                    break;
                case '2':
                    Client.sendToOne();
                    break;
                case '3':
                    Client.sendToAll();
                    break;
                case '4':
                    Client.sendFile();
                    break;
                case '9':
                    Client.loop = false;
                    Client.sonloop = false;
                    clientMessage.exit();
                    System.exit(0); // 退出jvm虚拟机，则所有关联的线程都将退出
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
    }
}
