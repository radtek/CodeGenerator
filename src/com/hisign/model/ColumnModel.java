package com.hisign.model;

import com.hisign.util.DatabaseUtil;
import com.hisign.util.StringUtil;

/**
 * 字段模型
 * 
 * @author Hong
 */
public class ColumnModel {

	/**
	 * 列名
	 */
	private String columnName;

	/**
	 * 中文名
	 */
	private String columnChineseName;

	/**
	 * 字段类型
	 */
	private String columnType;

	/**
	 * 字段的长度
	 */
	private int coulmnSize;

	/**
	 * 是否是主键
	 */
	private boolean isPK = false;

	/**
	 * 是否非空
	 */
	private String nullable;

	/**
	 * 备注
	 */
	private String remark = null;
	
	/**
	 * 默认值
	 */
	private String dataDefault = null;

	/**
	 * 获得列名(转换为CamelStyle类型)
	 * 
	 * @return 列名(转换为CamelStyle类型)
	 */
	public String getColumnName2Camel() {
		return StringUtil.convertUpperCaseToCamelStyle(this.columnName);
	}

	/**
	 * 获得列名(转换为PascalStyle类型)
	 * 
	 * @return 列名(转换为PascalStyle类型)
	 */
	public String getColumnName2Pascal() {
		return StringUtil.convertUpperCaseToPascalStyle(this.columnName);
	}

	/**
	 * 根据字段类型返回对应的java类型
	 * 
	 * @return java类型
	 * @throws Exception
	 */
	public String getColumnTypeMapClassType() throws Exception {
		return DatabaseUtil.getClassTypeByColumnType(this.columnType);
	}

	/**
	 * 设置列名
	 * 
	 * @param columnName 列名
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * 获得列名
	 * 
	 * @return 列名
	 */
	public String getColumnName() {
		return this.columnName;
	}

	/**
	 * 设置中文名
	 * 
	 * @param columnChineseName 中文名
	 */
	public void setColumnChineseName(String columnChineseName) {
		this.columnChineseName = columnChineseName;
	}

	/**
	 * 获得中文名
	 * 
	 * @return 中文名
	 */
	public String getColumnChineseName() {
		return this.columnChineseName;
	}

	/**
	 * 设置字段类型
	 * 
	 * @param columnType 字段类型
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	/**
	 * 获得字段类型
	 * 
	 * @return 字段类型
	 */
	public String getColumnType() {
		return this.columnType;
	}

	/**
	 * 设置字段的长度
	 * 
	 * @param coulmnSize 字段的长度
	 */
	public void setCoulmnSize(int coulmnSize) {
		this.coulmnSize = coulmnSize;
	}

	/**
	 * 获得字段的长度
	 * 
	 * @return 字段的长度
	 */
	public int getCoulmnSize() {
		return this.coulmnSize;
	}

	/**
	 * 设置是否是主键
	 * 
	 * @param isPK 是否是主键
	 */
	public void setIsPK(boolean isPK) {
		this.isPK = isPK;
	}

	/**
	 * 获得是否是主键
	 * 
	 * @return 是否是主键
	 */
	public boolean getIsPK() {
		return this.isPK;
	}

	/**
	 * 设置备注
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获得备注
	 * 
	 * @return 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	public String getNullable() {
		return nullable;
	}

	public void setNullable(String nullable) {
		this.nullable = nullable;
	}

	public String getDataDefault() {
		return dataDefault;
	}

	public void setDataDefault(String dataDefault) {
		this.dataDefault = dataDefault;
	}

	public void setPK(boolean isPK) {
		this.isPK = isPK;
	}

}
