package com.LATAM.birthdate.dto;

import java.util.HashMap;

public class Poet {
	
	private String name;
    private String url;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    
	@Override
	public String toString() {
		HashMap<String, Object> poet = new HashMap<String, Object>();
		poet.put("title", this.name);
		poet.put("url", this.url);
		return poet.toString();
	}
	

}
