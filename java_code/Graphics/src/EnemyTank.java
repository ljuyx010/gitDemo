import java.util.Vector;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 09:53
 */
public class EnemyTank extends Tank implements Runnable{
    private boolean peng = false; //是否停止移动
    //构造方法
    public EnemyTank(int x,int y) {
        super(x,y);
        setType(1);
        setDirection(2);
        setSpeed(5);
        // 开启敌人坦克自动移动线程
        new Thread(this).start();
    }


    // 检查是否有其他坦克
    public void haveOtherTank(Vector<EnemyTank> tanks){
        for(Tank t:tanks){
            if(t!=this && t.isLive()){
                if((this.getDirection() == 0 || this.getDirection() == 2) && (t.getDirection() == 0 || t.getDirection() == 2)) {
                    // 本坦克和其他坦克都是上下移动，检测是否碰撞
                    if (t.getX() <= this.getX()+40 && t.getX() >= this.getX()-40 && t.getY() <= this.getY() +60 && t.getY() >= this.getY()-60 ) {
                        // 本坦克位置和其他坦克位置碰撞，则返回true
                        peng = true;
                    }
                }else if((this.getDirection() == 1 || this.getDirection() == 3) && (t.getDirection() == 1 || t.getDirection() == 3)) {
                    // 玩家坦克和敌人坦克都是左右移动，检测是否碰撞
                    if (t.getX() >= this.getX()-60 && t.getX() <= this.getX() + 60 && t.getY() >= this.getY()-40 && t.getY() <= this.getY() + 40) {
                        // 本坦克位置和其他坦克位置碰撞，则返回true
                        peng = true;
                    }
                }else if((this.getDirection() == 1 || this.getDirection() == 3) && (t.getDirection() == 0 || t.getDirection() == 2)){
                    // 玩家坦克左右和敌人坦克上下移动，检测是否碰撞
                    if (t.getX() >= this.getX()-60 && t.getX() <= this.getX() + 100 && t.getY() >= this.getY()-40 && t.getY() <= this.getY() + 100) {
                        // 本坦克位置和其他坦克位置碰撞，则返回true
                        peng = true;
                    }
                }else{
                    // 玩家坦克上下和敌人坦克左右移动，检测是否碰撞
                    if (t.getX() >= this.getX()-40 && t.getX() <= this.getX() + 100 && t.getY() >= this.getY()-60 && t.getY() <= this.getY() + 100) {
                        // 本坦克位置和其他坦克位置碰撞，则返回true
                        peng = true;
                    }
                }
            }
        }
        peng = false; // 重置碰撞状态

    }

    @Override
    public void run() {
        // 敌人坦克自动移动
        while (true) {
            // 如果坦克不停车
            if(!peng) {
                // 根据坦克的方向移动
                switch (getDirection()) {
                    case 0:
                        for (int i = 0; i < 30; i++) {
                            // 增加敌人坦克移动距离，避免频繁转向
                            moveUp();
                            try {
                                // 休眠50毫秒，模拟敌人坦克移动速度
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 20; i++) {
                            // 增加敌人坦克移动距离，避免频繁转向
                            moveRight();
                            try {
                                // 休眠50毫秒，模拟敌人坦克移动速度
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 30; i++) {
                            // 增加敌人坦克移动距离，避免频繁转向
                            moveDown();
                            try {
                                // 休眠50毫秒，模拟敌人坦克移动速度
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 20; i++) {
                            // 增加敌人坦克移动距离，避免频繁转向
                            moveLeft();
                            try {
                                // 休眠50毫秒，模拟敌人坦克移动速度
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                }
            }
            // 随机转向
            setDirection((int)(Math.random()*4));
            // 随机射击
            if(Math.random()>0.3){
                shotEnemy();
            }
            rmoveShot(); // 从敌人坦克的子弹集合中移除死亡的子弹
            if(!isLive()){
                // 坦克死亡后，退出自动移动
                break;
            }

        }
    }
}
