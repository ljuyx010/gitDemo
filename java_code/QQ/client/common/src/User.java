import java.io.Serializable;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 17:16
 */
public class User implements Serializable {
    private String userId;
    private String password;

    public User(){}

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
