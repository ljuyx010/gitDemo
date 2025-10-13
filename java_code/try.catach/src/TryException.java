import java.util.Scanner;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/11 09:48
 */
public class TryException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a ;
//        Boolean b = true;
//        do{
//            System.out.println("请输入一个整数");
//            a = scanner.next();
//            try{
//                Integer.parseInt(a);
//                b =  false;
//            }catch (Exception e){
//                b = true;
//            }
//        }while(b);
//    把输入的数字格式输出每三位加一个逗号
        System.out.println("请输入手机的价格：");
        Double price = scanner.nextDouble();
        String str = price.toString();
        StringBuffer sb = new StringBuffer(str);
        //int d = sb.indexOf(".");//找到小数点的位置，往前3位加逗号
        // sb = sb.insert(d-3,",");
        for(int i = sb.indexOf(".")-3;i>0;i-=3){
            //循环判断加完后前面的数字是否还大于3位
            sb = sb.insert(i,",");
        }
        System.out.println(sb.toString());
    }

}
