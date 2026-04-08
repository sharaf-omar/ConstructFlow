package com.constructflow.entity.decorator;

import com.constructflow.entity.Task;

/**
 * DECORATOR PATTERN - Abstract Decorator
 * Base class for all task decorators.
 * Each decorator wraps a TaskComponent and adds behavior.
 */
public abstract class TaskDecorator implements TaskComponent {
    protected TaskComponent wrappedComponent;
    
    public TaskDecorator(TaskComponent component) {
        this.wrappedComponent = component;
    }
    
    @Override
    public void execute() {
        wrappedComponent.execute();
    }
    
    @Override
    public String getDescription() {
        return wrappedComponent.getDescription();
    }
    
    @Override
    public Task getTask() {
        return wrappedComponent.getTask();
    }
    
    /**
     * Hook method for subclasses to add behavior.
     */
    protected abstract void addDecoration();
}
