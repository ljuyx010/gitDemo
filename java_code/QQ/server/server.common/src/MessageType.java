/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/17 10:43
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEES = "1"; //登录成功
    String MESSAGE_LOGIN_FAIL = "2"; //登录失败
    String MESSAGE_ONLINE_FRIEND = "3"; //在线好友列表
    String MESSAGE_COMMON = "4"; //普通信息
    String MESSAGE_EXIT = "5"; //退出
    String MESSAGE_TO_ONE  = "6"; //私聊
    String MESSAGE_TO_ALL = "7"; //群发
    String MESSAGE_FILE = "8"; //发送文件
}
