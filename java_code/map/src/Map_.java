/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/23 10:18
 */
import java.util.*;

public class Map_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
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
    }
}
