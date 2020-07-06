package com.tk.mbg.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Generator {
   /* public static void main(String[] args) {
        args = new String[] { "-configfile", "src\\main\\java\\resources\\generator\\generatorConfig.xml", "-overwrite" };
        ShellRunner.main(args);

    }*/

	public static void main(String[] args) throws Exception {
		File configFile = ResourceUtils.getFile("classpath:generator/generatorConfig.xml");
		List<String> warnings = new ArrayList<String>();
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);

	}

}
