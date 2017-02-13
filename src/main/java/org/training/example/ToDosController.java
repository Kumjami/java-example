package org.training.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "todos" path)
 */
@Path("todos")
public class ToDosController {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDoModel> getList() {
        ToDoListModel toDoList = ToDoListModel.getInstance();
        return toDoList.getList();
    }

}
