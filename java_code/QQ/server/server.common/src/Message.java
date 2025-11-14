import java.io.Serializable;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 17:20
 */
public class Message implements Serializable {
    public final String SUCCESS = "1"; // 用户登录成功
    public final String FAILURE = "2"; // 用户登录失败
    private String sender;
    private String getter;
    private String message;
    private String sendtime;

    public Message(String sender, String getter, String message, String sendtime) {
        this.sender = sender;
        this.getter = getter;
        this.message = message;
        this.sendtime = sendtime;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
