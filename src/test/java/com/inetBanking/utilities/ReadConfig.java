package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop=new Properties();
	public ReadConfig()  {
		String basepath=System.getProperty("user.dir");
		System.out.println(basepath);
		FileInputStream fis;
		try {
			fis = new FileInputStream("./Configuration/config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
		
	public String getURL() {
		String url=prop.getProperty("url");
		return url;
	}
	public String getUserId() {
		String uid=prop.getProperty("userid");
		return uid;
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}
}
