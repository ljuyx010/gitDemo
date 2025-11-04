/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/3 16:48
 */
// 玩家的坦克继承坦克类
public class Hero extends Tank {
    public Hero(int x, int y) {
        super(x, y);
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
}
