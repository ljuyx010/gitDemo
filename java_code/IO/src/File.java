import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/10 09:39
 */
public class File {
    public static void main(String[] args) {
        String path = "D:\\WWW\\gitDemo\\java_code\\IO\\src\\File.txt";
        FileOutputStream fileOutputStream = null;  //定义一个空的文件输出流对象

        try {
            fileOutputStream = new FileOutputStream(path);
            //写入一个字符a
            //fileOutputStream.write('a');
            //写入字符串
            String str = "Hello World";
            //将字符串转换为字节数组并写入文件
            fileOutputStream.write(str.getBytes());
            //从索引0开始写入字符串的所有字节
            fileOutputStream.write(str.getBytes(),0,str.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
