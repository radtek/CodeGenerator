package com.hisign.generator;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.alibaba.druid.util.JdbcUtils;
import com.hisign.model.TableModel;
import com.hisign.util.ConfigUtil;
import com.hisign.util.JDBCUtil;

/**
 * Model生成器
 * 
 * @author Hong
 */
public class ServiceGenerator {

	private static final List DEF_PARAM = new ArrayList();
	
	private static final String OUTPUT_INF_PATH = "./output/service/inf/";
	
	private static final String OUTPUT_IMPL_PATH = "./output/service/impl/";
	
	private static final String INF_SUFFIX = "Service.java";
	
	private static final String IMPL_SUFFIX = "ServiceImpl.java";

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public static void generate() throws SQLException {
		
		System.out.println("==========Service生成器==========");
		System.out.println("数据库URL-->" + ConfigUtil.getConfig("jdbc.url"));
		System.out.println("数据库USERNAME-->" + ConfigUtil.getConfig("jdbc.username"));
		System.out.println("数据库PASSWORD-->" + ConfigUtil.getConfig("jdbc.password"));
		System.out.println("确认数据库连接参数配置是否正确？不正确请在config.ini中进行修改，"
				+ "正确请输入表名(多个用英文逗号分隔)，不输入默认全库生成，按回车继续!");
		
		final String inputText = new Scanner(System.in).nextLine();

		Connection conn = JDBCUtil.getConnection(ConfigUtil.getConfig("jdbc.url"),
				ConfigUtil.getConfig("jdbc.username"), ConfigUtil.getConfig("jdbc.password"));

		List<Map<String, Object>> tabList = null;
		if (StringUtils.isBlank(inputText)) {
			tabList = JdbcUtils.executeQuery(conn, 
					"select t.table_name,c.comments from user_tables t,user_tab_comments c where t.table_name=c.table_name", 
					DEF_PARAM);
		} else {
			tabList = JdbcUtils.executeQuery(conn, 
					"select t.table_name,c.comments from user_tables t,user_tab_comments c where t.table_name=c.table_name and instr(?, t.table_name)>0", 
					new ArrayList() {{
						this.add(inputText.toUpperCase());
					}});
		}

		Map context = new HashMap();
		List<TableModel> tableModelList = new ArrayList<TableModel>();

		for (Map<String, Object> table : tabList) {
			final TableModel tableModel = new TableModel();
			tableModel.setTableName((String) table.get("TABLE_NAME"));
			tableModel.setTableChineseName((String) table.get("COMMENTS"));
			context.put("tableModel", tableModel);
			tableModelList.add(tableModel);
			
			System.out.println(tableModel.getTableName() + " ... ");

			// 接口生成
			String outputFilePath = OUTPUT_INF_PATH + tableModel.getTableName2Pascal() + INF_SUFFIX;
			try {
				FreeMarkerManager.getInstance().renderTemplate("ServiceInfTemplate.java", outputFilePath, context, "UTF-8");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			// 实现类生成
			outputFilePath = OUTPUT_IMPL_PATH + tableModel.getTableName2Pascal() + IMPL_SUFFIX;
			try {
				FreeMarkerManager.getInstance().renderTemplate("ServiceImplTemplate.java", outputFilePath, context, "UTF-8");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		
		context = new HashMap();
		context.put("tableModelList", tableModelList);
		
		// dubbo配置文件
		String outputFilePath = OUTPUT_INF_PATH + "spring-dubbo.xml";
		try {
			FreeMarkerManager.getInstance().renderTemplate("DubboConfigTemplate.xml", outputFilePath, context, "UTF-8");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		JDBCUtil.close(null, null, conn);
		
		System.out.println("==========完成==========");
	}
	
	public static void main(String[] args) throws SQLException {
		ServiceGenerator.generate();
	}
	
}
