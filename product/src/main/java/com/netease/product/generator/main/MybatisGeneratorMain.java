/**
 * @(#)MybatisGeneratorMain.java, 2017年10月17日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.product.generator.main;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.netease.product.generator.config.ConfigFileConstants;
import com.netease.product.generator.config.ConfigUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;


/**
 *
 * 方式一：main方法运行：maven命令无法生成dao后缀的文件（javaDaoGenerator会出错），只能生成Mapper接口
 * 方式二：通过Maven插件运行，但是需要在generatorConfig.xml文件中使用绝对路径，而不能通过properties文件来配置修改；不方便，且无法运行javaDaoGenerator<br>
 * mybatis-generator-core 1.3.6版本才会生成dao文件，不然只会生成imapper接口文件
 * @author hzzhangyong
 *
 */
public class MybatisGeneratorMain {

    /**配置文件路径*/
    public final static String CONFIG_PATH = MybatisGeneratorMain.class.getClassLoader().getResource(ConfigFileConstants.GENERATOR_CONFIG).getPath();

    public static void main(String[] args) {
        List<String> warnings = new ArrayList<>();
        try {
            boolean overwrite = false;
            File configFile = new File(CONFIG_PATH);
            Properties properties = ConfigUtil.getProperties();
            ConfigurationParser cp = new ConfigurationParser(properties, warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
            warnings.add(e.toString());
        } finally {
            System.out.println(warnings);
        }
    }
    
}
