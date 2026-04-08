package com.constructflow.entity.decorator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds audit logging to tasks.
 * Logs all state changes, executions, and modifications.
 */
public class AuditableTaskDecorator extends TaskDecorator {
    private StringBuilder auditLog;
    
    public AuditableTaskDecorator(TaskComponent component) {
        super(component);
        this.auditLog = new StringBuilder();
        addDecoration();
    }
    
    @Override
    protected void addDecoration() {
        logAudit("Task wrapped with audit logging");
        System.out.println("[AuditableDecorator] Audit logging enabled");
    }
    
    @Override
    public void execute() {
        logAudit("Executing task");
        super.execute();
        logAudit("Task execution completed");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " | [Audit Enabled]";
    }
    
    private void logAudit(String event) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String logEntry = "[" + timestamp + "] " + event;
        auditLog.append(logEntry).append("\n");
        System.out.println("[AuditableDecorator] " + logEntry);
    }
    
    public String getAuditLog() {
        return auditLog.toString();
    }
    
    public void printAuditLog() {
        System.out.println("\n=== AUDIT LOG ===\n" + auditLog.toString());
    }
}
