import java.util.HashMap;

/*
 * 线程管理类
 */
public class ManageThreads {
    private static HashMap<String,ClientThread> map = new HashMap<>();

     //添加线程
    public static void addThread(String username,ClientThread clientThread){
        map.put(username,clientThread);
    }
     //获取线程
    public static ClientThread getThread(String username){
        return map.get(username);
    }
}
