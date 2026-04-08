package com.constructflow.entity.decorator;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds approval/review workflow to tasks.
 * Tasks require manager approval before execution.
 */
public class ReviewableTaskDecorator extends TaskDecorator {
    private boolean approved;
    private String reviewedBy;
    
    public ReviewableTaskDecorator(TaskComponent component) {
        super(component);
        this.approved = false;
        this.reviewedBy = null;
        addDecoration();
    }
    
    @Override
    protected void addDecoration() {
        System.out.println("[ReviewableDecorator] Task now requires approval before execution");
    }
    
    @Override
    public void execute() {
        if (!approved) {
            System.out.println("[ReviewableDecorator] [BLOCKED] Cannot execute - pending approval!");
            return;
        }
        super.execute();
        System.out.println("[ReviewableDecorator] Task approved by: " + reviewedBy);
    }
    
    @Override
    public String getDescription() {
        String status = approved ? "Approved by " + reviewedBy : "PENDING APPROVAL";
        return super.getDescription() + " | [Review Status: " + status + "]";
    }
    
    public void approve(String approver) {
        this.approved = true;
        this.reviewedBy = approver;
        System.out.println("[ReviewableDecorator] Task approved by: " + approver);
    }
    
    public boolean isApproved() {
        return approved;
    }
}
