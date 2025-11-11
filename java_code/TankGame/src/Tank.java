import java.util.Vector;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/28 14:47
 */
public class Tank {
    Vector<Shot> shots=new Vector<>(); // 坦克的子弹集合
    private Shot sh=null; // 默认子弹对象为null
    private int x; // 坦克的横坐标
    private int y; // 坦克的纵坐标
    private int direction=0; // 坦克的方向  0 上  1 右  2 下  3 左
    private int type=0; // 坦克的类型  0 普通坦克  1 敌人坦克
    private int speed=1; //坦克的移动速度
    private boolean live=true; //坦克是否存活
    private int health=100; //坦克的生命值

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //构造方法
    public Tank(int x,int y){
        this.x=x;
        this.y=y;
    }

    //坦克射击方法
    public void shotEnemy(){
        if(shots.size() == 5){
            // 子弹数量达到5个，不能再射击
            return;
        }
        switch (getDirection()){
            case 0:
                sh = new Shot(getX()+20,getY(),getDirection());
                break;
            case 1:
                sh = new Shot(getX()+60,getY()+20,getDirection());
                break;
            case 2:
                sh = new Shot(getX()+20,getY()+60,getDirection());
                break;
            case 3:
                sh = new Shot(getX(),getY()+20,getDirection());
                break;
        }
        if(sh!=null){
            sh.setIslive(true);
            shots.add(sh);
        }
        //启动子弹发射的线程
        new Thread(sh).start();
    }

    public void rmoveShot(){
        for(int i=0;i<shots.size();i++){
            if(shots.get(i)!=null){
                if (!shots.get(i).islive()){
                    shots.remove(i);
                }
            }
        }
//        Iterator<Shot> iterator = shots.iterator();
//        while(iterator.hasNext()){
//            Shot temp=iterator.next();
//            if(!temp.islive()){
//                iterator.remove();
//            }
//        }
//        for(Shot s:shots){
//            if(!s.islive()){
//                shots.remove(s);//使用for循环遍历Vector时，不能直接remove，会导致ConcurrentModificationException异常
//            }
//        }
    }

    //向上移动
    public void moveUp() {
        if (this.getY() - this.getSpeed() > 0) {
            this.setY(this.getY() - this.getSpeed());
        }
    }

    //向下移动
    public void moveDown() {
        if (this.getY() + 60 + this.getSpeed() < 750) {
            this.setY(this.getY() + this.getSpeed());
        }
    }

    //向左移动
    public void moveLeft() {
        if (this.getX() - this.getSpeed() > 0) {
            this.setX(this.getX() - this.getSpeed());
        }
    }

    //向右移动
    public void moveRight() {
        if (this.getX() + 60 + this.getSpeed() < 1000) {
            this.setX(this.getX() + this.getSpeed());
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getType() {
        return type;
    }

    public Vector<Shot> getShot() {
        return shots;
    }
    public void setLive(boolean live) {
        this.live = live;
    }
    public boolean isLive() {
        return live;
    }
    public void setType(int type) {
        this.type = type;
    }

}