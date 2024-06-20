package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ModuleDefinition;
import com.app.entities.User;

public interface ModuleDefinitionRepository extends JpaRepository<ModuleDefinition, Long> {

	List<ModuleDefinition> findByUser(User user);
	
	List<ModuleDefinition> findByUserId(Long userId);

	ModuleDefinition getByIdAndUser(Long moduleId, User user);

}
