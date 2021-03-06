package com.hisign.model;

import java.util.ArrayList;
import java.util.List;

import com.hisign.util.StringUtil;

/**
 * 表模型
 * 
 * @author Hong
 */
public class TableModel {

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 表中文名称
	 */
	private String tableChineseName = null;

	/**
	 * 列属性列表
	 */
	private List<ColumnModel> columnList = new ArrayList<ColumnModel>();

	/**
	 * 获得表名称(转换为CamelStyle类型)
	 * 
	 * @return 表名称(转换为CamelStyle类型)
	 */
	public String getTableName2Camel() {
		if (tableName.startsWith("T_")) {
			return StringUtil.convertUpperCaseToCamelStyle(tableName.substring(2));
		} else {
			return StringUtil.convertUpperCaseToCamelStyle(tableName);
		}
	}

	/**
	 * 获得表名称(转换为PascalStyle类型)
	 * 
	 * @return 表名称(转换为PascalStyle类型)
	 */
	public String getTableName2Pascal() {
		if (tableName.startsWith("T_")) {
			return StringUtil.convertUpperCaseToPascalStyle(tableName.substring(2));
		} else {
			return StringUtil.convertUpperCaseToPascalStyle(tableName);
		}
	}

	/**
	 * 设置表名称
	 * 
	 * @param tableName 表名称
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * 获得表名称
	 * 
	 * @return 表名称
	 */
	public String getTableName() {
		return this.tableName;
	}

	/**
	 * 设置表中文名称
	 * 
	 * @param tableChineseName 表中文名称
	 */
	public void setTableChineseName(String tableChineseName) {
		this.tableChineseName = tableChineseName;
	}

	/**
	 * 获得表中文名称
	 * 
	 * @return 表中文名称
	 */
	public String getTableChineseName() {
		return this.tableChineseName;
	}

	/**
	 * 设置列属性列表
	 * 
	 * @param columnList 列属性列表
	 */
	public void setColumnList(List columnList) {
		this.columnList = columnList;
	}

	/**
	 * 获得列属性列表
	 * 
	 * @return 列属性列表
	 */
	public List getColumnList() {
		return this.columnList;
	}

}
