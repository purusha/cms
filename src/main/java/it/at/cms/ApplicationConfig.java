package it.at.cms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

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
	
	/*
	 * utilizzato per loggare request e response in modo parsabile
	 */
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    final CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(true);
	    loggingFilter.setMaxPayloadLength(64000);
	    
	    return loggingFilter;
	}
	
	
}
