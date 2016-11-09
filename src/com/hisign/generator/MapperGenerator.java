package com.hisign.generator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

import com.alibaba.druid.util.JdbcUtils;
import com.hisign.model.ColumnModel;
import com.hisign.model.TableModel;
import com.hisign.util.ConfigUtil;
import com.hisign.util.JDBCUtil;

/**
 * Mapper生成器
 * 
 * @author Hong
 */
public class MapperGenerator {

	private static final List DEF_PARAM = new ArrayList();
	
	private static final String OUTPUT_MAPPER_PATH = "./output/mapper/";
	
	private static final String OUTPUT_MAPPING_PATH = "./output/mapping/";
	
	private static final String MAPPER_SUFFIX = "Mapper.java";
	
	private static final String MAPPING_SUFFIX = "-mapper.xml";

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws Exception 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	public static void generate() throws SQLException {
		
		System.out.println("==========Mapper生成器==========");
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

		for (Map<String, Object> table : tabList) {
			final TableModel tableModel = new TableModel();
			tableModel.setTableName((String) table.get("TABLE_NAME"));
			tableModel.setTableChineseName((String) table.get("COMMENTS"));
			context.put("tableModel", tableModel);
			
			System.out.println(tableModel.getTableName() + " ... ");

			List<Map<String, Object>> colList = JdbcUtils.executeQuery(conn,
					"select t1.COLUMN_NAME,t1.DATA_TYPE,t1.DATA_LENGTH,t2.comments from user_tab_columns t1,user_col_comments t2 "
					+ "where t1.TABLE_NAME=t2.table_name and t1.COLUMN_NAME=t2.column_name and t1.table_name=? order by column_id", 
					new ArrayList() {
						{
							this.add(tableModel.getTableName());
						}
					});
			
			for (Map<String, Object> column : colList) {
				ColumnModel columnModel = new ColumnModel();
				columnModel.setColumnName((String) column.get("COLUMN_NAME"));
				
				String dataType = (String) column.get("DATA_TYPE");
				if (dataType.equalsIgnoreCase("VARCHAR2")) {
					dataType = "VARCHAR";
				}
				columnModel.setColumnType(dataType);
				columnModel.setNullable((String) column.get("NULLABLE"));
				
				BigDecimal b = (BigDecimal) column.get("DATA_LENGTH");
				columnModel.setCoulmnSize(b.intValue());
				
				String comment = (String)column.get("COMMENTS");
				columnModel.setColumnChineseName(StringUtils.isNotBlank(comment) ? comment : columnModel.getColumnName());
				
				tableModel.getColumnList().add(columnModel);
			}
			
			// mapper
			String outputFilePath = OUTPUT_MAPPER_PATH + tableModel.getTableName2Pascal() + MAPPER_SUFFIX;
			try {
				FreeMarkerManager.getInstance().renderTemplate("MapperTemplate.java", outputFilePath, context, "UTF-8");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			// mapping
			outputFilePath = OUTPUT_MAPPING_PATH + tableModel.getTableName2Pascal() + MAPPING_SUFFIX;
			try {
				FreeMarkerManager.getInstance().renderTemplate("MappingTemplate.xml", outputFilePath, context, "UTF-8");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
			
			// mapping
			outputFilePath = OUTPUT_MAPPING_PATH + tableModel.getTableName2Pascal() + "V" + MAPPING_SUFFIX;
			try {
				FreeMarkerManager.getInstance().renderTemplate("MappingVTemplate.xml", outputFilePath, context, "UTF-8");
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}

		JDBCUtil.close(null, null, conn);
		
		System.out.println("==========完成==========");
	}
	
	public static void main(String[] args) throws SQLException {
		MapperGenerator.generate();
	}
	
}
