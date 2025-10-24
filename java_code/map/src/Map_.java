/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/23 10:18
 */
import java.util.*;

public class Map_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
       /*
        Map map = new HashMap();
        map.put("no1","张三");
        map.put("no2","李四");
        map.put("no3","王五");
        map.put("no4","王二");
        map.put("no5","麻子");
        Set keySet = map.keySet();
        // 增强for遍历
        for (Object key : keySet) {
            System.out.println(key+":"+map.get(key));
        }
        // 迭代器
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key+":"+map.get(key));
        }
        // 把所有的values取出
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        // 通过entrySet来获取k-v
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            // 将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey()+":"+m.getValue());
        }

        */
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河圣欲引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList<News> newsList = new ArrayList<News>();
        newsList.add(news1);
        newsList.add(news2);
        // 反转newsList
        Collections.reverse(newsList);
        // 遍历newsList
        for (News news : newsList) {
            String title = news.getTitle();
            title = title.length()>15 ? title.substring(0,15)+"..." : title;
            System.out.println(title);
        }
        HashSet<Student> studentSet = new HashSet<Student>();
        studentSet.add(new Student("张三",18));
        studentSet.add(new Student("李四",19));
        studentSet.add(new Student("王五",20));
        studentSet.add(new Student("王二",21));
        studentSet.add(new Student("麻子",22));
        System.out.println(studentSet);
        HashMap<String,Student> studentMap = new HashMap<String,Student>();
        studentMap.put("no1",new Student("张三",18));
        studentMap.put("no2",new Student("李四",19));
        studentMap.put("no3",new Student("王五",20));
        studentMap.put("no4",new Student("王二",21));
        studentMap.put("no5",new Student("麻子",22));
        for (Student student : studentMap.values()) {
            System.out.println(student);
        }
        Set<Map.Entry<String, Student>> entrySet = studentMap.entrySet();
        Iterator it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Student> entry = (Map.Entry<String, Student>) it.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}

class News{
    private String title;
    private String content;
    private String author;
    private Date date;

    public News(String title) {
        this.title = title;
    }

    public News(String title, String content, String author, Date date) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }
}

class Student{
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
