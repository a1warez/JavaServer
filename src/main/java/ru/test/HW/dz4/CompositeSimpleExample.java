package ru.test.HW.dz4;

import java.util.ArrayList;
import java.util.List;

class Task implements TaskComponent {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void execute() {
        System.out.println("Выполнение задачи: " + name);
    }
}

class TaskList implements TaskComponent {
    private String name;
    private List<TaskComponent> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }

    public void addTask(TaskComponent task) {
        tasks.add(task);
    }

    @Override
    public void execute() {
        System.out.println("Выполнение списка задач: " + name);
        for (TaskComponent task : tasks) {
            task.execute();
        }
    }
}

public class CompositeSimpleExample {
    public static void main(String[] args) {
        Task task1 = new Task("Написать код");
        Task task2 = new Task("Тестировать код");

        TaskList sprint1 = new TaskList("Спринт 1");
        sprint1.addTask(task1);
        sprint1.addTask(task2);

        sprint1.execute();
    }
}

