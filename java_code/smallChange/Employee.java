public class Employee {
    private String name;
    private int age;
    private double salary;
    private int days;
    private double grade;

    public Employee(String name, int age, double salary, int days, double grade) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.days = days;
        this.grade = grade;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    //打印工资
    public void printSal(){
        System.out.println(name+"工资="+salary*days*grade);
    }
}
