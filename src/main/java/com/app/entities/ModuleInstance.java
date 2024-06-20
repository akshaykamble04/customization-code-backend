package com.app.entities;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ModuleInstance {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	//@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "module_definition_id")
    private ModuleDefinition moduleDefinition;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

   // @JsonIgnore
    @OneToMany(mappedBy = "moduleInstance", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ModuleFieldInstance> fieldInstances = new LinkedHashSet<>();

	public ModuleInstance() {
		super();
	}

	public ModuleInstance(Long id, ModuleDefinition moduleDefinition, User user,
			Set<ModuleFieldInstance> fieldInstances) {
		super();
		this.id = id;
		this.moduleDefinition = moduleDefinition;
		this.user = user;
		this.fieldInstances = fieldInstances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModuleDefinition getModuleDefinition() {
		return moduleDefinition;
	}

	public void setModuleDefinition(ModuleDefinition moduleDefinition) {
		this.moduleDefinition = moduleDefinition;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ModuleFieldInstance> getFieldInstances() {
		return fieldInstances;
	}

	public void setFieldInstances(Set<ModuleFieldInstance> fieldInstances) {
		this.fieldInstances = fieldInstances;
	}
    
    

}
