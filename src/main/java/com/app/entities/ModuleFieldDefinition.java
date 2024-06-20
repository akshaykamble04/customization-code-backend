package com.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.mysql.cj.x.protobuf.MysqlxResultset.ColumnMetaData.FieldType;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ModuleFieldDefinition {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`key`")
    private String key;

    @Enumerated(EnumType.STRING)
    private FieldType fieldType;

    @JsonIgnore
    @ManyToOne
  @JoinColumn(name = "module_definition_id")
    private ModuleDefinition moduleDefinition;

	public ModuleFieldDefinition() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public ModuleDefinition getModuleDefinition() {
		return moduleDefinition;
	}

	public void setModuleDefinition(ModuleDefinition moduleDefinition) {
		this.moduleDefinition = moduleDefinition;
	}

	public ModuleFieldDefinition(Long id, String key, FieldType fieldType, ModuleDefinition moduleDefinition) {
		super();
		this.id = id;
		this.key = key;
		this.fieldType = fieldType;
		this.moduleDefinition = moduleDefinition;
	}
    
    

}
