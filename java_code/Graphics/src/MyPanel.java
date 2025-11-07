/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/3 11:37
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

//坦克大战的绘图区域
public class MyPanel extends JPanel implements KeyListener,Runnable {
    private boolean isRunning = true;
    //定义玩家坦克
    Hero myHero=null;
    //定义敌人坦克放入到vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义敌人坦克的数量
    int enemyTankSize = 3;
    // 定义爆炸效果图片数组
    Image[] bombImg = new Image[3];
    //定义爆炸效果放入到vector
    Vector<Bomb> bombs = new Vector<>();
    //构造方法
    public MyPanel(){
        //初始化玩家坦克
        myHero=new Hero(100,600);
        myHero.setSpeed(5);
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            enemyTanks.add(new EnemyTank(200+i*100,10));
        }
        // 初始化爆炸效果图片资源
        //加载爆炸效果图片
        bombImg[0] = Toolkit.getDefaultToolkit().getImage("D:\\WWW\\gitDemo\\java_code\\Graphics\\src\\b1.png");
        bombImg[1] = Toolkit.getDefaultToolkit().getImage("D:\\WWW\\gitDemo\\java_code\\Graphics\\src\\b2.png");
        bombImg[2] = Toolkit.getDefaultToolkit().getImage("D:\\WWW\\gitDemo\\java_code\\Graphics\\src\\b3.png");
        //解决第一次不显示图片的问题
        MediaTracker t = new MediaTracker(this);
        t.addImage(bombImg[0], 0);
        t.addImage(bombImg[1], 0);
        t.addImage(bombImg[2], 0);
        try {
            t.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
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
        drawTank(myHero,g);
//        循环绘制敌人坦克
        for (EnemyTank enemyTank : enemyTanks) {
            drawTank(enemyTank,g);
//            循环绘制敌人坦克的子弹
            for (Shot shot : enemyTank.shots) {
                drawShot(shot,g);
            }
        }
        //画出玩家子弹
        if(myHero.getShot() != null){
            for (Shot shot : myHero.getShot()) {
                drawShot(shot,g);
            }
        }
        //画出爆炸效果
        drawBomb(g);
    }

    //画出坦克
    //x,y 坦克的坐标
    //direction 坦克的方向  0 上  1 右  2 下  3 左
    //type 坦克的类型  0 普通坦克  1 敌人坦克
    public void drawTank(Tank tank,Graphics g){
        int x=tank.getX();
        int y=tank.getY();
        int direction=tank.getDirection();
        int type=tank.getType();
        boolean live=tank.isLive();
        //如果坦克死亡，不绘制
        if(!live){
            return;
        }
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
    }

    // 画子弹
    public void drawShot(Shot shot,Graphics g){
        g.setColor(Color.white); //设置子弹颜色为白色
        // 自动对象不为空，且子弹存活时，绘制子弹
        if(shot!=null && shot.islive()){
//            根据方向绘制不同的子弹
           if(shot.getDirection() == 0 || shot.getDirection() == 2){
               g.draw3DRect(shot.getX(), shot.getY(), 2, 5,false);
           }else{
               g.draw3DRect(shot.getX(), shot.getY(), 5, 2,false);
           }
        }
    }

    // 画爆炸效果
    public void drawBomb(Graphics g){
        for(int i=0;i<bombs.size();i++){
            Bomb bomb = bombs.get(i);
            if(bomb.getLife()>6) {
                g.drawImage(bombImg[0], bomb.getX(), bomb.getY(), 60, 60, this);
            }else if(bomb.getLife()>3){
                g.drawImage(bombImg[1], bomb.getX(), bomb.getY(), 60, 60,this);
            }else{
                g.drawImage(bombImg[2], bomb.getX(), bomb.getY(), 60, 60,this);
            }
            // 触发爆炸效果
            bomb.boom();
            // 如果爆炸效果死亡，从集合中移除
            if(!bomb.islive()){
                bombs.remove(bomb);
            }
        }
    }

