<#list sysDictList as rootDict>
--${rootDict.rootKey} ${rootDict.dictValue} begin
DELETE FROM T_SYS_DICT WHERE ROOT_KEY='${rootDict.rootKey}';
<#list rootDict.sysDictList as sysDict>
INSERT INTO T_SYS_DICT(ID,ROOT_KEY,DICT_KEY,PARENT_KEY,DICT_VALUE,DICT_SPELL,DICT_SORT,SHOW_FLAG,ALLOW_MODIFY,OPEN_FLAG,VERSION,DELETE_FLAG,CREATE_USER_ID,UPDATE_USER_ID,CREATE_TIME,UPDATE_TIME)
VALUES('${sysDict.id}','${sysDict.rootKey}','${sysDict.dictKey}','${sysDict.parentKey}','${sysDict.dictValue}',null,${sysDict.dictSort},'${sysDict.showFlag}','${sysDict.allowModify}','${sysDict.openFlag}',${sysDict.version},'${sysDict.deleteFlag}','ABCDEFGHABCDEFGHABCDEFGH12346157','ABCDEFGHABCDEFGHABCDEFGH12346157',sysdate,sysdate);
</#list>
commit;
--${rootDict.rootKey} ${rootDict.dictValue} end

</#list>