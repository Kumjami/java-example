package org.training.example;

import java.util.UUID;

/**
 * Created by mgom on 10/02/17.
 */
public class ToDoModel {
    public String description;
    public boolean done = false;
    public UUID id = UUID.randomUUID();

    @Override
    public String toString() {
        return String.format("ToDo: %s Done: %s Description: %s", id, done, description);
    }

}
