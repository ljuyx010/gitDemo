public class Manger extends Employee{
    private double bouns;

    public Manger(String name, int age, double salary, int days, double grade) {
        super(name, age, salary, days, grade);
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
    public void printSal(){
        System.out.println("经理"+getName()+"工资="+(bouns+getSalary()*getDays()*getGrade()));
    }
}
