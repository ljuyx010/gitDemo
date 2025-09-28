import java.util.Scanner;

class SmallChange{
    public static void main(String[] args){
        //输出菜单
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String key = "";
        do{
            System.out.println("---------------零钱通菜单-------------");
            System.out.println("\t\t\t 1.零钱通明显");
            System.out.println("\t\t\t 2.收益入账");
            System.out.println("\t\t\t 3.消费");
            System.out.println("\t\t\t 4.退   出");
            System.out.print("请选择（1-4）：");
            key = sc.next();
            //使用分支控制选择
            switch(key){
                case "1":
                    System.out.println('1');
                    break;
                case "2":
                    System.out.println('3');
                    break;
                case "3":
                    System.out.println('3');
                    break;
                case "4":
                    loop = false;
                    break;
                default:
                    System.out.println("选择错误,请重新选择");
            }
        }while (loop);
        System.out.println("程序结束...");
    }
}
