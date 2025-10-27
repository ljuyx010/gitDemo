import javax.swing.*;
import java.awt.*;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/27 15:53
 */
public class Draw extends JFrame{
    //JFrame对象就是一个窗口
    //panel对象就是窗口内的画板
    //Graphics类  画笔 提供了很多的方法可以再画板上绘制图形
    public Draw(){
        //初始化窗口并把画板添加到窗口中
        this.add(new Myanel());
        //设置窗口的标题
        this.setTitle("绘制一个圆形");
        //设置窗口的大小
        this.setSize(500,500);
//        设置点击窗口关闭按钮时的操作  退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口可见
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Draw();
    }
}
// 首先创建一个面板
class Myanel extends JPanel {
    //myPanel对象就是一个画板
    //Graphics g  Graphics类  画笔 提供了很多绘图的方法
    public void paint(Graphics g){
        super.paint(g); //调用父类的方法完成初始化
        // 绘制一个圆形
        g.drawOval(10,10,100,100);
        //圆形的外框矩形的右上角坐标(10,10)  矩形的宽度100  高度100 就是一个圆形
    }
}

