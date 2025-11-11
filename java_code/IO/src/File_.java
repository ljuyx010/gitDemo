import java.io.*;
import java.util.Properties;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/10 09:39
 */
public class File_ {
    public static void main(String[] args) {
        /*
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

         */
//        //判断E盘是否有文件夹mytemp，如果没有则创建
//        String path = "E:\\mytemp";
//        File file = new File(path);
//        if(!file.exists()){
//            file.mkdir();
//        }
//        //在e:\\mytemp目录下，不存在则创建hello.txt
//        String fpath = file + "\\hello.txt";
//        File file1 = new File(fpath);
//        if(!file1.exists()){
//            try {
//                file1.createNewFile();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            //在文件中写入hello，world~
//            FileWriter fw = null;
//            try {
//                fw = new FileWriter(file1);
//                fw.write("hello，world~");
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                if(fw!=null){
//                    try {
//                        fw.close();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//
//        }else{
//            System.out.println("文件已经存在");
//        }
//        String path = "E:\\mytemp\\hello.txt";
//        try {
//            //转换流设置字符编码可以处理乱码问题
//            InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"gbk");
//            BufferedReader br = new BufferedReader(isr);
//            String line;
//            int i = 0;
//            while ((line = br.readLine())!=null) {
//                System.out.println((++i) + line);
//            }
//            br.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        //编写一个dog.Properties
        //name=tom
        //age =5
        //color=red
        //编写Dog类（name,age,color）,创建一个dog对象，读取dog.Properties用相应的内容
        //完成属性初始化，并输出
        //将创建的Dog对象，序列化到文件dog.dat文件
        String path = "E:\\mytemp\\";
        String name = "dog.properties";
        Properties pr = new Properties();
        try {
            pr.load(new FileReader(path+name));
            //System.out.println(pr.getProperty("name").getClass());
            String dogname = pr.getProperty("name");
            int age = Integer.parseInt(pr.getProperty("age"));
            String color = pr.getProperty("color");
            Dog dog= new Dog(dogname,age,color);
            System.out.println(dog);
            //ObjectOutputStream 对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + "dog.dat"));
            oos.writeObject(dog); // 写入对象
            oos.close();
            //反序列化
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + "dog.dat"));
            Dog read = (Dog)ois.readObject(); //默认返回Object对象，要向下转型成Dog对象
            System.out.println(read.getName());
            ois.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}

//实现Serializable接口，类就可以进行序列化
 class Dog implements Serializable{
    private String name;
    private int age;
    private String color;

    public Dog() {
    }

    public Dog(String name, int age, String color){
        this.name=name;
        this.age=age;
        this.color=color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
