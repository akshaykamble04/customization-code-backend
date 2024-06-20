package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ModuleInstance;

public interface ModuleInstanceRepository extends JpaRepository<ModuleInstance, Long> {

}
