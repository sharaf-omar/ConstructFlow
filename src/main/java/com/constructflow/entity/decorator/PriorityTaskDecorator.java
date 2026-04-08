package com.constructflow.entity.decorator;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds priority behavior to tasks.
 * Changes notification frequency and queue processing.
 */
public class PriorityTaskDecorator extends TaskDecorator {
    private String priority;
    
    public PriorityTaskDecorator(TaskComponent component, String priority) {
        super(component);
        this.priority = priority;
        addDecoration();
    }
    
    @Override
    protected void addDecoration() {
        System.out.println("[PriorityDecorator] Task marked as: " + priority + " PRIORITY");
    }
    
    @Override
    public void execute() {
        super.execute();
        System.out.println("[PriorityDecorator] Escalating notifications due to " + priority + " priority!");
        System.out.println("[PriorityDecorator] Sending urgent alerts to managers...");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " | [" + priority + " PRIORITY]";
    }
    
    public String getPriority() {
        return priority;
    }
}
