import java.util.HashMap;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/17 14:22
 */
public class ManageThreads {
    private static HashMap<String,ServerThreads> map = new HashMap<>();

    public static void addThread(String username,ServerThreads serverThreads){
        map.put(username,serverThreads);
    }

    public static ServerThreads getMapSocket(String username) {
        return map.get(username);
    }
}
