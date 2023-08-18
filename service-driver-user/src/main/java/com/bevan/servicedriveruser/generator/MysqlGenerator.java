package com.bevan.servicedriveruser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author zbf
 * 2023/8/18 10:17
 */
public class MysqlGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?charaterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root", "11223344")
                .globalConfig(builder -> {
                    builder.author("bevan").fileOverride()
                            .outputDir("/Users/zhengbufeng/IdeaProjects/online-taxi-public/service-driver-user/src/main/java/com/bevan/servicedriveruser");
                })
                .packageConfig(builder -> {
                    builder.parent("com.bevan.servicedriveruser").pathInfo(Collections.singletonMap(OutputFile.mapper,
                            "/Users/zhengbufeng/IdeaProjects/online-taxi-public/service-driver-user/src/main/java/com/bevan/servicedriveruser/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("car");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
