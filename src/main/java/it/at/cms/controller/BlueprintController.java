package it.at.cms.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.at.cms.repo.Blueprint;
import it.at.cms.repo.BlueprintRepository;

@RestController
public class BlueprintController {
	
	private final BlueprintRepository repository;

	@Autowired
	public BlueprintController(BlueprintRepository repository) {
		this.repository = repository;		
	}

	@GetMapping("/blueprint")
	public Iterable<Blueprint> all() {		
		return repository.findAll();
	}

	@PostMapping("/blueprint")
	public Blueprint create(@RequestBody Blueprint b) {
		return repository.save(b);
	}

	@GetMapping("/blueprint/{id}")
	public Blueprint one(@PathVariable String id) {
		return repository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}

	@PutMapping("/blueprint/{id}")
	public Blueprint edit(@RequestBody Blueprint b, @PathVariable String id) {
//		return repository.findById(id).map(employee -> {
//			employee.setName(newEmployee.getName());
//			employee.setRole(newEmployee.getRole());
//			return repository.save(employee);
//		}).orElseGet(() -> {
//			newEmployee.setId(id);
//			return repository.save(newEmployee);
//		});
		return null;
	}

	@DeleteMapping("/blueprint/{id}")
	public void delete(@PathVariable String id) {
		repository.deleteById(id);
	}
}
