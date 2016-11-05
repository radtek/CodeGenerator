package com.hisign.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库工具
 * 
 * @time: 1:06:03
 * @author lift
 */
public class DatabaseUtil {

	/**
	 * 根据字段类型返回java类型
	 * 
	 * @param coulmnType 字段类型字符串
	 * @return java类型
	 * @throws Exception
	 */
	public static String getClassTypeByColumnType(String coulmnType) throws Exception {
		Map columnMapClass = new HashMap();
		columnMapClass.put("CHAR", "String");
		columnMapClass.put("NCHAR", "String");
		columnMapClass.put("VARCHAR2", "String");
		columnMapClass.put("NVARCHAR2", "String");
		columnMapClass.put("FLOAT", "Float");
		columnMapClass.put("DOUBLE", "Double");
		columnMapClass.put("LONG", "Long");
		columnMapClass.put("TIMESTAMP", "java.util.Date");
		columnMapClass.put("TIMESTAMP(6)", "java.util.Date");
		columnMapClass.put("DATE", "java.util.Date");
		columnMapClass.put("BLOB", "Object");
		columnMapClass.put("NUMBER", "Integer");
		columnMapClass.put("CLOB", "String");

		String ret = (String) columnMapClass.get(coulmnType);

		if (ret == null) {
			throw new Exception("error:没有拿到返回值:" + coulmnType);
		}
		return ret;
	}

}
