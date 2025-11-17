import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
