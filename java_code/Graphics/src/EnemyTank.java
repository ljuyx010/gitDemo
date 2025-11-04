/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 09:53
 */
public class EnemyTank extends Tank{
    //构造方法
    public EnemyTank(int x,int y) {
        super(x,y);
        setType(1);
        setDirection(2);
    }
}
