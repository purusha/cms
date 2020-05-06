package it.at.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SinglePageApplicationController {

	@GetMapping("/")
    public String showHome() {
        return "home";
    }
	
}
