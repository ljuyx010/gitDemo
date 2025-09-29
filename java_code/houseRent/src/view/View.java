package view;

import java.util.Scanner;

public class View {
    private boolean loop = true;
    private char key = ' ';
    public void menu(){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============房屋出租系统=============");
            System.out.println("\t\t1. 新增房屋");
            System.out.println("\t\t2. 查找房屋");
            System.out.println("\t\t3. 删除房屋");
            System.out.println("\t\t4. 修改房屋");
            System.out.println("\t\t5. 房屋列表");
            System.out.println("\t\t6. 退出系统");
            System.out.println("请输入你的选择（1-6）：");
            key = sc.next().charAt(0);
            switch (key) {
                case '1':
                    System.out.println("新增房屋");
                    break;
                case '2':
                    System.out.println("显示房屋");
                    break;
                case '3':
                    System.out.println("删除房屋");
                    break;
                case '4':
                    System.out.println("修改房屋");
                    break;
                case '5':
                    System.out.println("房屋列表");
                    break;
                case '6':
                    System.out.println("退出系统");
                    loop = false;
                    break;
                default:
                    System.out.println("你输入的选择有误，请重新输入");
            }
        } while (loop);
    }
}
