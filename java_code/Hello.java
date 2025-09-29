public class Hello {
    public static void main(String[] args) {
       double d = 13.4;
       long l = (long)d;
       System.out.println(l);
       int in = 5;
       boolean b = (boolean) in;// 错误int 不能转boolean
       System.out.println(b);
       //20，20,true,10,20
        Object object = new Object();
        object.equals("hello");
    }
}

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person{
    private String name;
    private int age;
    private double sorce;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {}
}

class  Monster{
    private String name;
    private String job;
    private double salary;

    public Monster(String name, String job, double salary) {
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}