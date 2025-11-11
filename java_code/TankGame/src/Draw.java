import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/27 15:53
 */
public class Draw extends JFrame {
    //JFrame对象就是一个窗口
    //panel对象就是窗口内的画板
    //Graphics类  画笔 提供了很多的方法可以再画板上绘制图形
    public Draw(){
        MyPanel mp = new MyPanel();
        //初始化窗口并把画板添加到窗口中
        this.add(mp);
        //设置窗口的标题
        this.setTitle("坦克大战");
        //设置窗口的大小
        this.setSize(1250,790);
        //添加键盘监听事件
        this.addKeyListener(mp);
        // 设置点击窗口关闭按钮时的操作  退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口可见
        this.setVisible(true);
        //开启线程
        new Thread(mp).start();
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // 关闭窗口时，保存记录
                Record.keepRecord();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }


    public static void main(String[] args) {
        new Draw();
    }


}
