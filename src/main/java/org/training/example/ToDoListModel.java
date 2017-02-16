package org.training.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mgom on 10/02/17.
 */
public class ToDoListModel {
    private Map<String, ToDoModel> toDoList = new ConcurrentHashMap<>();
    private static ToDoListModel instance = new ToDoListModel();

    private ToDoListModel() {}

    public void addToDo(ToDoModel toDo){
        toDoList.put(toDo.id, toDo);
    }

    public List<ToDoModel> getList() {
        return new ArrayList<>(toDoList.values());
    }

    public ToDoModel removeElement(String id) {
        return toDoList.remove(id);
    }

    public static ToDoListModel getInstance() {
        return instance;
    }

    public ToDoModel updateElement(String uuid, ToDoModel toDo) {
        toDo.id = uuid;
        return toDoList.put(uuid, toDo);
    }
}
