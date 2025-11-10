import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/10 10:08
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String path = "D:\\WWW\\gitDemo\\java_code\\IO\\src\\File.txt";
        String path2 = "D:\\WWW\\gitDemo\\java_code\\IO\\src\\Filecopy.txt";
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try{
            // 以默认模式创建文件读取流
            fileReader = new FileReader(path);
            // 以追加模式创建文件写入流
            fileWriter = new FileWriter(path2,true);
            // 读取文件内容
            char[] buffer = new char[1024];
            int length;
            // 循环读取文件内容，直到读取到文件末尾
            while((length = fileReader.read(buffer)) != -1){
                try{
                    // 写入读取到的字符数组内容
                    fileWriter.write(buffer,0,length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                try {
                    // 关闭文件读取流
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileWriter != null){
                try {
                    // 关闭文件写入流
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
