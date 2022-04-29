package edu.uaslp.objetos.taskslist.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
        super("Task with title 'Hacer ejercicio' not found");
    }

}

