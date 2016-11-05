package com.hisign.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

	public static String CONFIG_FILE = "config.ini";

	private static Properties props = null;

	public static void initialize() {
		props = new Properties();

		try {
			props.load(new FileInputStream(new File(CONFIG_FILE)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getConfig(String key) {
		if (props == null) {
			initialize();
		}

		return props.getProperty(key);
	}
}
