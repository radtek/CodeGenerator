/**
 * SysDictModel.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.model;

import java.util.ArrayList;
import java.util.List;



/**
 * 系统字典信息
 *
 * @author ModelGenerator
 */
public class SysDict extends BaseModel {
	
	private List<SysDict> sysDictList = new ArrayList<SysDict>();

    /**
     * 字典信息ID
     */
    private String id;

    /**
     * 根节点
     */
    private String rootKey;

    /**
     * 字典代码
     */
    private String dictKey;

    /**
     * 父级字典代码
     */
    private String parentKey;

    /**
     * 字典中文值
     */
    private String dictValue;

    /**
     * 字典拼音
     */
    private String dictSpell;

    /**
     * 排序
     */
    private Integer dictSort;

    /**
     * 是否显示(SFDM)
     */
    private String showFlag;

    /**
     * 允许修改(SFDM)
     */
    private String allowModify;

    /**
     * 是否启用(SFDM)
     */
    private String openFlag;

    /**
     * 删除标识(SFDM)
     */
    private String deleteFlag;

    /**
     * 创建人ID
     */
    private String createUserId;

    /**
     * 修改人ID
     */
    private String updateUserId;

    /**
     * 创建时间
     */
    private java.util.Date createTime;

    /**
     * 修改时间
     */
    private java.util.Date updateTime;


    /**
     * 获得字典信息ID
     * 
     * @return 字典信息ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * 获得根节点
     * 
     * @return 根节点
     */
    public String getRootKey() {
        return this.rootKey;
    }

    /**
     * 获得字典代码
     * 
     * @return 字典代码
     */
    public String getDictKey() {
        return this.dictKey;
    }

    /**
     * 获得父级字典代码
     * 
     * @return 父级字典代码
     */
    public String getParentKey() {
        return this.parentKey;
    }

    /**
     * 获得字典中文值
     * 
     * @return 字典中文值
     */
    public String getDictValue() {
        return this.dictValue;
    }

    /**
     * 获得字典拼音
     * 
     * @return 字典拼音
     */
    public String getDictSpell() {
        return this.dictSpell;
    }

    /**
     * 获得排序
     * 
     * @return 排序
     */
    public Integer getDictSort() {
        return this.dictSort;
    }

    /**
     * 获得是否显示(SFDM)
     * 
     * @return 是否显示(SFDM)
     */
    public String getShowFlag() {
        return this.showFlag;
    }

    /**
     * 获得允许修改(SFDM)
     * 
     * @return 允许修改(SFDM)
     */
    public String getAllowModify() {
        return this.allowModify;
    }

    /**
     * 获得是否启用(SFDM)
     * 
     * @return 是否启用(SFDM)
     */
    public String getOpenFlag() {
        return this.openFlag;
    }

    /**
     * 获得删除标识(SFDM)
     * 
     * @return 删除标识(SFDM)
     */
    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    /**
     * 获得创建人ID
     * 
     * @return 创建人ID
     */
    public String getCreateUserId() {
        return this.createUserId;
    }

    /**
     * 获得修改人ID
     * 
     * @return 修改人ID
     */
    public String getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * 获得创建时间
     * 
     * @return 创建时间
     */
    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 获得修改时间
     * 
     * @return 修改时间
     */
    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }


    /**
     * 设置字典信息ID
     * 
     * @param id 字典信息ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 设置根节点
     * 
     * @param rootKey 根节点
     */
    public void setRootKey(String rootKey) {
        this.rootKey = rootKey;
    }

    /**
     * 设置字典代码
     * 
     * @param dictKey 字典代码
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    /**
     * 设置父级字典代码
     * 
     * @param parentKey 父级字典代码
     */
    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    /**
     * 设置字典中文值
     * 
     * @param dictValue 字典中文值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    /**
     * 设置字典拼音
     * 
     * @param dictSpell 字典拼音
     */
    public void setDictSpell(String dictSpell) {
        this.dictSpell = dictSpell;
    }

    /**
     * 设置排序
     * 
     * @param dictSort 排序
     */
    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    /**
     * 设置是否显示(SFDM)
     * 
     * @param showFlag 是否显示(SFDM)
     */
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    /**
     * 设置允许修改(SFDM)
     * 
     * @param allowModify 允许修改(SFDM)
     */
    public void setAllowModify(String allowModify) {
        this.allowModify = allowModify;
    }

    /**
     * 设置是否启用(SFDM)
     * 
     * @param openFlag 是否启用(SFDM)
     */
    public void setOpenFlag(String openFlag) {
        this.openFlag = openFlag;
    }

    /**
     * 设置删除标识(SFDM)
     * 
     * @param deleteFlag 删除标识(SFDM)
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 设置创建人ID
     * 
     * @param createUserId 创建人ID
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 设置修改人ID
     * 
     * @param updateUserId 修改人ID
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime 创建时间
     */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 设置修改时间
     * 
     * @param updateTime 修改时间
     */
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

	public List<SysDict> getSysDictList() {
		return sysDictList;
	}

	public void setSysDictList(List<SysDict> sysDictList) {
		this.sysDictList = sysDictList;
	}

}