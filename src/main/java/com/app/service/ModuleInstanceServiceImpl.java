package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.ModuleInstance;
import com.app.entities.User;
import com.app.repo.ModuleInstanceRepo;

@Service
public class ModuleInstanceServiceImpl implements ModuleInstanceService {
	
	@Autowired
	private ModuleInstanceRepo moduleInstanceRepo;

	@Override
	public List<ModuleInstance> getModuleInstancesByUser(User user) {
		return moduleInstanceRepo.findByUser(user);
	}

	@Override
	public List<ModuleInstance> getModuleInstances(Long moduleId, User user) {
		List<ModuleInstance> instances = moduleInstanceRepo.findByModuleDefinitionIdAndUser(moduleId,user);
		return instances;
	}

}
