package org.oursight.jersey.hello;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayHello(@PathParam("name") String name) {
		return new Hello(1000, name);
    	
    }
    
    @POST
    @Path("/hello")
    @Produces(MediaType.APPLICATION_JSON)
    public Hello sayHello(Hello hello) {
		return hello;
    	
    }
    
    /**
     * show how to receive a json array and convert into List
     * @param hello
     * @return
     */
    @POST
    @Path("/hello_batch")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hello> batchSayHello(List<Hello> hellos) {
		return hellos;
    	
    }
    
    
    
}
