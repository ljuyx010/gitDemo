import java.util.Scanner;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/5 10:57
 */
public class Thread03 {
    public static void main(String[] args) {
//        A a = new A();
//        B b = new B();
//        a.start();
//        b.start();
        Blank blank1 = new Blank();
        blank1.setName("用户A");
        Blank blank2 = new Blank();
        blank2.setName("用户B");
        blank1.start();
        blank2.start();
    }
}

class A extends Thread {
    private static boolean loop = true;
    @Override
    public void run() {
        int count = 0;
        while (loop) {
            System.out.println("A线程" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B extends Thread {
    A a = new A();
    @Override
    public void run() {
        while (true) {
            System.out.println("请输入指令:");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equals("q")) {
                a.setLoop(false);
                break;
            }
        }
    }
}

class Blank extends Thread {
    private static long money = 10000;
    @Override
    public void run() {
        while (true) {
            synchronized (Blank.class) {
                if (money < 1000) {
                    break;
                }
                money = money - 1000;
                System.out.println(Thread.currentThread().getName() + "取出1000元，当前余额为:" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}