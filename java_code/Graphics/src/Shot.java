/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/5 15:30
 */
public class Shot implements Runnable {
    private int x;
    private int y;
    private int direction; //子弹射击方向
    private int speed = 10; //子弹移动速度
    private boolean islive = false; //子弹是否存活
    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!(x>=0 && x<=1000 && y>=0 && y<=750)){
                islive = false;
                break;
            }
            //根据方向移动子弹
            if(direction == 0){
                //上
                y -= speed;
            }else if(direction == 1){
                //右
                x += speed;
            }else if(direction == 2){
                //下
                y += speed;
            }else if(direction == 3){
                //左
                x -= speed;
            }

        }
    }
    // 子弹是否存活
    public boolean islive() {
        return islive;
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

    public void setIslive(boolean islive) {
        this.islive = islive;
    }
}