    // 碰撞检测
    public boolean isCollide(Tank tank1,Vector<EnemyTank> tanks){
        // 遍历敌人坦克
        for (EnemyTank enemyTank : enemyTanks) {
            int enemyX = enemyTank.getX();
            int enemyY = enemyTank.getY();
            // 检测玩家坦克和敌人坦克是否碰撞
            if (!tank1.equals(enemyTank) && enemyTank.isLive() && tank1.isLive()) {
                if ((tank1.getDirection() == 0 || tank1.getDirection() == 2) && (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2)) {
                    // 玩家坦克和敌人坦克都是上下移动，检测是否碰撞
                    if (enemyTank.getX() > tank1.getX() - 40 && enemyTank.getX() < tank1.getX() + 40 && enemyTank.getY() > tank1.getY() - 60 && enemyTank.getY() < tank1.getY() + 60) {
                        return true;
                    }
                } else if ((tank1.getDirection() == 1 || tank1.getDirection() == 3) && (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3)) {
                    // 玩家坦克和敌人坦克都是左右移动，检测是否碰撞
                    if (enemyTank.getX() > tank1.getX() - 60 && enemyTank.getX() < tank1.getX() + 60 && enemyTank.getY() > tank1.getY() -40  && enemyTank.getY() < tank1.getY() + 40) {
                        return true;
                    }
                } else if ((tank1.getDirection() == 1 || tank1.getDirection() == 3) && (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2)) {
                    // 玩家坦克左右和敌人坦克上下移动，检测是否碰撞
                    if (enemyTank.getX() > tank1.getX() -60 && enemyTank.getX() < tank1.getX() + 100 && enemyTank.getY() > tank1.getY()- 40 && enemyTank.getY() < tank1.getY() + 100) {
                        return true;
                    }
                } else {
                    // 玩家坦克上下和敌人坦克左右移动，检测是否碰撞
                    if (enemyTank.getX() > tank1.getX() - 40 && enemyTank.getX() < tank1.getX() + 100 && enemyTank.getY() > tank1.getY() - 60 && enemyTank.getY() < tank1.getY() + 100) {
                        return true;
                    }
                }
            }
        }
        return false;
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
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            //System.out.println("0键被按下");
            myHero.shotEnemy();
        }
//        this.repaint(); //重绘图形  ,可以注销，已经在线程中每隔50毫秒重绘一次
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void run() {
        // 每隔100毫秒重绘一次显示子弹轨迹
        while(true){
            if (!isRunning) {
                //玩家坦克死亡游戏结束
                //break;
            }
            // 玩家坦克和敌人坦克碰撞检测
            if(isCollide(myHero,enemyTanks)){
                myHero.setLive(false); // 玩家坦克死亡
                bombs.add(new Bomb(myHero.getX(), myHero.getY())); // 玩家坦克死亡后，在其位置添加一个爆炸效果
                isRunning = false; // 游戏结束
            }
            // 并检测是否有玩家坦克的子弹集合击中敌人坦克
            if(myHero.getShot() != null) {
                // 遍历玩家所有的子弹
                for (Shot sh : myHero.getShot()) {
                    int heroShotX = sh.getX();
                    int heroShotY = sh.getY();
                    Iterator<EnemyTank> iterator = enemyTanks.iterator();
                    //遍历敌人坦克
                    while (iterator.hasNext()) {
                        EnemyTank enemyTank = iterator.next();
                        int enemyX = enemyTank.getX();
                        int enemyY = enemyTank.getY();
                        int enemyDirection = enemyTank.getDirection();
                        switch (enemyDirection) {
                            case 0: //敌人坦克向上
                            case 2: //敌人坦克向下
                                if (heroShotX >= enemyX && heroShotX <= enemyX + 40 && heroShotY >= enemyY && heroShotY <= enemyY + 60 && sh.islive()) {
                                    // 玩家坦克的子弹击中敌人坦克，并且子弹是存活状态，避免一个子弹击中多个敌人坦克
                                    enemyTank.setLive(false); // 敌人坦克死亡
                                    iterator.remove(); // 从敌人坦克集合中移除死亡的敌人坦克
                                    sh.setIslive(false); // 玩家坦克的子弹死亡
                                    bombs.add(new Bomb(enemyX, enemyY)); // 敌人坦克死亡后，在其位置添加一个爆炸效果
                                }
                                break;
                            case 1: //敌人坦克向右
                            case 3: //敌人坦克向左
                                if (heroShotX >= enemyX && heroShotX <= enemyX + 60 && heroShotY >= enemyY && heroShotY <= enemyY + 40 && sh.islive()) {
                                    // 玩家坦克的子弹击中敌人坦克
                                    enemyTank.setLive(false);
                                    //enemyTanks.remove(enemyTank); //使用for循环遍历Vector时，不能直接remove，会导致ConcurrentModificationException异常
                                    iterator.remove(); // 使用迭代器的remove方法安全移除元素
                                    sh.setIslive(false);
                                    bombs.add(new Bomb(enemyX, enemyY)); // 敌人坦克死亡后，在其位置添加一个爆炸效果
                                }
                                break;
                        }
                    }
                }
            }
            myHero.rmoveShot(); // 从玩家坦克的子弹集合中移除死亡的子弹
            //遍历敌人坦克
            for (EnemyTank enemyTank : enemyTanks) {
                // 敌人坦克和其他坦克碰撞检测
//                boolean peng = isCollide(enemyTank,enemyTanks);
//                // 不能直接在enemyTanks上修改属性，因为在循环中修改集合，会导致ConcurrentModificationException异常
//                enemyTanks.get(enemyTanks.indexOf(enemyTank)).setPeng(peng); // 本坦克停止移动
                enemyTank.haveOtherTank(enemyTanks);
                //遍历敌人坦克的子弹
                Iterator<Shot> shotIterator = enemyTank.shots.iterator();
                while (shotIterator.hasNext()) {
                    Shot shot = shotIterator.next();
                    int shXto = shot.getX();
                    int shYto = shot.getY();
                    boolean shotIslive = shot.islive();

                    if ((myHero.getDirection() == 0 || myHero.getDirection() == 2) && shXto >= myHero.getX() && shXto <= myHero.getX() + 40 && shYto >= myHero.getY() && shYto <= myHero.getY() + 60 && shotIslive) {
                        // 敌人坦克的子弹击中玩家坦克
                        myHero.setLive(false); // 玩家坦克死亡
                        bombs.add(new Bomb(myHero.getX(), myHero.getY())); // 敌人坦克的子弹击中玩家坦克后，在其位置添加一个爆炸效果
                        isRunning = false; // 游戏结束
                    } else if ((myHero.getDirection() == 1 || myHero.getDirection() == 3) && shXto >= myHero.getX() && shXto <= myHero.getX() + 60 && shYto >= myHero.getY() && shYto <= myHero.getY() + 40 && shotIslive) {
                        // 敌人坦克的子弹击中玩家坦克
                        myHero.setLive(false); // 玩家坦克死亡
                        bombs.add(new Bomb(myHero.getX(), myHero.getY())); // 敌人坦克的子弹击中玩家坦克后，在其位置添加一个爆炸效果
                        isRunning = false; // 游戏结束
                    }
                }

            }


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重绘整个面板
            this.repaint();
        }
    }
}
