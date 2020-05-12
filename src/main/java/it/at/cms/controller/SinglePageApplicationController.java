package it.at.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.at.cms.repo.BlueprintRepository;

@Controller
public class SinglePageApplicationController {

	private final BlueprintRepository repository;

	@Autowired
	public SinglePageApplicationController(BlueprintRepository repository) {
		this.repository = repository;
	}

//	@GetMapping("/blueprint")
//	public Iterable<Blueprint> all() {		
//		return repository.findAll();
//	}
	
	@GetMapping("/")
    public String showHome(Model model) {		
		model.addAttribute("blueprints", repository.findAll());
		
        return "home";
    }
	
}
