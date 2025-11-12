import java.util.Vector;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 09:53
 */
public class EnemyTank extends Tank implements Runnable{
    private Vector<EnemyTank> EnemyTanks = new Vector<>(); //是否停止移动
    //构造方法
    public EnemyTank(int x,int y) {
        super(x,y);
        setType(1);
        setDirection(2);
        setSpeed(5);
        // 开启敌人坦克自动移动线程
        new Thread(this).start();
    }

    public EnemyTank(int x,int y,int direction) {
        super(x,y);
        setType(1);
        setDirection(direction);
        setSpeed(5);
        // 开启敌人坦克自动移动线程
        new Thread(this).start();
    }

    public void setEnemyTanks(Vector<EnemyTank> peng) {
        this.EnemyTanks = peng;
    }

    // 检查本坦克是否和其他坦克碰撞
    public Boolean isTeach(Vector<EnemyTank> tanks){
        for(Tank t:tanks){
            // 排除和自己比较的情况
            if(t!=this && t.isLive()){
                //当前坦克的移动方向
                switch (this.getDirection()){
                    case 0:// 上
                        // 当前坦克左上角和右上角的坐标[this.getX(),this.getY()]和[this.getX()+40,this.getY()]
                        if(t.getDirection()==0||t.getDirection()==2){
                            // 其他坦克方向是上下 则坦克坐标点[t.getX(),t.getY():t.getX()+40,t.getY()+60]
                            //检测左上角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+40
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                            // 检测右上角
                            if(this.getX()+40>=t.getX()&&this.getX()+40<=t.getX()+40
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                        }else{
                            // 其他坦克方向是左右
                            // 其他坦克方向是左右 则坦克坐标点[t.getX(),t.getY():t.getX()+60,t.getY()+40]
                            //检测左上角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+60
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                            // 检测右上角
                            if(this.getX()+40>=t.getX()&&this.getX()+40<=t.getX()+60
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                        }
                        break;
                    case 1://右
                        // 当前坦克右上角和右下角的坐标[this.getX()+60,this.getY()]和[this.getX()+60,this.getY()+40]
                        if(t.getDirection()==0||t.getDirection()==2){
                            // 其他坦克方向是上下 则坦克坐标点[t.getX(),t.getY():t.getX()+40,t.getY()+60]
                            //检测右上角是的在其他坦克范围内
                            if(this.getX()+60>=t.getX()&&this.getX()+60<=t.getX()+40
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                            // 检测右下角
                            if(this.getX()+60>=t.getX()&&this.getX()+60<=t.getX()+40
                                    &&this.getY()+40>=t.getY()&&this.getY()+40<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                        }else{
                            // 其他坦克方向是左右
                            // 其他坦克方向是左右 则坦克坐标点[t.getX(),t.getY():t.getX()+60,t.getY()+40]
                            //检测右上角
                            if(this.getX()+60>=t.getX()&&this.getX()+60<=t.getX()+60
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                            // 检测右下角
                            if(this.getX()+60>=t.getX()&&this.getX()+60<=t.getX()+60
                                    &&this.getY()+40>=t.getY()&&this.getY()+40<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                        }
                        break;
                    case 2://下
                        // 当前坦克左下角和右下角的坐标[this.getX(),this.getY()+60]和[this.getX()+40,this.getY()+60]
                        if(t.getDirection()==0||t.getDirection()==2){
                            // 其他坦克方向是上下 则坦克坐标点[t.getX(),t.getY():t.getX()+40,t.getY()+60]
                            //检测左下角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+40
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                            // 检测右下角
                            if(this.getX()+40>=t.getX()&&this.getX()+40<=t.getX()+40
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                        }else{
                            // 其他坦克方向是左右
                            // 其他坦克方向是左右 则坦克坐标点[t.getX(),t.getY():t.getX()+60,t.getY()+40]
                            //检测左下角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+60
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                            // 检测右下角
                            if(this.getX()+40>=t.getX()&&this.getX()+40<=t.getX()+60
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                        }
                        break;
                    case 3://左
                        // 当前坦克左上角和左下角的坐标[this.getX(),this.getY()]和[this.getX(),this.getY()+60]
                        if(t.getDirection()==0||t.getDirection()==2){
                            // 其他坦克方向是上下 则坦克坐标点[t.getX(),t.getY():t.getX()+40,t.getY()+60]
                            //检测左上角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+40
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                            // 检测左下角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+40
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+60){
                                // 碰撞
                                return true;
                            }
                        }else{
                            // 其他坦克方向是左右
                            // 其他坦克方向是左右 则坦克坐标点[t.getX(),t.getY():t.getX()+60,t.getY()+40]
                            //检测左上角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+60
                                    &&this.getY()>=t.getY()&&this.getY()<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                            // 检测右上角
                            if(this.getX()>=t.getX()&&this.getX()<=t.getX()+60
                                    &&this.getY()+60>=t.getY()&&this.getY()+60<=t.getY()+40){
                                // 碰撞
                                return true;
                            }
                        }
                        break;
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        // 敌人坦克自动移动
        while (true) {
            // 根据坦克的方向移动
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 30; i++) {
                        // 增加敌人坦克移动距离，避免频繁转向
                        // 如果坦克不停车
                        if (!isTeach(EnemyTanks)) {
                            moveUp();
                        }
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
                        if (!isTeach(EnemyTanks)) {
                            moveRight();
                        }
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
                        if (!isTeach(EnemyTanks)) {
                            moveDown();
                        }
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
                        if (!isTeach(EnemyTanks)) {
                            moveLeft();
                        }
                        try {
                            // 休眠50毫秒，模拟敌人坦克移动速度
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            // 随机转向
            setDirection((int) (Math.random() * 4));
            // 随机射击
            if (Math.random() > 0.3) {
                shotEnemy();
            }
            rmoveShot(); // 从敌人坦克的子弹集合中移除死亡的子弹
            if (!isLive()) {
                // 坦克死亡后，退出自动移动
                break;
            }
        }
    }
}