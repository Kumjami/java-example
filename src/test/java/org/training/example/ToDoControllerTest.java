package org.training.example;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mgom on 14/02/17.
 */
public class ToDoControllerTest {

    private HttpServer server;
    private WebTarget target;

    private List<String> createdUuids = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        for (String uuid :
                createdUuids) {
            target.path("todo/" + uuid).request().delete();
        }
        server.stop();
    }

    /**
     * Test to see that a "to do" is created
     */
    @Test
    public void testCreateToDo() {

        // Create request body object
        ToDoModel requestToDo = new ToDoModel();
        requestToDo.description = "testing todo";

        // submit request
        ToDoModel responseMsg = target.path("todo").request().post(Entity.json(requestToDo)).readEntity(ToDoModel.class);

        // add id to the aux ids list
        createdUuids.add(responseMsg.id);

        assertEquals("Should return created object with input description","testing todo", responseMsg.description);
        assertEquals("Created todo should have not been `done`",false, responseMsg.done);
    }
}
