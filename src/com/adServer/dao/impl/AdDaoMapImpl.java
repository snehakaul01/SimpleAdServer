package com.adServer.dao.impl;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.adServer.dao.AdDao;
import com.adServer.exception.AdExpiredException;
import com.adServer.exception.PartnerAlreadyExistsException;
import com.adServer.exception.PartnerNotExistsException;
import com.adServer.model.AdModel;
import com.adServer.storage.MapStorage;

public  class AdDaoMapImpl extends AdDao {
	Map<String,AdModel> storage = MapStorage.adServerStorage;
	 
	 public void saveAd(AdModel adModel) 
			 throws PartnerAlreadyExistsException{
		 String partnerId = adModel.getPartner_id();
		 if(storage.get(partnerId)!=null) 
			 throw new PartnerAlreadyExistsException();
		 adModel.setCampaignCreationTime(System.currentTimeMillis());
		 storage.put(partnerId, adModel);
		 System.out.println("storage:  "+storage);
	 }

	@Override
	public AdModel getAd(String partnerId) throws AdExpiredException,PartnerNotExistsException {
		AdModel adModel = storage.get(partnerId);
		if(adModel == null) 
			throw new PartnerNotExistsException();
		if((adModel.getCampaignCreationTime()+TimeUnit.SECONDS.toMillis(adModel.getDuration())) <
				System.currentTimeMillis())
			throw new AdExpiredException();
		return adModel;
			
	}

}
