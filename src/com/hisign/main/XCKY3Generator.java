package com.hisign.main;

import java.sql.SQLException;

import com.hisign.generator.MapperGenerator;
import com.hisign.generator.ModelGenerator;
import com.hisign.generator.ServiceGenerator;

/**
 * 生成器
 * 
 * @author Hong
 */
public class XCKY3Generator {

	public static void main(String[] args) throws Exception {

		if (null != args && "ModelGenerator".equals(args[0])) {
			ModelGenerator.generate();
		} else if (null != args && "MapperGenerator".equals(args[0])) {
			MapperGenerator.generate();
		} else if (null != args && "ServiceGenerator".equals(args[0])) {
			ServiceGenerator.generate();
		}
	}
}
