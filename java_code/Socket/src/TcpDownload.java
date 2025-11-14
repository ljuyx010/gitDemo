import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 09:05
 * Tcp 服务端
 */
public class TcpDownload {
    public static void main(String[] args) throws IOException {
       ServerSocket serverSocket = new ServerSocket(8888);
       Socket socket = serverSocket.accept();
       FileInputStream br= null;
       BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       String line = reader.readLine();
       String srcPath;
       if(line.equals("高山流水")){
           srcPath="TankGame\\src\\bg.mp3";
       }else{
           srcPath="TankGame\\src\\bomb.gif";
       }
        try {
            br = new FileInputStream(srcPath);
            // 从文件中读取数据
            byte[] bytes = new byte[1024];
            int len;
            while((len=br.read(bytes))!=-1){
                socket.getOutputStream().write(bytes,0,len);
            }
            socket.getOutputStream().flush();
            socket.shutdownOutput();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            reader.close();
            socket.getOutputStream().close();
            socket.close();
            serverSocket.close();
        }
    }
}
