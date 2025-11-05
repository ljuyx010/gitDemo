/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/3 16:48
 */
// 玩家的坦克继承坦克类
public class Hero extends Tank {
    Shot shot=null;
    public Hero(int x, int y) {
        super(x, y);
    }

    //坦克射击方法
    public void shotEnemy(){
        switch (getDirection()){
            case 0:
                shot = new Shot(getX()+20,getY(),getDirection());
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+20,getDirection());
                break;
            case 2:
                shot = new Shot(getX()+20,getY()+60,getDirection());
                break;
            case 3:
                shot = new Shot(getX(),getY()+20,getDirection());
                break;
        }
        if(shot!=null){
            shot.setIslive(true);
        }
        //启动子弹发射的线程
        new Thread(shot).start();
    }
    //向上移动
    public void moveUp() {
        if (this.getY() - this.getSpeed() > 0) {
            this.setY(this.getY() - this.getSpeed());
        }
    }

    //向下移动
    public void moveDown() {
        if (this.getY() + this.getSpeed() < 650) {
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
        if (this.getX() + this.getSpeed() < 920) {
            this.setX(this.getX() + this.getSpeed());
        }
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
}
