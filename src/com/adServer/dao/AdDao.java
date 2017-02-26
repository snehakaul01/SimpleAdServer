package com.adServer.dao;

import com.adServer.exception.AdExpiredException;
import com.adServer.exception.PartnerAlreadyExistsException;
import com.adServer.exception.PartnerNotExistsException;
import com.adServer.model.AdModel;

public abstract class AdDao  {

	public abstract void saveAd(AdModel adModel) throws PartnerAlreadyExistsException;
	public abstract AdModel getAd(String partnerId) throws AdExpiredException, PartnerNotExistsException;

}
