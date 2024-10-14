package com.ricardo.rebecca.support.generator;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.OracleQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

import java.sql.Types;
import java.util.Collections;

/**
 * @Class Generator
 * @Description TODO
 * @Author RicardoC
 * @Date 2024/9/21 1:48
 */
public class Generator {


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/rebecca?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull";
        String username = "root";
        String password = "Ricardoc297.";
        // 输出路径
//        String outputDir = "/Users/ricardo/IdeaProjects/business-platform/platform-domain/platform-pharmacy/platform-pharmacy-storage/src/main/java";
//        String mapperOutputDir = "/Users/ricardo/IdeaProjects/business-platform/platform-domain/platform-pharmacy/platform-pharmacy-storage/src/main/resources/mapper/medsystem";
        String outputDir = "D:\\Code\\MyProjects\\rebecca\\rebecca-user\\src\\main\\java";
        String mapperOutputDir = "D:\\Code\\MyProjects\\rebecca\\rebecca-user\\src\\main\\resources\\mapper";
        // 作者
        String author = "Cypress";
        // 包名
        String packingName = "com.ricardo.rebecca";
        // 模块
        String moduleName = "user"; //todo 换项目改这里
        // 表名
        String tableName = "User";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd HH:mm:ss")
                            .outputDir(outputDir); // 指定输出目录
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                return DbColumnType.INTEGER;
                            }
                            if (typeCode == Types.VARCHAR || typeCode == Types.NVARCHAR) {
                                return DbColumnType.STRING;
                            }
                            if (typeCode == Types.CLOB) {
                                return DbColumnType.STRING;
                            }
                            if (typeCode == Types.BLOB) {
                                return DbColumnType.BYTE;
                            }
                            if (typeCode == Types.OTHER) {
                                return DbColumnType.STRING;
                            }
                            if (typeCode == Types.TIMESTAMP) {
                                return DbColumnType.DATE;
                            }
                            if (typeCode == Types.DECIMAL) {
                                return DbColumnType.BIG_DECIMAL;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        }
                ).dbQuery(new OracleQuery()))
                .packageConfig(builder -> {
                    builder.parent(packingName) // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperOutputDir)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableName) // 设置需要生成的表名
//                            .addTablePrefix("MEDICARE_")
                            .entityBuilder()
//                            .superClass(BaseEntity.class)
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .addSuperEntityColumns("createUser", "createTime", "updateUser", "updateTime", "hospitalCode")
                            .idType(IdType.ASSIGN_ID)
//                            .controllerBuilder()
//                            .superClass(BaseController.class)
//                            .enableHyphenStyle()
//                            .enableRestStyle()
//                            .enableFileOverride()

                            .serviceBuilder()
//                            .superServiceClass(IService.class)
//                            .superServiceImplClass(ServiceImpl.class)
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
//
//                            .mapperBuilder()
//                            .enableMapperAnnotation()
//                            .enableBaseResultMap()
//                            .enableBaseColumnList()
                            .build()
                    ; // 设置过滤表前缀
                })
                .templateConfig(builder -> {
                    builder
                            .entity("/vm/entity.java")
                            .service("/vm/service.java")
                            .serviceImpl("/vm/serviceImpl.java")
                            .mapper("/vm/mapper.java")
                            .xml("/vm/mapper.xml")
                            .controller("/vm/controller.java")
                            .build();
                })
//                .injectionConfig(builder -> {
//                    builder.customFile(new CustomFile.Builder()
//                            .fileName("%sDTO.java")
//                            .templatePath("/vm/dto.java.vm")
//                            .packageName("dto").build());
//                })
                .execute();

    }
}
