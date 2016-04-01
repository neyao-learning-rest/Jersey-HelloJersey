package org.oursight.jersey.hello;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
    	
        // create the client
//        Client c = ClientBuilder.newClient();
//        Client c = ClientBuilder.newClient().register(new JacksonFeature());

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
    	Client c = ClientBuilder.newClient();
    	target = c.target(Main.BASE_URI);
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
    
    @Test
    public void testHello() {
    	Client c = ClientBuilder.newClient().register(new JacksonFeature());
    	target = c.target(Main.BASE_URI);
        Hello hello = target.path("myresource/a-example-userName").request(MediaType.APPLICATION_JSON).get(Hello.class);
        System.out.println(hello);
        assertNotNull(hello);
    }
    
    @Test
    public void testHelloBatch() {
    	List<Hello> list = new ArrayList<Hello>();
    	list.add(new Hello(1, "foo"));
    	list.add(new Hello(2, "bar"));
    	list.add(new Hello(3, "goo"));
    	
    	Client c = ClientBuilder.newClient().register(new JacksonFeature());
    	target = c.target(Main.BASE_URI);
//        List<Hello> result = target.path("myresource/hello_batch").request(MediaType.APPLICATION_JSON).post(Entity.entity(list, MediaType.APPLICATION_JSON));
        List result = target.path("myresource/hello_batch").request(MediaType.APPLICATION_JSON).post(Entity.entity(list, MediaType.APPLICATION_JSON), List.class);
        System.out.println(result);
        assertNotNull(result);
    }
}
