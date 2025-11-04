/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/11/4 14:13
 */
public class Thread02 {
    public static void main(String[] args) throws InterruptedException {
//        //创建一个线程对象，把dog对象（实现了Runnable接口）作为参数传递
//        Thread thread = new Thread(new Dog());
//        //启动线程
//        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi"+i);
            if(i==5){
                Say say = new Say();
//                创建子线程
                Thread thread = new Thread(say);
                //启动线程
                thread.start();
                //让thread线程插队，等待线程执行完毕
                thread.join();
            }
        }
    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("小狗汪汪叫" + (++count) +"线程名称="+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}

class Say implements Runnable {
    private int count = 0;
    @Override
    public void run() {

        while (true) {
            System.out.println("hello" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }
        }
    }
}