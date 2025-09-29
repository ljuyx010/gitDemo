import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOop {
    /*
    * 将各个功能封装成各个方法
     */
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String details = "---------------零钱通明细---------------";
    private double money = 0;
    private double balance = 0;
    Date date = new Date();
    SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String note = "";
    public void  menu() {
        do {
            System.out.println("\n---------------零钱通菜单-------------");
            System.out.println("\t\t\t 1.零钱通明显");
            System.out.println("\t\t\t 2.收益入账");
            System.out.println("\t\t\t 3.消费");
            System.out.println("\t\t\t 4.退   出");
            System.out.print("请选择（1-4）：");
            key = scanner.next();
            //使用分支控制选择
            switch (key) {
                case "1":
                    this.getDetails();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.outcome();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择错误,请重新选择");
            }
        } while (loop);
        System.out.println("程序结束...");
    }
    public void getDetails(){
        System.out.println(details);
    }

    public void income(){
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        //money的值需要校验
        // 找出不正确的金额的条件，然后给出提示，就直接break
        if(money <= 0){
            System.out.println("收益入驻金额需要大于0");
            return;
        }
        balance += money;
        date = new Date();
        details += "\n收益入账\t+" + money + "\t" + dtf.format(date) + "\t" + balance;
    }

    public void outcome(){
        System.out.print("消费金额：");
        //消费金额也需要校验
        money = scanner.nextDouble();
        if(money <= 0 || money > balance){
            System.out.println("消费金额应该在0到"+balance+"之内");
            return;
        }
        balance -= money;
        System.out.print("消费说明：");
        note = scanner.next();
        date = new Date();
        details += "\n"+note+"\t-" + money + "\t" + dtf.format(date) + "\t" + balance;
    }

    public void exit(){
        //根据用户输入y,n确认退出
        String choice = "";
        while (true){
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if (choice.equals("y") || choice.equals("n")){
                break;
            }
        }
        if(choice.equals("y")){
            loop = false;
        }

    }
}
