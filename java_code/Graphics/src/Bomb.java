/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/6 11:46
 */
//爆炸效果类
public class Bomb {
    //定义爆炸的坐标
    int x;
    int y;
    //定义爆炸的时间
    int life=9;
    //定义爆炸效果存活
    boolean islive=true;
    //构造方法
    public Bomb(int x,int y){
        this.x=x;
        this.y=y;
    }
    //获取爆炸的坐标
    public int getX(){
        return x;
    }
    //获取爆炸的坐标
    public int getY(){
        return y;
    }

    public boolean islive(){
        return islive;
    }

    public void setIslive(boolean islive){
        this.islive=islive;
    }

    public int getLife(){
        return life;
    }

    //触发爆炸效果
    public void boom(){
        life--;
        if(life<=0){
            islive=false;
        }
    }
}
