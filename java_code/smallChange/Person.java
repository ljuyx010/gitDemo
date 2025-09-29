public class Person {
    private String name;
    private int age;
    private String sex;
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    static void main(String[] args) {
//        Person[] persons = new Person[3];
//        persons[0] = new Person("王二",15,"学生");
//        persons[1] = new Person("张三",20,"大学生");
//        persons[2] = new Person("李四",26,"老师");
//        sort(persons);
//        for ( int i = 0; i < persons.length; i++ ) {
//            System.out.println(persons[i]);
//        }
        Manger manger = new Manger("张三",30,200,22,1.2);
        manger.setBouns(3000);
        manger.printSal();
        Worker worker = new Worker("网二",20,100.0,26,1.0);
        worker.printSal();
    }

    public String play(){
        return name + "爱玩";
    }

    public void printInfo(){
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
        System.out.println("性别："+sex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void sort(Person[] arr){
        for(int i=0;i<arr.length;i++){
            Person max ;
            for(int j=arr.length;j>i;j--){
               if(arr[j-1].age > arr[i].age){
                  max = arr[j-1];
                  arr[j-1] = arr[i];
                  arr[i] = max;
               }
            }
        }
    }
}
