package com.constructflow.dao.adapter;

import com.constructflow.entity.Project;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * ADAPTER PATTERN - Concrete Adapter
 * Adapter for Autodesk API data (JSON-like format, simulated as Map).
 * Converts Autodesk BIM project data to internal Project entity.
 */
public class AutodeskDataAdapter implements DataAdapter {
    
    @Override
    public Project convertToProject(Object externalData) {
        if (!(externalData instanceof Map)) {
            System.err.println("[AutodeskDataAdapter] Invalid data format - expected Map");
            return null;
        }
        
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> autodeskJson = (Map<String, Object>) externalData;
            
            System.out.println("[AutodeskDataAdapter] Converting Autodesk BIM data...");
            
            // Extract Autodesk data
            String autodeskProjectID = (String) autodeskJson.get("urn");
            String autodeskProjectName = (String) autodeskJson.get("name");
            String autodeskLocation = (String) autodeskJson.getOrDefault("address", "N/A");
            String autodeskStartDate = (String) autodeskJson.getOrDefault("createdDate", "2024-01-01");
            
            // Convert to internal Project format
            Project project = new Project();
            project.setProjectID(autodeskProjectID);
            project.setProjectName(autodeskProjectName);
            project.setLocation(autodeskLocation);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                project.setStartDate(sdf.parse(autodeskStartDate));
            } catch (Exception e) {
                project.setStartDate(new Date());
            }
            
            System.out.println("[AutodeskDataAdapter] Successfully converted Autodesk project: " + autodeskProjectName);
            return project;
            
        } catch (Exception e) {
            System.err.println("[AutodeskDataAdapter] Conversion error: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public String getSourceType() {
        return "AUTODESK_BIM_API";
    }
}
