import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/11 16:47
 */
public class Record {
    private static int EnemyTankCount = 0;
    private static int MyTankCount = 0;
    private static String recordFile = "D:\\WWW\\gitDemo\\java_code\\TankGame\\src\\record.txt";
    private static BufferedWriter bw=null;

    public static int getEnemyTankCount() {
        return EnemyTankCount;
    }

    public static void setEnemyTankCount(int enemyTankCount) {
        EnemyTankCount = enemyTankCount;
    }

    public static int getMyTankCount() {
        return MyTankCount;
    }

    public static void setMyTankCount(int myTankCount) {
        MyTankCount = myTankCount;
    }

    public static void addEnemyTankCount(){
        EnemyTankCount++;
    }

    public static void keepRecord(){
        try {
            bw=new BufferedWriter(new FileWriter(recordFile));
            bw.write(EnemyTankCount+"");// 写入敌人坦克数量,需要转换为字符串
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
