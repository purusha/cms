package it.at.cms.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import it.at.cms.repo.Blueprint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BlueprintValidator {

	public boolean isValid(Blueprint b) {	
		
		final Map<String, Object> properties = b.getProperties();
		
		//XXX ci deve essere almeno un campo
		if (properties.keySet().isEmpty()) {
			return false;
		}
		
		//XXX le chiavi non devono iniziare con "_"
		boolean anyMatch = properties.keySet().stream().anyMatch(_key -> _key.startsWith("_"));
		if (anyMatch) {
			return false;
		}
		
		properties.entrySet().forEach(entry -> {
			log.info("{} => [{}] = {}", entry.getKey(), entry.getValue().getClass().getName(), entry.getValue());
		});
		
		return true;
	}		

}
