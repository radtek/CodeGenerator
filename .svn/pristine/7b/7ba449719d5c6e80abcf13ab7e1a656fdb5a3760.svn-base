/**
 * ${tableModel.tableName2Pascal}Model.java 
 * Copyright(c) 2016 hisign
 * ALL Rights Reserved.
 */
package com.hisign.xcky.model;

import com.hisign.xcky.model.common.BaseModel;

/**
 * <#if tableModel.tableChineseName?exists>${tableModel.tableChineseName}</#if>
 *
 * @author ModelGenerator
 */
public class ${tableModel.tableName2Pascal} extends BaseModel {

    <#list tableModel.columnList as columnModel>
    /**
     * ${columnModel.columnChineseName}
     */
    private ${columnModel.columnTypeMapClassType} ${columnModel.columnName2Camel};

    </#list>

    <#list tableModel.columnList as columnModel>
    /**
     * 获得${columnModel.columnChineseName}
     * 
     * @return ${columnModel.columnChineseName}
     */
    public ${columnModel.columnTypeMapClassType} get${columnModel.columnName2Pascal}() {
        return this.${columnModel.columnName2Camel};
    }

    </#list>

    <#list tableModel.columnList as columnModel>
    /**
     * 设置${columnModel.columnChineseName}
     * 
     * @param ${columnModel.columnName2Camel} ${columnModel.columnChineseName}
     */
    public void set${columnModel.columnName2Pascal}(${columnModel.columnTypeMapClassType} ${columnModel.columnName2Camel}) {
        this.${columnModel.columnName2Camel} = ${columnModel.columnName2Camel};
    }

    </#list>
}