package com.app.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.ModuleDefinition;
import com.app.entities.ModuleFieldDefinition;
import com.app.entities.ModuleFieldInstance;
import com.app.entities.ModuleInstance;
import com.app.entities.User;
import com.app.repo.ModuleDefinitionRepository;
import com.app.repo.ModuleInstanceRepository;
import com.app.repo.UserRepo;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	 @Autowired
	    private ModuleDefinitionRepository moduleDefinitionRepository;

	    @Autowired
	    private ModuleInstanceRepository moduleInstanceRepository;

	    @Autowired
	    private UserRepo userRepository;

	@Override
	public ModuleDefinition createModuleDefinition(ModuleDefinition moduleDefinition,User user) {
		
		System.out.println(moduleDefinition.toString());
		
		Set<ModuleFieldDefinition> list = moduleDefinition.getFieldDefinitions();
		moduleDefinition.setUser(user);
		
		for(ModuleFieldDefinition mfd : list) {
			mfd.setModuleDefinition(moduleDefinition);
		}
		ModuleDefinition m = moduleDefinitionRepository.save(moduleDefinition);
		
		System.out.println(moduleDefinition.toString());
		
		return m;
	}

	@Override
	public List<ModuleDefinition> getAllModuleDefinitions(User user) {
		
		List<ModuleDefinition> list =moduleDefinitionRepository.findByUser(user);

		return list;
	}

	@Override
	public ModuleInstance createModuleInstance(Long moduleDefinitionId, Long userId, Map<String, String> fieldValues) {
		ModuleDefinition moduleDefinition = moduleDefinitionRepository.findById(moduleDefinitionId)
                .orElseThrow(() -> new RuntimeException("ModuleDefinition not found"));

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        ModuleInstance moduleInstance = new ModuleInstance();
        moduleInstance.setModuleDefinition(moduleDefinition);
        moduleInstance.setUser(user);

        Set<ModuleFieldInstance> fieldInstances = new HashSet<>();
        for (ModuleFieldDefinition fieldDefinition : moduleDefinition.getFieldDefinitions()) {
            ModuleFieldInstance fieldInstance = new ModuleFieldInstance();
            fieldInstance.setFieldDefinition(fieldDefinition);
            fieldInstance.setValue(fieldValues.get(fieldDefinition.getKey()));
            fieldInstance.setModuleInstance(moduleInstance);
            fieldInstances.add(fieldInstance);
        }
        moduleInstance.setFieldInstances(fieldInstances);

        return moduleInstanceRepository.save(moduleInstance);
	}

	@Override
	public ModuleDefinition getModuleByModuleIdAndUser(Long moduleId, User user) {
		ModuleDefinition module = moduleDefinitionRepository.getByIdAndUser(moduleId,user);
		return module;
	}

}
