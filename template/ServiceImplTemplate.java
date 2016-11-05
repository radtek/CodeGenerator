/**
 * ${tableModel.tableName2Pascal}Service.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.service;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.hisign.xcky.api.persist.Mapper;
import com.hisign.xcky.service.impl.BaseServiceImpl;

/**
 * <#if tableModel.tableChineseName?exists>${tableModel.tableChineseName}<#else>${tableModel.tableName2Pascal}</#if>Service实现
 *
 * @author ServiceGenerator
 */
@Path("/${tableModel.tableName2Camel}")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({ContentType.APPLICATION_JSON_UTF_8})
@Service("${tableModel.tableName2Camel}Service")
@Transactional
public class ${tableModel.tableName2Pascal}ServiceImpl extends BaseServiceImpl<${tableModel.tableName2Pascal}> implements ${tableModel.tableName2Pascal}Service {
	
	@Resource
    private ${tableModel.tableName2Pascal}Mapper ${tableModel.tableName2Camel}Mapper;

    @Override
	public Mapper<${tableModel.tableName2Pascal}> getMapper() {
		return ${tableModel.tableName2Camel}Mapper;
	}
    
}
