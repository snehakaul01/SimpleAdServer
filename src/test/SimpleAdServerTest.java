package test;


import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.adServer.dao.DAOFactory;
import com.adServer.exception.AdExpiredException;
import com.adServer.exception.PartnerAlreadyExistsException;
import com.adServer.exception.PartnerNotExistsException;
import com.adServer.model.AdModel;
import com.adServer.services.AdServices;

public class SimpleAdServerTest extends JerseyTest {

    @Override
    public Application configure() {
    	DAOFactory.setStorage("MAP");
        return new ResourceConfig(AdServices.class);
    }

   @Test
    public void testCreateAd(){
        AdModel adModel = new AdModel("Partner1", 100,"Partner Content 1");
        Response output = target("/Ad")
                .request().accept(MediaType.APPLICATION_JSON)
                .post(Entity.json(adModel));
        assertEquals("Partner Created", 200, output.getStatus());
    }
    
    @Test
    public void testCreateAd_PartnerAlreadyExists(){
        AdModel adModel = new AdModel("Partner2", 100,"Partner Content 2");
        Response output = target("/Ad")
                .request()
                .post(Entity.entity(adModel,MediaType.APPLICATION_JSON));
        output = target("/Ad")
                .request()
                .post(Entity.entity(adModel,MediaType.APPLICATION_JSON));
        assertEquals("PartnerAlreadyExists", 400, output.getStatus());
        assertEquals("PartnerAlreadyExists", "Partner Id Already exists", output.readEntity(String.class));
    }
    
   @Test
    public void testGetAdDetails() {
       AdModel adModel = new AdModel("Partner3", 100,"Partner Content 3");
       Response output = target("/Ad")
               .request().accept(MediaType.APPLICATION_JSON)
               .post(Entity.json(adModel));
       
        output = target("/Ad/Partner3").request().get();
        assertEquals("Fetch Ad Details", 200, output.getStatus());
        assertEquals("Partner1 details are fetched", "Partner3", (output.readEntity(AdModel.class)).getPartner_id());
    }
    
   @Test
    public void testGetAdDetails_AdExpired() { 
       AdModel adModel = new AdModel("Partner4", 0,"Partner Content 4");
       Response output = target("/Ad")
               .request()
               .post(Entity.entity(adModel,MediaType.APPLICATION_JSON));
        output = target("/Ad/Partner4").request().get();
        assertEquals("Failure 400", 400, output.getStatus());
        assertEquals("AdExpired", "No active ad campaigns exist for the specified partner", output.readEntity(String.class));
    }
    
   @Test
    public void testGetAdDetails_NotExists() { 
        Response output = target("/Ad/Partner5").request().get();
        assertEquals("Failure 400", 400, output.getStatus());
        assertEquals("PartnerNotExists", "Partner Id does not exists", output.readEntity(String.class));
    }
    
}    
