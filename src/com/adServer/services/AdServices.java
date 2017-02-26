package com.adServer.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.adServer.businessLogic.AdServicesHelper;
import com.adServer.exception.AdExpiredException;
import com.adServer.exception.PartnerAlreadyExistsException;
import com.adServer.exception.PartnerNotExistsException;
import com.adServer.model.AdModel;

@Path("/Ad")
public class AdServices {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{partnerId}")
  public Response getAdDetails(@PathParam("partnerId") String id) {
	  AdServicesHelper adHelper = new AdServicesHelper();
	  AdModel adModel = null;
	  try {
		  adModel =adHelper.getAd(id);
		} catch (PartnerNotExistsException | AdExpiredException e) {
		      return Response.status(400).entity(e.getMessage()).build();
		}
      return Response.status(200).entity(adModel).build();
  }
 

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createAd(AdModel parameters) {
	  AdServicesHelper adHelper = new AdServicesHelper();
	  try {
		adHelper.saveAd(parameters);
	} catch (PartnerAlreadyExistsException e) {
	      return Response.status(400).entity(e.getMessage()).build();
	}
      return Response.status(200).entity("Success").build();
  }

}
