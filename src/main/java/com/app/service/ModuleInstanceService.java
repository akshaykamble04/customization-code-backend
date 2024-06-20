package com.app.service;

import java.util.List;

import com.app.entities.ModuleInstance;
import com.app.entities.User;

public interface ModuleInstanceService {

	List<ModuleInstance> getModuleInstancesByUser(User user);

	List<ModuleInstance> getModuleInstances(Long moduleId, User user);

}
