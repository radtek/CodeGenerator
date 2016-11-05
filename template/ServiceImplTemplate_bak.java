/**
 * ${tableModel.tableName2Pascal}Service.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <#if tableModel.tableChineseName?exists>${tableModel.tableChineseName}<#else>${tableModel.tableName2Pascal}</#if>Service实现
 *
 * @author ServiceGenerator
 */
@Service("${tableModel.tableName2Camel}Service")
public class ${tableModel.tableName2Pascal}ServiceImpl implements ${tableModel.tableName2Pascal}Service {
	
	@Resource
    private ${tableModel.tableName2Pascal}Mapper ${tableModel.tableName2Camel}Mapper;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ${tableModel.tableName2Pascal} getById(String id) {
    	return ${tableModel.tableName2Camel}Mapper.getById(id);
    }

    /**
     * 根据id删除(物理删除)
     * @param id
     */
    @Override
    public void deleteById(String id) {
    	${tableModel.tableName2Camel}Mapper.deleteById(id);
    }

    /**
     * 根据id删除(逻辑删除)
     * @param id
     */
    @Override
    public int deleteLogicById(String id) {
    	${tableModel.tableName2Camel}Mapper.deleteLogicById(id);
    }

    /**
     * 根据id更新
     * @param ${tableModel.tableName2Camel}
     */
    @Override
    public int updateById(${tableModel.tableName2Pascal} ${tableModel.tableName2Camel}) {
    	return ${tableModel.tableName2Camel}Mapper.updateById(${tableModel.tableName2Camel});
    }

    /**
     * 新增
     * @param ${tableModel.tableName2Camel}
     */
    @Override
    public void add(${tableModel.tableName2Pascal} ${tableModel.tableName2Camel}) {
    	${tableModel.tableName2Camel}Mapper.add(${tableModel.tableName2Camel});
    }

    /**
     * 批量新增
     * @param list 对象列表
     */
    @Override
    public void addBatch(List<${tableModel.tableName2Pascal}> list) {
    	if (list == null) {
    		return;
    	}
    	
    	for (${tableModel.tableName2Pascal} ${tableModel.tableName2Camel} : list) {
    		add(${tableModel.tableName2Camel});
    	}
    }

    /**
     * 查询
     * @param ${tableModel.tableName2Camel}
     */
    @Override
    public List<${tableModel.tableName2Pascal}> query(${tableModel.tableName2Pascal} ${tableModel.tableName2Camel}) {
        return ${tableModel.tableName2Camel}Mapper.query(${tableModel.tableName2Camel});
    }
    
}
