public class Worker extends Employee{
    public Worker(String name, int age, double salary, int days, double grade) {
        super(name, age, salary, days, grade);
    }
    public void printSal(){
        System.out.print("普通员工");
        super.printSal();
    }
}
