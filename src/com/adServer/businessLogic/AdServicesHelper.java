package com.adServer.businessLogic;

import com.adServer.dao.DAOFactory;
import com.adServer.exception.AdExpiredException;
import com.adServer.exception.PartnerAlreadyExistsException;
import com.adServer.exception.PartnerNotExistsException;
import com.adServer.model.AdModel;

public class AdServicesHelper {

	 public void saveAd(AdModel adModel) throws PartnerAlreadyExistsException{
		 DAOFactory.getAdDAO().saveAd(adModel);
	 }

	public AdModel getAd(String partnerId)throws AdExpiredException ,PartnerNotExistsException {
		 return DAOFactory.getAdDAO().getAd(partnerId);
	}
}
