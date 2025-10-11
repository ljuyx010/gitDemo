import java.util.Scanner;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/11 09:48
 */
public class TryException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a ;
        Boolean b = true;
        do{
            System.out.println("请输入一个整数");
            a = scanner.next();
            try{
                Integer.parseInt(a);
                b =  false;
            }catch (Exception e){
                b = true;
            }
        }while(b);

    }

}
