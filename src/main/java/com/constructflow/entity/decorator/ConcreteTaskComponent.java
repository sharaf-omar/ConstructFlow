package com.constructflow.entity.decorator;

import com.constructflow.entity.Task;

/**
 * DECORATOR PATTERN - Concrete Component
 * Wraps the base Task entity.
 */
public class ConcreteTaskComponent implements TaskComponent {
    private Task task;
    
    public ConcreteTaskComponent(Task task) {
        this.task = task;
    }
    
    @Override
    public void execute() {
        System.out.println("[Task] Executing: " + task.getTaskName());
    }
    
    @Override
    public String getDescription() {
        return "Task: " + task.getTaskName() + " | Status: " + task.getStatus();
    }
    
    @Override
    public Task getTask() {
        return task;
    }
}
