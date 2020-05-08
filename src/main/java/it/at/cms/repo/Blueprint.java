package it.at.cms.repo;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import lombok.Getter;

/*
	@JsonDeserialize(using = ItemDeserializer.class)
 */
public class Blueprint {
	
	@Getter
	private String _id;

	@Getter
	private final Map<String, Object> _properties = new LinkedHashMap<>();
	 
	/* 
		@JsonAnySetter to mark a method for handling additional, unknown properties.
	 */
    @JsonAnySetter
    public void setProperties(String key, Object value) {
        _properties.put(key, value);
    }
    
    public Map<String, Object> getProperties() {
    	return this._properties;
    }
    
    public void setId(String id) {
    	this._id = id;
    }
    
    public String getId() {
    	return this._id;
    }
	
}
