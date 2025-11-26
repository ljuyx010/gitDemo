import java.util.Scanner;

import static java.lang.Character.toLowerCase;

public class Utility {
    private static Scanner sc = new Scanner(System.in);
    private static int feednum = 0;
    public Utility(){}
        //读取键盘输入的一个字符
        public static char readMenuSelection(){
            char c = sc.next().charAt(0);
            feednum = 0;
            return c;
        }
        //读取键盘输入的一个整数
        public static int readInt(){
            int i = sc.nextInt();
            feednum = 0;
            return i;
        }
        //读取键盘输入的一个浮点数
        public static double readDouble(){
            double d = sc.nextDouble();
            feednum = 0;
            return d;
        }
        public static float readFloat(){
            float f = sc.nextFloat();
            feednum = 0;
            return f;
        }
        //读取键盘输入的一个字符串
        public static String readString(int length,Boolean lineFeed){
            if(feednum == 0){
                //清空缓冲区
                sc.nextLine();
                feednum++;
            }
            String str = lineFeed?sc.nextLine():sc.next();
            if (str.length() > length) {
                str = str.substring(0, length);
            }
            return str;
        }
        //确认是否继续
        public static char readConfirmSelection(){
            char c;
            do {
                System.out.print("确认选择(y/n)：");
                c = toLowerCase(sc.next().charAt(0));//将输入的字符转换为小写
            } while (c != 'y'  && c != 'n');
            return c;
        }
}
