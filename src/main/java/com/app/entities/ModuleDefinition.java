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
public class ModuleDefinition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "moduleDefinition", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ModuleFieldDefinition> fieldDefinitions = new LinkedHashSet<>();
	
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public ModuleDefinition() {
		super();
	}

	public ModuleDefinition(Long id, String name, Set<ModuleFieldDefinition> fieldDefinitions) {
		super();
		this.id = id;
		this.name = name;
		this.fieldDefinitions = fieldDefinitions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ModuleFieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(Set<ModuleFieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ModuleDefinition [id=" + id + ", name=" + name + ", fieldDefinitions=" + fieldDefinitions + "]";
	}
	
	
	

}
