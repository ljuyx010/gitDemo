/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 11:37
 */
public class Thread01 {
    public static void main(String[] args) {
        //创建一个Cat线程对象,可以当做线程来使用
        Cat cat = new Cat();
        //启动线程
        cat.start();
    }
}
//1.当一个类继承了Thread类，就可以当作线程来使用
//2.重写run方法，实现自己的业务逻辑，线程启动后，会调用run方法
//3.Thread类的run方法，是实现Runnable接口的run方法
class Cat extends Thread {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            //重写run方法，实现自己的业务逻辑，线程启动后，会调用run方法
            System.out.println("喵喵，我是一个小猫咪" + count++);
            //让线程休眠1秒，模拟喵喵喵的过程
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) { //当count等于10时，跳出循环,即结束线程
                break;
            }
        }

    }
}

class Sall extends Thread {
    private static int count = 100;
    private boolean loop =  true;
    //small方法设为synchronized，确保在多线程环境下，每次只能有一个线程执行small方法
    private synchronized void small() {
        if(count<=0){
            loop = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"卖出一张票，还有" + (--count) + "张票");
    }
    @Override
    public void run() {
        while (loop) {
            small();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
