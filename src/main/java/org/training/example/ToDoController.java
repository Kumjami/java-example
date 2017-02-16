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
     * @return toDo
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel createToDo (ToDoModel toDo) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        if(toDo.id == null)
            toDo.id = UUID.randomUUID().toString();

        toDosList.addToDo(toDo);
        return toDo;
    }

    @DELETE @Path("/{toDoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel removeToDo (@PathParam("toDoId") final String toDoId) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        return toDosList.removeElement(toDoId);
    }

    @PUT @Path("/{toDoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDoModel updateToDo (@PathParam("toDoId") final String toDoId, ToDoModel toDo) {
        ToDoListModel toDosList = ToDoListModel.getInstance();
        toDosList.updateElement(toDoId, toDo);
        return toDo;
    }

}
