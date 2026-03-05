package com.constructflow.dao;

import com.constructflow.entity.Project;
import com.constructflow.entity.Task; // Assuming you have a Task entity class

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for the Project entity.
 * Handles all database CRUD operations for Projects.
 */
public class ProjectRepository {

    /**
     * Default constructor
     */
    public ProjectRepository() {
    }

    /**
     * Retrieves a single project from the database by its ID.
     * @param projectID The ID of the project to find.
     * @return A Project object if found, otherwise null.
     */
    public Project findProjectByID(int projectID) {
        String sql = "SELECT * FROM Project WHERE projectID = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, projectID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setLocation(rs.getString("location"));
                project.setStartDate(rs.getDate("startDate"));
                project.setEndDate(rs.getDate("endDate"));
                project.setStatus(rs.getString("status"));
                //set clientID and managerID if they are attributes in the Project class
                return project;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Proper logging should be used in a real application
        }
        return null;
    }

    /**
     * Retrieves all projects from the database.
     * REQUIRED FOR WALKING SKELETON.
     * @return A List of all Project objects.
     */
    public List<Project> findAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM Project";
        try (Connection conn = DatabaseConnector.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getInt("projectID"));
                project.setProjectName(rs.getString("projectName"));
                project.setLocation(rs.getString("location"));
                project.setStatus(rs.getString("status"));
                // Add other setters as needed
                projects.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    /**
     * Saves a new project to the database.
     * REQUIRED FOR WALKING SKELETON.
     * @param project The Project object to save.
     * @return true if the save was successful, false otherwise.
     */
    public boolean save(Project project) {
        String sql = "INSERT INTO Project (projectName, location, startDate, endDate, status, clientID, managerID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            /*
            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getLocation());
            pstmt.setDate(3, new java.sql.Date(project.getStartDate().getTime())); // Convert java.util.Date to java.sql.Date
            pstmt.setDate(4, new java.sql.Date(project.getEndDate().getTime()));
            pstmt.setString(5, project.getStatus());
            pstmt.setInt(6, project.getClientID()); // Assuming getters exist
            pstmt.setInt(7, project.getManagerID()); // Assuming getters exist
            */
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an existing project in the database.
     * @param project The Project object with updated information.
     * @return true if the update was successful, false otherwise.
     */
    public boolean update(Project project) {
        String sql = "UPDATE Project SET projectName = ?, location = ?, startDate = ?, endDate = ?, status = ? WHERE projectID = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getLocation());
            pstmt.setDate(3, new java.sql.Date(project.getStartDate().getTime()));
            pstmt.setDate(4, new java.sql.Date(project.getEndDate().getTime()));
            pstmt.setString(5, project.getStatus());
            pstmt.setInt(6, project.getProjectID());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // The methods below are placeholders from the generated code.
    // They would be implemented in their respective DAO classes (e.g., TaskDAO).
    
    /**
     * @param task 
     * @return
     */
    public boolean updateTask(Task task) {
        // This logic should be in TaskDAO.java
        System.out.println("This method belongs in the TaskDAO class.");
        return false;
    }

    /**
     * @param project 
     * @return
     */
    public boolean updateProjectAndChildrenStatus(Project project) {
        // This is a more complex transaction. For now, it's just a placeholder.
        // It would involve updating the Project, and then all related Tasks, etc.
        System.out.println("This method would handle a complex transaction for archival.");
        return false;
    }
}