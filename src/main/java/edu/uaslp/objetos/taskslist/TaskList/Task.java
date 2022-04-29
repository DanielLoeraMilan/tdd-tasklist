package edu.uaslp.objetos.taskslist.TaskList;

import edu.uaslp.objetos.taskslist.exception.TaskListException;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private boolean done;

    public Task(String title, String description, LocalDateTime dueDate, boolean done) {
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
        this.done=done;
    }

    public Task() {

    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getTitle(){
        return title;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public LocalDateTime getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate){
        LocalDateTime currentTime = LocalDateTime.now();

        if(dueDate.isBefore(currentTime)){
            throw new TaskListException("Due date is set in the past");
        }
        this.dueDate=dueDate;
    }

    public boolean isDone(){
        return done;
    }

    public void setDone(boolean done){
        this.done = done;
    }
}
