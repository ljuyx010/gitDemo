import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/16 10:14
 */
public class RegExp {
    public static void main(String[] args) {
        String content="Java是一门面向对象的编程语言，由Sun公司于1995年正式发布，" +
                "其设计理念源于对C 语言的改进，摒弃了多继承和指针等复杂概念，实现了功能" +
                "强大与简单易用的结合 [1] [9]。作为静态面向对象编程语言的代表，Java通过JVM" +
                "（Java虚拟机）实现跨平台运行，具备分布式、健壮性、安全性、多线程等特性，支持" +
                "桌面应用、Web应用和嵌入式系统开发 [2] [26] [62]。\n" +
                "该语言经历多个重要版本迭代，2006年Sun公司将Java开源 [13]，2009年甲骨" +
                "文公司完成对Sun的收购后持续推进技术更新 [14]。2014年Java 8引入函数式" +
                "编程特性，2017年Java 9实现模块化系统 [15] [56]。2024年3月甲骨文发布" +
                "Java 22，针对性能、安全性和开发效率进行数千项优化，提供对云原生应用和现代硬" +
                "件架构的增强支持";
        // 需求：提取出所有的数字
        String regExp="\\d{4}"; // 匹配4个数字
        Pattern pattern = Pattern.compile(regExp); // 编译正则表达式
        Matcher matcher = pattern.matcher(content); // 创建匹配器
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
