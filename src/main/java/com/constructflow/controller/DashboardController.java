
package com.constructflow.controller;

import com.constructflow.entity.Resource;
import com.constructflow.entity.Project;
import com.constructflow.boundary.DashboardView;

import java.util.List;

public class DashboardController {

    public DashboardController() {
        System.out.println("[Controller] Default DashboardController created.");
    }

    public DashboardView getDashboardData(int userID) {
        System.out.println("[Controller] getDashboardData called with userID: " + userID);
        return null;
    }

    public List<Project> projectSummaries() {
        System.out.println("[Controller] projectSummaries called");
        return null;
    }

    public int overdueTaskCount() {
        System.out.println("[Controller] overdueTaskCount called");
        return 0;
    }

    public List<Resource> resourceList() {
        System.out.println("[Controller] resourceList called");
        return null;
    }

}
