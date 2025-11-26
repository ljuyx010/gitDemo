import java.io.Serializable;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/14 17:20
 */
public class Message implements Serializable {
    private static final long serialVersionUID = 1L; // 为了类在tcp中传输的兼容性
    private String sender; // 发送这
    private String getter; //接受者
    private String message; // 消息内容
    private String sendtime; // 发送时间
    private String mesType;  // 消息类型
    private String src; // 文件源
    private String dest; //文件保存路径
    private byte[] fileDate; //文件二进制数据

    public Message() {
    }

    public Message(String sender, String getter, String message, String sendtime) {
        this.sender = sender;
        this.getter = getter;
        this.message = message;
        this.sendtime = sendtime;
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setFileDate(byte[] fileDate) {
        this.fileDate = fileDate;
    }

    public byte[] getFileDate() {
        return fileDate;
    }

    public String getSrc() {
        return src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
