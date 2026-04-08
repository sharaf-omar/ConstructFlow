package com.constructflow.entity.decorator;

import java.util.HashSet;
import java.util.Set;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds access control to tasks (confidential/restricted).
 * Limits who can view or execute the task.
 */
public class RestrictedTaskDecorator extends TaskDecorator {
    private Set<String> authorizedUsers;
    private String restrictionLevel;
    
    public RestrictedTaskDecorator(TaskComponent component, String restrictionLevel) {
        super(component);
        this.restrictionLevel = restrictionLevel;
        this.authorizedUsers = new HashSet<>();
        addDecoration();
    }
    
    @Override
    protected void addDecoration() {
        System.out.println("[RestrictedDecorator] Task restricted to: " + restrictionLevel);
    }
    
    @Override
    public void execute() {
        System.out.println("[RestrictedDecorator] Access restricted - Only authorized personnel can execute");
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " | [" + restrictionLevel.toUpperCase() + " - Restricted]";
    }
    
    /**
     * Grants access to a user.
     */
    public void grantAccess(String username) {
        authorizedUsers.add(username);
        System.out.println("[RestrictedDecorator] Access granted to: " + username);
    }
    
    /**
     * Checks if user has access.
     */
    public boolean hasAccess(String username) {
        return authorizedUsers.contains(username);
    }
    
    /**
     * Executes only if user is authorized.
     */
    public void executeIfAuthorized(String username) {
        if (hasAccess(username)) {
            System.out.println("[RestrictedDecorator] User " + username + " authorized - executing task");
            wrappedComponent.execute();
        } else {
            System.out.println("[RestrictedDecorator] [DENIED] User " + username + " not authorized to execute this task");
        }
    }
    
    public String getRestrictionLevel() {
        return restrictionLevel;
    }
}
