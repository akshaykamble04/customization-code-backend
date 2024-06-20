package com.app.controller;

import java.security.Principal;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.ModuleDefinition;
import com.app.entities.ModuleInstance;
import com.app.entities.User;
import com.app.repo.UserRepo;
import com.app.request.ModuleInstanceRequest;
import com.app.service.ModuleInstanceService;
import com.app.service.ModuleService;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleController {
	
	@Autowired
    private ModuleService moduleService;
	
	@Autowired
	private ModuleInstanceService moduleInstanceService;
	
	@Autowired
	private UserRepo userRepo;
	
	
	 @GetMapping("/definitions")
	    public ResponseEntity<List<ModuleDefinition>> getModuleDefinitions(Principal principal) {
	    	
	    	User user = userRepo.findByEmail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + principal.getName()));
	        List<ModuleDefinition> moduleDefinitions = moduleService.getAllModuleDefinitions(user);
	        return ResponseEntity.ok(moduleDefinitions);
	    }
	 
	 @GetMapping("/{moduleId}/definitions")
	 public ResponseEntity<ModuleDefinition> getModuleByModuleIdAndUser(@PathVariable Long moduleId,Principal principal){
		 User user = userRepo.findByEmail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + principal.getName()));
		 ModuleDefinition module = moduleService.getModuleByModuleIdAndUser(moduleId,user);
		 
		 if(module != null)
			 return ResponseEntity.ok(module);
		 else
			 return ResponseEntity.notFound().build();
		 
	 }

    @PostMapping("/definitions")
    public ResponseEntity<ModuleDefinition> createModuleDefinition(@RequestBody ModuleDefinition moduleDefinition,Principal principal) {
    	User user = userRepo.findByEmail(principal.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + principal.getName()));
        ModuleDefinition createdDefinition = moduleService.createModuleDefinition(moduleDefinition,user);
        return ResponseEntity.ok(createdDefinition);
    }
    
    @GetMapping("/instances")
    public ResponseEntity<List<ModuleInstance>> getModuleInstanceByUser(Principal principal){
    	User user = userRepo.findByEmail(principal.getName()).orElseThrow(()->new UsernameNotFoundException("User not found username: "+principal.getName()));
    	List<ModuleInstance> instances = moduleInstanceService.getModuleInstancesByUser(user);
    	return ResponseEntity.ok(instances);
    	
    }
    
    @GetMapping("/{moduleId}/instances")
    public ResponseEntity<List<ModuleInstance>> getModuleInstances(@PathVariable Long moduleId,Principal principal){
    	User user = userRepo.findByEmail(principal.getName()).orElseThrow(()->new UsernameNotFoundException("User not found username: "+principal.getName()));
    	List<ModuleInstance> instances = moduleInstanceService.getModuleInstances(moduleId,user);
    	System.out.println("instances: "+instances.toString());
    	return ResponseEntity.ok(instances);
    	
    }

    @PostMapping("/instances")
    public ResponseEntity<ModuleInstance> createModuleInstance(
            @RequestBody ModuleInstanceRequest moduleInstanceRequest,Principal principal) {
    	User user = userRepo.findByEmail(principal.getName()).orElseThrow(()->new UsernameNotFoundException("User not found username: "+principal.getName()));
    	Long userId = user.getId();
        ModuleInstance createdInstance = moduleService.createModuleInstance(
                moduleInstanceRequest.getModuleDefinitionId(),
                userId,
                moduleInstanceRequest.getFieldValues());
        return ResponseEntity.ok(createdInstance);
    }

   
    


}
