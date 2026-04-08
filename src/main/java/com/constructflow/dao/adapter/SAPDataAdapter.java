package com.constructflow.dao.adapter;

import com.constructflow.entity.Project;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.xml.sax.InputSource;

/**
 * ADAPTER PATTERN - Concrete Adapter
 * Adapter for SAP ERP system data (XML format).
 * Converts SAP XML project export to internal Project entity.
 */
public class SAPDataAdapter implements DataAdapter {
    
    @Override
    public Project convertToProject(Object externalData) {
        if (!(externalData instanceof String)) {
            System.err.println("[SAPDataAdapter] Invalid data format");
            return null;
        }
        
        try {
            String xmlData = (String) externalData;
            System.out.println("[SAPDataAdapter] Parsing SAP XML data...");
            
            // Parse XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xmlData)));
            
            Element root = doc.getDocumentElement();
            
            // Extract SAP data
            String sapProjectID = root.getAttribute("projectNumber");
            String sapProjectName = root.getElementsByTagName("description").item(0).getTextContent();
            String sapLocation = root.getElementsByTagName("location").item(0).getTextContent();
            String sapStartDate = root.getElementsByTagName("startDate").item(0).getTextContent();
            
            // Convert to internal Project format
            Project project = new Project();
            project.setProjectID(sapProjectID);
            project.setProjectName(sapProjectName);
            project.setLocation(sapLocation);
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                project.setStartDate(sdf.parse(sapStartDate));
            } catch (Exception e) {
                project.setStartDate(new Date());
            }
            
            System.out.println("[SAPDataAdapter] Successfully converted SAP project: " + sapProjectName);
            return project;
            
        } catch (Exception e) {
            System.err.println("[SAPDataAdapter] Conversion error: " + e.getMessage());
            return null;
        }
    }
    
    @Override
    public String getSourceType() {
        return "SAP_ERP_XML";
    }
}
