package com.constructflow.dao.adapter;

import com.constructflow.entity.Project;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ADAPTER PATTERN - Concrete Adapter
 * Adapter for CSV data import.
 * Converts CSV-formatted project data to internal Project entity.
 */
public class CSVDataAdapter implements DataAdapter {
    
    @Override
    public Project convertToProject(Object externalData) {
        if (!(externalData instanceof String)) {
            System.err.println("[CSVDataAdapter] Invalid data format - expected CSV string");
            return null;
        }
        
        try {
            String csvLine = (String) externalData;
            System.out.println("[CSVDataAdapter] Parsing CSV line...");
            
            // Parse CSV (tab or comma separated)
            String[] fields = csvLine.split("[,\t]");
            
            if (fields.length < 4) {
                System.err.println("[CSVDataAdapter] CSV line does not have enough fields");
                return null;
            }
            
            // Extract CSV columns (assuming order: ID, Name, Location, StartDate)
            String csvProjectID = fields[0].trim();
            String csvProjectName = fields[1].trim();
            String csvLocation = fields[2].trim();
            String csvStartDate = fields[3].trim();
            
            // Convert to internal Project format
            Project project = new Project();
            project.setProjectID(csvProjectID);
            project.setProjectName(csvProjectName);
            project.setLocation(csvLocation);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                project.setStartDate(sdf.parse(csvStartDate));
            } catch (Exception e) {
                project.setStartDate(new Date());
            }
            
            System.out.println("[CSVDataAdapter] Successfully converted CSV project: " + csvProjectName);
            return project;
            
        } catch (Exception e) {
            System.err.println("[CSVDataAdapter] Conversion error: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public String getSourceType() {
        return "CSV_EXPORT";
    }
}
