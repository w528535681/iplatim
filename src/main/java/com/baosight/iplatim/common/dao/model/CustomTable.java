package com.baosight.iplatim.common.dao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标准表结构.
 *
 * @author wy
 * @version 1.0
 */
public class CustomTable {

	//表字段
	public List<Map<String,String>> fieldMaps = new ArrayList<Map<String,String>>();
	
	//数据表名
	public String tableName = "";
	
	//用户schema
	public String schema = "";

	public List<Map<String, String>> getFieldMaps() {
		return fieldMaps;
	}

	public void setFieldMaps(List<Map<String, String>> fieldMaps) {
		this.fieldMaps = fieldMaps;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

}