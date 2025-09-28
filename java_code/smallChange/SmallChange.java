import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class SmallChange {
    public static void main(String[] args) {
        //输出菜单
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        String key = "";
        String details = "---------------零钱通明细---------------------";
        double money = 0;
        double balance = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date ;
        String note = "";
        do {
            System.out.println("\n---------------零钱通菜单-------------");
            System.out.println("\t\t\t 1.零钱通明显");
            System.out.println("\t\t\t 2.收益入账");
            System.out.println("\t\t\t 3.消费");
            System.out.println("\t\t\t 4.退   出");
            System.out.print("请选择（1-4）：");
            key = sc.next();
            //使用分支控制选择
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额：");
                    money = sc.nextDouble();
                    //money的值需要校验
                    balance += money;
                    date = new Date();
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("消费金额：");
                    //消费金额也需要校验
                    money = sc.nextDouble();
                    balance -= money;
                    System.out.print("消费说明：");
                    note = sc.next();
                    date = new Date();
                    details += "\n"+note+"\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "4":
                    //根据用户输入y,n确认退出
                    String choice = "";
                    while (true){
                        System.out.println("你确定要退出吗？y/n");
                        choice = sc.next();
                        if (choice.equals("y") || choice.equals("n")){
                            break;
                        }
                    }
                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择错误,请重新选择");
            }
        } while (loop);
        System.out.println("程序结束...");
    }
}
