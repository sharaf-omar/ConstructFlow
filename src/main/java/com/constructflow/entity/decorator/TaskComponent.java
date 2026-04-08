package com.constructflow.entity.decorator;

import com.constructflow.entity.Task;

/**
 * DECORATOR PATTERN - Component
 * Interface for Task component and its decorators.
 */
public interface TaskComponent {
    /**
     * Executes/displays the task with all applied decorations.
     */
    void execute();
    
    /**
     * Gets task description including all decorations.
     */
    String getDescription();
    
    /**
     * Gets the underlying task.
     */
    Task getTask();
}
