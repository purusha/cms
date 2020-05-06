package it.at.cms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.at.cms.repo.BlueprintRepository;
import it.at.cms.repo.FileSystemStorage;

@Configuration
public class ApplicationConfig {

	@Bean
	public BlueprintRepository blueprintRepository() {
		return new FileSystemStorage();
	}
	
}
