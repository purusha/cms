package it.at.cms.repo;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    //XXX used inside project 
    @JsonIgnore
    public Map<String, Object> getProperties() {
    	return this._properties;
    }
    
    //XXX used inside project
    @JsonIgnore
    public void setId(String id) {
    	this._id = id;
    }
    
    //XXX used inside project
    @JsonIgnore
    public String getId() {
    	return this._id;
    }
	
}
