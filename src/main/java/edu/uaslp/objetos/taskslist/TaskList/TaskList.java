package edu.uaslp.objetos.taskslist.TaskList;

import edu.uaslp.objetos.taskslist.exception.TaskNotFoundException;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

public class TaskList {

    LinkedList<Task> taskLinkedList = new LinkedList<>();

    public int getSize() {
        return taskLinkedList.size();
    }

    public void add(Task task) {
        taskLinkedList.add(task);
    }

    public void remove(Task task) {
        taskLinkedList.remove(task);
    }

    public Task find(String title) {
        int size = taskLinkedList.size();
        for (Task task : taskLinkedList) {
            if (Objects.equals(title, task.getTitle())) {
                return task;
            }
        }
        throw new TaskNotFoundException();
    }

    public void markAsDone(String title) {
        Task task = find(title);

        task.setDone(true);
    }

    public void markAsNotDone(String title) {
        Task task = find(title);

        task.setDone(false);
    }

    public Task getNextTask() {
        String title = taskLinkedList.element().getTitle();

        int size = taskLinkedList.size();
        int i;
        for (i = 0; i < size && !Objects.equals(title, taskLinkedList.get(i).getTitle()); i++) ;
        return taskLinkedList.get(i + 1);
    }

    public LinkedList<Task> getNextTasks(){
        LinkedList<Task> taskLinkedList = new LinkedList<>();

        int size = this.taskLinkedList.size();
        for(Task task : this.taskLinkedList){
            if(!task.isDone()){
                taskLinkedList.add(task);
            }
        }

        taskLinkedList.sort(Comparator.comparing(Task::getDueDate));

        return taskLinkedList;
    }
}
