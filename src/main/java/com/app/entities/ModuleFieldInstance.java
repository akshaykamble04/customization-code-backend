package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ModuleFieldInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "field_definition_id")
	private ModuleFieldDefinition fieldDefinition;

	@Column(name = "`value`")
	private String value;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "module_instance_id")
	private ModuleInstance moduleInstance;

	public ModuleFieldInstance() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ModuleFieldDefinition getFieldDefinition() {
		return fieldDefinition;
	}

	public void setFieldDefinition(ModuleFieldDefinition fieldDefinition) {
		this.fieldDefinition = fieldDefinition;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ModuleInstance getModuleInstance() {
		return moduleInstance;
	}

	public void setModuleInstance(ModuleInstance moduleInstance) {
		this.moduleInstance = moduleInstance;
	}

	public ModuleFieldInstance(Long id, ModuleFieldDefinition fieldDefinition, String value,
			ModuleInstance moduleInstance) {
		super();
		this.id = id;
		this.fieldDefinition = fieldDefinition;
		this.value = value;
		this.moduleInstance = moduleInstance;
	}

	
}
