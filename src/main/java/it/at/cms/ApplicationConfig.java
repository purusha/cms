package it.at.cms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.at.cms.repo.AssetRepository;
import it.at.cms.repo.BlueprintRepository;
import it.at.cms.repo.FileSystemAssetStorage;
import it.at.cms.repo.FileSystemBlueprintStorage;

@Configuration
public class ApplicationConfig {

	@Bean
	public BlueprintRepository blueprintRepository() {
		return new FileSystemBlueprintStorage();
	}

	@Bean
	public AssetRepository assetRepository() {
		return new FileSystemAssetStorage();
	}
	
}
