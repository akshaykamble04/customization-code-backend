package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ModuleInstance;
import com.app.entities.User;

public interface ModuleInstanceRepo extends JpaRepository<ModuleInstance, Long> {

	List<ModuleInstance> findByUser(User user);

	List<ModuleInstance> findByModuleDefinitionIdAndUser(Long moduleId, User user);

}
