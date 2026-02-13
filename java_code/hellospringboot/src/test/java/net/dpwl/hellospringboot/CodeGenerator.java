package net.dpwl.hellospringboot;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
/**
 * @author 混江龙
 * @version 1.0
 * @time 2026/2/13 10:41
 * mybaitsPlus 代码自动生成插件类
 */
@SpringBootTest
public class CodeGenerator {
    public static void main(String[] args) {
//        为了让生成器正确读取表注释，MySQL连接URL必须包含：remarks=true&useInformationSchema=true
        FastAutoGenerator.create(
                        "jdbc:mysql://localhost:3306/myyunmengfayuan?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&remarks=true&useInformationSchema=true", // 🔥改1：数据库URL
                        "root",      // 🔥改2：用户名
                        "H3u94c94kod0UjGuNmkfmqw0JMJRMF"   // 🔥改3：密码
                )
                // ========== 1. 全局配置 ==========
                .globalConfig(builder -> builder
                        .author("混江龙")                // 🔥改4：作者
                        .outputDir(System.getProperty("user.dir") + "/src/main/java") // 输出路径
                        .disableOpenDir()               // 生成后不打开文件夹
                        .enableSwagger()                // 实体类启用Swagger注解（按需）
                        .dateType(DateType.TIME_PACK)   // 使用java.time.*
                        .commentDate("yyyy-MM-dd")      // 注释日期格式
                )
                // ========== 2. 包名配置 ==========
                .packageConfig(builder -> builder
                        .parent("net.dpwl.hellospringboot")           // 🔥改5：父包名
                        .moduleName("")                 // 模块名（不需要可留空）
                        .entity("entity")               // 实体类包名
                        .service("service")             // service包名
                        .serviceImpl("service.impl")    // serviceImpl包名
                        .mapper("mapper")               // mapper包名
                        .xml("mapper.xml")              // xml文件包名
                        .controller("controller")       // controller包名
                        .pathInfo(Collections.singletonMap(OutputFile.xml,
                                System.getProperty("user.dir") + "/src/main/resources/mapper")) // xml输出路径
                )
                // ========== 3. 策略配置（核心） ==========
                .strategyConfig(builder -> builder
                        // ----- 表匹配规则 -----
                        .addInclude("dp_user", "dp_article","dp_admin","dp_cate")     // 🔥改6：需要生成的表名，支持多个
                        .addTablePrefix("dp_")        // 可选：过滤表前缀（负责在生成实体类时，把表名的这个前缀去掉，映射成不带前缀的类名）

                        // ----- Entity 策略（最常用）-----
                        .entityBuilder()
                        .javaTemplate("/templates/entity.java.vm")  // 使用自定义模板
//                        .enableLombok()                 // ✅ 启用Lombok（推荐）
                        .enableChainModel()             // ✅ 链式setter
                        .enableTableFieldAnnotation()   // ✅ 生成@TableField注解
                        .naming(NamingStrategy.underline_to_camel)      // 表名下划线转驼峰
                        .columnNaming(NamingStrategy.underline_to_camel) // 字段名下划线转驼峰
                        .idType(IdType.AUTO)            // 主键策略：自增
                        .logicDeleteColumnName("deleted") // 逻辑删除字段
                        .versionColumnName("version")   // 乐观锁字段

                        // ----- Controller 策略 -----
                        .controllerBuilder()
                        .enableRestStyle()              // ✅ 生成@RestController
                        .enableHyphenStyle()            // ✅ 允许驼峰转连字符（/user/detail-1）

                        // ----- Mapper 策略 -----
                        .mapperBuilder()
                        .enableBaseResultMap()          // ✅ 生成通用ResultMap
                        .enableBaseColumnList()         // ✅ 生成通用ColumnList

                        // ----- Service 策略 -----
                        .serviceBuilder()
                        .formatServiceFileName("%sService")   // 接口名，如 UserService
                        .formatServiceImplFileName("%sServiceImpl") // 实现类名
                )
                // ========== 4. 模板引擎（使用默认Velocity） ==========
                .templateEngine(new VelocityTemplateEngine()) // 必须显式指定Velocity模板引擎
                // ========== 5. 执行 ==========
                .execute();

        System.out.println("代码生成完成！");
    }
}
