package com.adServer.dao;

import com.adServer.dao.impl.AdDaoMapImpl;

public class DAOFactory {
	static private String storage;	
	
	public static void setStorage(String storageType){
		storage = storageType;
	}
	
	public static AdDao getAdDAO(){
		AdDao adDAO = null;
		if(storage.equalsIgnoreCase("MAP"))
			adDAO = new AdDaoMapImpl();
		return adDAO;
	}
	
}
