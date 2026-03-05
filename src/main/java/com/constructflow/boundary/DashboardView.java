package com.constructflow.boundary;

import com.constructflow.controller.ProjectManagementController;
import com.constructflow.entity.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The main dashboard view for the ConstructFlow application.
 * Displays a list of projects and provides options to manage them.
 * This is the primary <<boundary>> class for viewing projects.
 */
public class DashboardView extends JFrame {

    //private final ProjectManagementController controller;
    private JList<String> projectList;
    private DefaultListModel<String> listModel;

    /**
     * Constructor for the DashboardView.
     */
    public DashboardView() {

    }

    public void refreshProjectList() {
        //
    }
}
