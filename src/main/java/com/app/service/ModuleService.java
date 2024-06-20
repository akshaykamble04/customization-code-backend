package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.entities.ModuleDefinition;
import com.app.entities.ModuleInstance;
import com.app.entities.User;

public interface ModuleService {

	
	public ModuleDefinition createModuleDefinition(ModuleDefinition moduleDefinition,User user);
	
	public List<ModuleDefinition> getAllModuleDefinitions(User user);
	
	public ModuleInstance createModuleInstance(Long moduleDefinitionId, Long userId, Map<String, String> fieldValues);

	public ModuleDefinition getModuleByModuleIdAndUser(Long moduleId, User user);
	
	
}
