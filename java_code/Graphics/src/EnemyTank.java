import java.util.Vector;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 09:53
 */
public class EnemyTank extends Tank implements Runnable{
    //构造方法
    public EnemyTank(int x,int y) {
        super(x,y);
        setType(1);
        setDirection(2);
        setSpeed(5);
//        // 开启射击线程
//        this.shotEnemy();
//        // 并把敌人坦克的子弹加入到集合中统一管理
//        shots.add(this.getShot());
        // 开启敌人坦克自动移动线程
        new Thread(this).start();
    }

    @Override
    public void run() {
        // 敌人坦克自动移动
        while (true) {
            // 根据坦克的方向移动
            switch (getDirection()) {
                case 0:
                    for(int i=0;i<30;i++){
                        // 增加敌人坦克移动距离，避免频繁转向
                        moveUp();
                        try {
                            // 休眠50毫秒，模拟敌人坦克移动速度
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i=0;i<20;i++){
                        // 增加敌人坦克移动距离，避免频繁转向
                        moveRight();
                        try {
                            // 休眠50毫秒，模拟敌人坦克移动速度
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++){
                        // 增加敌人坦克移动距离，避免频繁转向
                        moveDown();
                        try {
                            // 休眠50毫秒，模拟敌人坦克移动速度
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<20;i++){
                        // 增加敌人坦克移动距离，避免频繁转向
                        moveLeft();
                        try {
                            // 休眠50毫秒，模拟敌人坦克移动速度
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            // 随机转向
            setDirection((int)(Math.random()*4));
            // 随机射击
            if(Math.random()>0.3){
                shotEnemy();
            }
            if(!isLive()){
                // 坦克死亡后，退出自动移动
                break;
            }
        }
    }
}
