package org.acme.resource;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.acme.model.Person;
import org.acme.service.PersonService;
import org.acme.utils.PageUtils;
import org.acme.utils.RequestExtractParams;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import io.vertx.core.http.HttpServerRequest;

@Tag(name = "Person")
@Path("/v1/person")
public class PersonResource {
	
	@Inject
	private PersonService service;
	@Context
	HttpServerRequest request;
	
	
	@GET
	@Path("/params")
	public List<Person>  findByParams() { 
		
		var attributesAllowed = Arrays.asList("firstName", "lastName", "age","id");
		var sortingAllowed = Arrays.asList("firstName" , "age");
				
		return service.findByParams(
				RequestExtractParams.extractAttributes(request, attributesAllowed), 
				RequestExtractParams.extractSorting(request, sortingAllowed),
				PageUtils.getPage(request));
	}

}
