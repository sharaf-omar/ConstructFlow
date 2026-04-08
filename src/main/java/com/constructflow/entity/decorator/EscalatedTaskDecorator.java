package com.constructflow.entity.decorator;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds escalation behavior to tasks.
 * Escalated tasks bypass normal processing queues and get priority handling.
 */
public class EscalatedTaskDecorator extends TaskDecorator {
    private int escalationLevel;
    private String reason;
    
    public EscalatedTaskDecorator(TaskComponent component, int escalationLevel, String reason) {
        super(component);
        this.escalationLevel = escalationLevel;
        this.reason = reason;
        addDecoration();
    }
    
    @Override
    protected void addDecoration() {
        System.out.println("[EscalatedDecorator] Task escalated to Level " + escalationLevel);
        System.out.println("[EscalatedDecorator] Reason: " + reason);
    }
    
    @Override
    public void execute() {
        System.out.println("[EscalatedDecorator] [ESCALATED PRIORITY] Bypassing queue!");
        System.out.println("[EscalatedDecorator] Assigning to senior management...");
        System.out.println("[EscalatedDecorator] Escalation Level: " + escalationLevel);
        super.execute();
        System.out.println("[EscalatedDecorator] Status updated - Escalation handled");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " | [ESCALATED: Level " + escalationLevel + "]";
    }
    
    public int getEscalationLevel() {
        return escalationLevel;
    }
    
    public String getReason() {
        return reason;
    }
}
