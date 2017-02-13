package org.training.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Created by mgom on 9/02/17.
 */
@Path("/todo")
public class ToDoController {

    /**
     * Creates a `to do`
     * @param toDo
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel createToDo (ToDoModel toDo) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        toDosList.addToDo(toDo);
        return toDo;
    }

    @DELETE @Path("/{toDoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel removeToDo (@PathParam("toDoId") final String toDoId) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        return toDosList.removeElement(UUID.fromString(toDoId));
    }

    @PUT @Path("/{toDoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel updateToDo (@PathParam("toDoId") final String toDoId, ToDoModel toDo) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        toDosList.updateElement(UUID.fromString(toDoId), toDo);
        return toDo;
    }

}
