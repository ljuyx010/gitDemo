import java.io.*;
import java.util.Vector;

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
    private static BufferedReader br=null;
    private static Vector<EnemyTank> enemyTanks = new Vector<>();

    public static int getEnemyTankCount() {
        return EnemyTankCount;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Record.enemyTanks = enemyTanks;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
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
    // 保存敌人存活坦克数量和坦克坐标、方向
    public static void keepRecord(){
        try {
            bw=new BufferedWriter(new FileWriter(recordFile));
            bw.write(EnemyTankCount+"");// 写入敌人坦克数量,需要转换为字符串
            bw.newLine();
            for (EnemyTank enemyTank : enemyTanks) {
                bw.write(enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(bw!=null){bw.close();}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 读取记录文件恢复敌人存活坦克数量和坦克坐标、方向
    public static boolean readRecord(){
        File file = new File(recordFile);
        // 需要处理文件不存在的情况
        if(!file.exists()){
            System.out.println("记录文件不存在");
            return false;
        }
        // 需要处理文件为空的情况
        if(file.length()==0){
            System.out.println("记录文件为空");
            return false;
        }
        try {
            br=new BufferedReader(new FileReader(recordFile));
            String line;
            int i=0;

            while((line=br.readLine())!=null){
                if(i==0){
                    EnemyTankCount=Integer.parseInt(line);// 读取敌人坦克数量
                }else {
                    String[] strs = line.split(" ");
                    enemyTanks.add(new EnemyTank(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), Integer.parseInt(strs[2])));
                }
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(br!=null){br.close();}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

}
