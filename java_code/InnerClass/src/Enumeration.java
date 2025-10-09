/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/10/9 15:53
 */
public class Enumeration {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        Week[] values = Week.values();
        for (Week week : values) {
            System.out.println(week.getName());
        }
    }
}

enum Season{
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冬雪皑皑");
    private String name;
    private String desc;
    Season(String name,String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

enum Week{
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");
    private String name;
    Week(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}