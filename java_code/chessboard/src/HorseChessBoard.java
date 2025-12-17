import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/17 14:35
 */
public class HorseChessBoard {
    // 骑士周游问题
    private static int x=6; //表示棋盘的列数
    private static int y=6; //表示棋盘的行数
    private static int[][] chessBoard = new int[y][x]; //表示棋盘
    private static boolean[] visited = new boolean[x*y]; //表示棋盘的每个位置是否被访问过
    private static boolean finished = false; //表示是否完成了骑士周游问题
    public static void main(String[] args) {
        // 测试骑士周游问题
        long startTime = System.currentTimeMillis();
        traverseChessBoard(chessBoard,new Point(4,4),1);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime-startTime)+"毫秒");

        //输出当前这个棋盘的情况
        for(int[] rows:chessBoard){
            for(int step:rows){ // step表示当前这个位置的步数
                System.out.print(step+"  ");
            }
            System.out.println();
        }
    }

    // 编写核心的算法，遍历棋盘，如果遍历成功，就把finished设为true。
    // 并且，将马儿走的每一步，都记录到chessBoard中。
    public static void traverseChessBoard(int[][] chessBoard,Point point,int step) {
        // 先将当前这个位置的步数，记录到chessBoard中
        chessBoard[point.y][point.x] = step;
        // 标记当前这个位置为已访问，(point.y * x + point.x)表示每行每行往下数的第几个点位
        visited[point.y * x + point.x] = true;
        // 获取当前位置，可以走的下一步的所有位置
        ArrayList<Point> points = nextPoint(point);
        // 优化：排序下一步走的位置
        sortPoints(points);
        // 遍历当前位置，可以走的下一步的所有位置
        while (!points.isEmpty()) {
            // 取出下一步点位中的第一个位置，并删除，直到下一个点位删除完就是都走了一遍
            Point p = points.remove(0);
            // 判断当前这个位置是否已经走过，如果没有走过就递归遍历,如果已经走过，就跳过
            if (!visited[p.y * x + p.x]) {
                // 如果没有被访问过，就递归调用traverseChessBoard方法
                traverseChessBoard(chessBoard, p, step + 1);
            }
        }
        // 当退出while，看看是否已经完成了骑士周游问题，如果灭有成功，就重置并回溯
        if(step<x*y && !finished){ //如果step<x*y-1，说明还没有完成骑士周游问题
            chessBoard[point.y][point.x] = 0; //将当前这个位置的步数，设置为0
            visited[point.y * x + point.x] = false; //将当前这个位置标记为未访问
        }else{ //如果step==x*y-1，说明已经完成了骑士周游问题
            finished = true; //将finished设为true
        }
    }

    // 贪心算法优化：写一个方法，对nextPoint方法返回的所有点位，进行排序，
    // 排序的规则是：对每一个点位，计算出它可以走的下一步的所有位置的数量，
    // 然后，按照这个数量，从少到多进行排序。
    public static void sortPoints(ArrayList<Point> points){
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return nextPoint(o1).size()-nextPoint(o2).size();
            }
        });
    }

    // 编写方法，可以获取当前位置，可以走的下一步的所有位置（point表示X，y）
    public static ArrayList<Point> nextPoint(Point point){
        // 创建一个ArrayList，用来存储马儿可以走的下一步的所有位置
        ArrayList<Point> points = new ArrayList<>();
        // 创建一个point对象，用来表示马儿可以走的下一步的位置
        Point p1 = new Point();
        //判断八个位置是否可以满足下个位置可走的要求,并且这个点位没有走过
        if( point.y-2>=0 && point.x-1>=0){
            points.add(new Point(point.y-2,point.y-2)); //这里需要创建一个新的对象，因为p1是引用类型，避免下面的判断覆盖这个点位
        }
        if(point.y-1>=0 &&  point.x-2>=0){
            points.add(new Point(point.y-1,point.x-2));
        }
        if(point.y+1<y &&  point.x-2>=0){
            points.add(new Point(point.y+1,point.x-2));
        }
        if(point.y+2<y &&  point.x-1>=0){
            points.add(new Point(point.y+2,point.x-1));
        }
        if(point.y+2<y &&  point.x+1<x){
            points.add(new Point(point.y+2,point.x+1));
        }
        if(point.y+1<y &&  point.x+2<x){
            points.add(new Point(point.y+1,point.x+2));
        }
        if(point.y-1>=0 &&  point.x+2<x){
            points.add(new Point(point.y-1,point.x+2));
        }
        if(point.y-2>=0 &&  point.x+1<x){
            points.add(new Point(point.y-2,point.x+1));
        }

        return points;
    }
}
