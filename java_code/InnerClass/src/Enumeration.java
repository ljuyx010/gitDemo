/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/9 15:53
 */
public class Enumeration {
    public static void main(String[] args) {
//        System.out.println(Season.SPRING);
//        Week[] values = Week.values();
//        for (Week week : values) {
//            System.out.println(week.getName());
//        }
        A a = new A("混江龙");
        System.out.println(a.say());
        Person tang = new Person("唐僧", VehiclesFactory.getHorse());
        System.out.println(tang.show());
        tang.doBoat();
        System.out.println(tang.show());
        Car car = new Car(30);
        car.testAir();
        //switch()括号中放入枚举对象，case中放入枚举常量
        switch (Color.BLUE){
            case RED:
                Color.RED.show();
                break;
            case BLUE:
                System.out.println("蓝色");
                break;
            case BLACK:
                System.out.println("黑色");
                break;
            case YELLOW:
                System.out.println("黄色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
        }
    }
}

enum Season{
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冬雪皑皑");
    private String name;
    private String desc;
    Season(String name,String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String name;
    Week(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class A{
    private String name;
    public A(String name) {
        this.name = name;
    }
    public String say(){
        class B{
            private final String NAME;
            B(){
                this.NAME = A.this.name;
            }
            B(String name){
                this.NAME = name;
            }
            public String show(){
                return this.NAME;
            }
        }
        return new B("测试内部类").show();
    }
}

interface Vehicles{
    public String work();
}
class Horse implements Vehicles{
    private String name;
    public Horse(String name){
        this.name = name;
    }
    @Override
    public String work() {
        return this.name + "在通常情况下使用";
    }
}
class Boat implements Vehicles{
    private String name;
    public Boat(String name){
        this.name = name;
    }
    @Override
    public String work() {
        return this.name + "在遇到河的情况下使用";
    }
}
class VehiclesFactory{
    private static Vehicles createHorse(String name){
        return new Horse(name);
    }
    public static Vehicles getHorse(){
        Vehicles horse = createHorse("白龙马");
//        System.out.println(horse.work());
        return horse;
    }
    private static Vehicles createBoat(String name){
        return new Boat(name);
    }
    public static Vehicles getBoat(String name){
        Vehicles boat = createBoat(name);
//        System.out.println(boat.work());
        return boat;
    }
}
class Person{
    private String name;
    private Vehicles vehicle;
    public Person(String name,Vehicles vehicle){
        this.name = name;
        this.vehicle = vehicle;
    }

    public void doHorse(){
        this.vehicle = VehiclesFactory.getHorse();
    }
    public void doBoat(){
        if(!(this.vehicle instanceof Boat)){
            this.vehicle = VehiclesFactory.getBoat("小船");
        }
    }

    public String show(){
        return this.name + "使用" + this.vehicle.work();
    }

}

class Car{
    private double temperature;
    //Air 成员内部类
    public class Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("温度过高，空调启动");
            }else if(temperature < 0){
                System.out.println("温度过低，暖气启动");
            }else{
                System.out.println("温度正常，不启动空调");
            }
        }
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public void testAir(){
        try {
            new Air().flow();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

interface Gas{
    public void show();
}

enum Color implements Gas{
    RED(255,0,0),
    BLUE(0,0,255),
    BLACK(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private final int red;
    private final int green;
    private final int blue;

    Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public void show() {
        System.out.println("red:" + red + " green:" + green + " blue:" + blue);
    }
}
