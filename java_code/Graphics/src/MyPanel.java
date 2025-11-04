/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/3 11:37
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//坦克大战的绘图区域
public class MyPanel extends JPanel implements KeyListener {
    //定义玩家坦克
    Hero myHero=null;
    //定义敌人坦克放入到vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义敌人坦克的数量
    int enemyTankSize = 3;
    public MyPanel(){
        //初始化玩家坦克
        myHero=new Hero(100,600);
        myHero.setSpeed(2);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(200+i*100,10));
        }
    }
    //myPanel对象就是一个画板
    //Graphics g  Graphics类  画笔 提供了很多绘图的方法
    public void paint(Graphics g){
        //调用父类的方法完成初始化
        super.paint(g);
        //填充背景为黑色
        g.setColor(Color.black);
        //填充的矩形范围
        g.fillRect(0,0,1000,750);
        //画出玩家坦克
        drawTank(myHero.getX(),myHero.getY(),g,myHero.getDirection(),myHero.getType());
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirection(),enemyTank.getType());
        }
    }

    //画出坦克
    //x,y 坦克的坐标
    //direction 坦克的方向  0 上  1 右  2 下  3 左
    //type 坦克的类型  0 普通坦克  1 敌人坦克
    public void drawTank(int x,int y,Graphics g,int direction,int type){
        //根据不同坦克，设置不同颜色
        if(type == 0){
            g.setColor(Color.green);
        }else if(type == 1){
            g.setColor(Color.red);
        }
        //根据方向绘制不同的坦克
        if(direction == 0){
            //上
            g.fill3DRect(x,y,10,60,false);//左履带
            g.fill3DRect(x+10,y+10,20,40,false);//坦克主体
            g.fillOval(x+10,y+15,20,20); //炮塔
            g.drawLine(x+20,y,x+20,y+25);//炮筒
            g.fill3DRect(x+30,y,10,60,false);//右履带
        }else if(direction == 1){
            //右
            g.fill3DRect(x,y,60,10,false);//左履带
            g.fill3DRect(x+10,y+10,40,20,false);//坦克主体
            g.fillOval(x+25,y+10,20,20); //炮塔
            g.drawLine(x+35,y+20,x+60,y+20);//炮筒
            g.fill3DRect(x,y+30,60,10,false);//右履带
        }else if(direction == 3){
            //左
            g.fill3DRect(x,y,60,10,false);//左履带
            g.fill3DRect(x+10,y+10,40,20,false);//坦克主体
            g.fillOval(x+15,y+10,20,20); //炮塔
            g.drawLine(x,y+20,x+25,y+20);//炮筒
            g.fill3DRect(x,y+30,60,10,false);//右履带
        }else if(direction == 2){
            //下
            g.fill3DRect(x,y,10,60,false);//左履带
            g.fill3DRect(x+10,y+10,20,40,false);//坦克主体
            g.fillOval(x+10,y+25,20,20); //炮塔
            g.drawLine(x+20,y+35,x+20,y+60);//炮筒
            g.fill3DRect(x+30,y,10,60,false);//右履带
        }
        //根据方向绘制不同的坦克
        //g.fillRect(100,100,50,50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            //System.out.println("向下箭头键被按下");
            myHero.setDirection(2);
            myHero.moveDown();
        }else if(e.getKeyCode()== KeyEvent.VK_UP){
            //System.out.println("向上箭头键被按下");
            myHero.setDirection(0);
            myHero.moveUp();
        }else if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            //System.out.println("向右箭头键被按下");
            myHero.setDirection(1);
            myHero.moveRight();
        }else if(e.getKeyCode()== KeyEvent.VK_LEFT){
            //System.out.println("向左箭头键被按下");
            myHero.setDirection(3);
            myHero.moveLeft();
        }
        this.repaint(); //重绘图形
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
