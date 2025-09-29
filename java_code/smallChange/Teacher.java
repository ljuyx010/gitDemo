public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, int age, String sex, int work_age) {
        super(name, age, sex);
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println(getName()+"承诺，我会认真教学");
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    @Override
    public String play() {
        return super.play() + "飞行棋";
    }

    public void printInfo(){
        System.out.println("老师的信息：");
        super.printInfo();
        System.out.println("工龄："+work_age);
        this.teach();
        System.out.println(this.play());
    }
}
