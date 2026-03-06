package com.constructflow.dao;

import com.constructflow.entity.Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectRepository {

    public ProjectRepository() {
        System.out.println("[DAO] ProjectRepository initialized.");
    }

    public Project findProjectByID(String projectID) {
        String sql = "SELECT * FROM projects WHERE id = ?";

        try (Connection conn = DatabaseConnector.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, projectID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getString("id"));
                project.setProjectName(rs.getString("name"));
                project.setLocation(rs.getString("location"));
                project.setStartDate(rs.getDate("start_date"));
                project.setEndDate(rs.getDate("end_date"));
                project.setStatus(rs.getString("status"));
                System.out.println("[DAO] Project found: " + project.getProjectName());
                return project;
            }
        } catch (SQLException e) {
            System.err.println("[DAO] Error finding project: " + e.getMessage());
        }
        return null;
    }

    public List<Project> findAllProjects() {
        List<Project> projects = new ArrayList<>();
        String sql = "SELECT * FROM projects";

        try (Connection conn = DatabaseConnector.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Project project = new Project();
                project.setProjectID(rs.getString("id"));
                project.setProjectName(rs.getString("name"));
                project.setLocation(rs.getString("location"));
                project.setStartDate(rs.getDate("start_date"));
                project.setEndDate(rs.getDate("end_date"));
                project.setStatus(rs.getString("status"));
                projects.add(project);
            }
            System.out.println("[DAO] Retrieved " + projects.size() + " projects.");
        } catch (SQLException e) {
            System.err.println("[DAO] Error listing projects: " + e.getMessage());
        }
        return projects;
    }

    public boolean save(Project project) {

        String sql = "INSERT INTO projects (name, location, start_date, end_date, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnector.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getLocation());
            pstmt.setDate(3, project.getStartDate() != null ? new java.sql.Date(project.getStartDate().getTime()) : null);
            pstmt.setDate(4, project.getEndDate() != null ? new java.sql.Date(project.getEndDate().getTime()) : null);
            pstmt.setString(5, project.getStatus());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("[DAO] Project '" + project.getProjectName() + "' saved successfully.");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("[DAO] Error saving project: " + e.getMessage());
        }
        return false;
    }

    public boolean update(Project project) {
        String sql = "UPDATE projects SET name = ?, location = ?, start_date = ?, end_date = ?, status = ? WHERE id = ?";

        try (Connection conn = DatabaseConnector.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, project.getProjectName());
            pstmt.setString(2, project.getLocation());
            pstmt.setDate(3, project.getStartDate() != null ? new java.sql.Date(project.getStartDate().getTime()) : null);
            pstmt.setDate(4, project.getEndDate() != null ? new java.sql.Date(project.getEndDate().getTime()) : null);
            pstmt.setString(5, project.getStatus());
            pstmt.setString(6, project.getProjectID());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("[DAO] Project ID " + project.getProjectID() + " updated.");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("[DAO] Error updating project: " + e.getMessage());
        }
        return false;
    }
}