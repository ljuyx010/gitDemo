import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 14:02
 */
public class DownloadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要下载的文件名");
        String fileName = scanner.nextLine();
        outputStream.write(fileName.getBytes());
        outputStream.flush();
        socket.shutdownOutput();
        String distFileName ;
        if (fileName.equals("高山流水")) {
            distFileName = "d:\\Users\\高山流水.mp3";
        }else{
            distFileName = "d:\\Users\\bomb.gif";
        }
        byte[] bytes = new byte[1024];
        int len = 0;
        FileOutputStream putStream = new FileOutputStream(distFileName);
        while ((len = inputStream.read(bytes)) != -1) {
            putStream.write(bytes, 0, len);
        }
        putStream.flush();
        putStream.close();
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}