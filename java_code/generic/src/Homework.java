/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/27 11:58
 */
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"all"})
public class Homework {
    public static void main(String[] args) {
        //指定泛型类Dao 的T为User
        Dao<User> userDao = new Dao<>();
        userDao.save("1001",new User(1001,18,"张三"));
        userDao.save("1002",new User(1002,19,"王二"));
        userDao.save("1003",new User(1003,20,"李四"));
        System.out.println(userDao.list());
    }
//    @Test
//    public void  testList(){
//        //指定泛型类Dao 的T为User
//        Dao<User> userDao = new Dao<>();
//        userDao.save("1001",new User(1001,18,"张三"));
//        userDao.save("1002",new User(1002,19,"王二"));
//        userDao.save("1003",new User(1003,20,"李四"));
//        System.out.println(userDao.list());
//    }
}

class Dao<T>{

     private Map<String,T> map;

     public Dao(){
        map = new HashMap<String,T>();
    }

     public void save(String id,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }

    public List<T> list(){
        return new ArrayList<>(map.values());
    }

    public void delete(String id){
        map.remove(id);
    }

}

class User{
    private int id;
    private int age;
    private String name;
    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}