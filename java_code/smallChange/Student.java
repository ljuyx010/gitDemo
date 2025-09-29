public class Student extends Person {
    private String stu_id;

    public Student(String name, int age, String sex, String stu_id) {
        super(name, age, sex);
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println(getName() + "承诺，我会好好学习");
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    public void printInfo(){
        System.out.println("学生的信息：");
        super.printInfo();
        System.out.println("学号："+stu_id);
        this.study();
        System.out.println(this.play());
    }
}
