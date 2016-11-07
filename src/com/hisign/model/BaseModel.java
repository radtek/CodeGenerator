package com.hisign.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务Model基类
 * 
 * @author Hong
 */
public class BaseModel implements Serializable {

	/**
	 * 主键ID
	 */
	private String id;

	/**
	 * 记录版本号
	 */
	private String version;

	/**
	 * 删除标识
	 */
	private String deleteFlag;

	/**
	 * 创建用户ID
	 */
	private String createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 修改用户ID
	 */
	private String updateUserId;

	/**
	 * 修改时间
	 */
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
