package com.adServer.storage;

import java.util.HashMap;
import java.util.Map;

import com.adServer.model.AdModel;

public interface MapStorage extends Storage {
	
	public static Map<String,AdModel> adServerStorage = new HashMap<>();
	
	public static Map<String,AdModel> getDatabase(){	
		return adServerStorage;
	}
}
