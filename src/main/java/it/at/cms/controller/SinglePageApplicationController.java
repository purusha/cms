package it.at.cms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.at.cms.repo.Asset;
import it.at.cms.repo.AssetRepository;
import it.at.cms.repo.Blueprint;
import it.at.cms.repo.BlueprintRepository;

@Controller
public class SinglePageApplicationController {

	private final BlueprintRepository blueRepository;
	
	private final AssetRepository assetRepository;

	@Autowired
	public SinglePageApplicationController(BlueprintRepository blueRepository, AssetRepository assetRepository) {
		this.blueRepository = blueRepository;
		this.assetRepository = assetRepository;
	}
	
	@GetMapping("/")
    public String showHome(Model model) {		
		model.addAttribute("blueprints", blueRepository.findAll());
		
        return "home";
    }
	
	@GetMapping("/draw")
	public String draw(Model model) {
		return "draw";
	}
	
	@GetMapping("/asset/{id}")
	public String showBlueprint(@PathVariable("id") String id, Model model) {
		final Optional<Blueprint> blueprint = blueRepository.findById(id);
		
		blueprint.ifPresent(b -> {
			model.addAttribute("blueprint", b);
			
			model.addAttribute("assets", assetRepository.findAllByBlueprint(b));	
		});		
		
		return "asset";
	}
	
	@PostMapping("/asset/{id}")
	public String showBlueprint(@PathVariable("id") String id, @RequestBody Asset asset) {
		final Optional<Blueprint> blueprint = blueRepository.findById(id);
		
		blueprint.ifPresent(b -> {
			assetRepository.createToBlueprint(b, asset);
		});
		
		return "redirect:/asset/ + id";
	}
		
}
