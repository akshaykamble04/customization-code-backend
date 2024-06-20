package com.app.request;

import java.util.Map;

public class ModuleInstanceRequest {

	private Long moduleDefinitionId;
	//private Long userId;
	private Map<String, String> fieldValues;

	public ModuleInstanceRequest() {
		super();
	}

	public ModuleInstanceRequest(Long moduleDefinitionId, Long userId, Map<String, String> fieldValues) {
		super();
		this.moduleDefinitionId = moduleDefinitionId;
		//this.userId = userId;
		this.fieldValues = fieldValues;
	}

	public Long getModuleDefinitionId() {
		return moduleDefinitionId;
	}

	public void setModuleDefinitionId(Long moduleDefinitionId) {
		this.moduleDefinitionId = moduleDefinitionId;
	}

	

	public Map<String, String> getFieldValues() {
		return fieldValues;
	}

	public void setFieldValues(Map<String, String> fieldValues) {
		this.fieldValues = fieldValues;
	}

}
