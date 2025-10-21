import java.util.*;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/11 09:48
 */
public class TryException {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String a ;
//        Boolean b = true;
//        do{
//            System.out.println("请输入一个整数");
//            a = scanner.next();
//            try{
//                Integer.parseInt(a);
//                b =  false;
//            }catch (Exception e){
//                b = true;
//            }
//        }while(b);
//    把输入的数字格式输出每三位加一个逗号
/*        System.out.println("请输入手机的价格：");
        Double price = scanner.nextDouble();
        String str = price.toString();
        StringBuffer sb = new StringBuffer(str);
        //int d = sb.indexOf(".");//找到小数点的位置，往前3位加逗号
        // sb = sb.insert(d-3,",");
        for(int i = sb.indexOf(".")-3;i>0;i-=3){
            //循环判断加完后前面的数字是否还大于3位
            sb = sb.insert(i,",");
        }
        System.out.println(sb.toString());


        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100.0);
        books[1] = new Book("金瓶梅新",90.0);
        books[2] = new Book("青年文摘20年",5.0);
        books[3] = new Book("java从入门到放弃",400.0);
        Arrays.sort(books, new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                Double i1= (Double) ((Book)o1).getPrice();
                Double i2= (Double) ((Book)o2).getPrice();
                String l1= (String) ((Book)o1).getName();
                String l2= (String) ((Book)o2).getName();
                //return (int) (i1-i2);// price 升序
                //return (int) (i2-i1);// price 降序
                return l2.length() - l1.length();   //名称长度降序
//                return l1.length() - l2.length();   //名称长度升序
            }
        });
        System.out.println(Arrays.toString(books));


        System.out.println("请输入姓名：");
        //注意，这里不能使用scanner.next()，因为next()方法会自动去掉空格
        //而nextLine()方法会自动保留空格
        String name = scanner.nextLine();
        String[] names = name.split(" ");
        System.out.println(Arrays.toString(names));
        String newName = "";
        for (int i = 0; i < names.length; i++) {
            if(i == 0){
                newName += names[i];
            }else if(i == 1){
                char c = names[i].toUpperCase().charAt(0);
                newName += "."+c;
            }else if(i == 2){
                newName = names[i]+"，" + newName;
            }else{
                newName += " "+names[i];
            }
        }
        System.out.println(newName);


        List books = new ArrayList();
        books.add(new Book("红楼梦",100.0,"曹雪芹"));
        books.add(new Book("西游记",120.0,"吴承恩"));
        books.add(new Book("水浒传",70.0,"施耐庵"));
        books.add(new Book("三国演义",80.0,"罗贯中"));
        sort(books);
        for (Object o :books) {
            System.out.println(o.toString());
        }

    }
    @SuppressWarnings({"all"})
    public static void sort(List list){
        for(int i=0;i<list.size();i++){
            for (int j = i+1; j < list.size(); j++) {
                if(((Book)list.get(i)).getPrice() > ((Book)list.get(j)).getPrice()){
                    Book temp = (Book)list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }

 */
        Employee a = new Employee("张三",10000.0,new MyDate(1990,1,1));
        Employee b = new Employee("李四",10000.0,new MyDate(1990,1,1));
        Employee c = new Employee("张三",10000.0,new MyDate(1990,1,1));
        HashSet<Employee> hashSet = new HashSet<>();
        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        System.out.println("hashSet = "+hashSet);
    }


}

class Book{
    private String name;
    private Double price;
    private String author;
    public Book(String name, Double price,String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "名称：" + name + "\t" + "价格：" + price + "\t" + "作者：" + author;
    }

}

class Employee{
    private String name;
    private double salary;
    private MyDate brithday;
    public Employee(String name, double salary, MyDate brithday) {
        this.name = name;
        this.salary = salary;
        this.brithday = brithday;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(brithday.toString(), employee.brithday.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, brithday.toString());
    }
}
class MyDate{
    private int year;
    private int month;
    private int day;
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }
}