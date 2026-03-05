package com.constructflow.controller;

import java.io.*;
import java.util.*;

/**
 * Acts as the mediator. It receives the request from the ProjectDetailsForm and orchestrates the update process.
 */
public class ProjectManagementController {

    /**
     * Default constructor
     */
    public ProjectManagementController() {
    }


    /**
     * @param projectID 
     * @param newDetails 
     * @return
     */
    public boolean updateProject(int projectID, Map newDetails) {
        // TODO implement here
        return false;
    }

    /**
     * @param taskID 
     * @return
     */
    public boolean cancelTask(int taskID) {
        // TODO implement here
        return false;
    }

    /**
     * @param projectID 
     * @return
     */
    public boolean archiveProject(int projectID) {
        // TODO implement here
        return false;
    }

    /**
     * @param projectDetails 
     * @param budgetDetails 
     * @return
     */
    public int createNewProject(Map projectDetails, Map budgetDetails) {
        // TODO implement here
        return 0;
    }

}