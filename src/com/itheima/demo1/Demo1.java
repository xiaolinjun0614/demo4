package com.itheima.demo1;

import java.io.File;
import java.util.Properties;

public class Demo1 {
	
	public static void main(String[] args) {
		//得到当前Java所有的属性配置
		//Properties properties = System.getProperties();
		//输出所有的配置信息
		//properties.list(System.out);
		System.out.println("文件路径分隔符：" + File.separator);
	}

}
