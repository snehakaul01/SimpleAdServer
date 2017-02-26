package com.adServer.services;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.adServer.dao.DAOFactory;

@WebListener
public class AdServerListener implements ServletContextListener{
 
    public void contextInitialized(ServletContextEvent event) 
    {
      String storageType = event.getServletContext().getInitParameter("storageType");	
	  DAOFactory.setStorage(storageType);
    }


    public void contextDestroyed(ServletContextEvent arg0) 
    {
    
    }

}
