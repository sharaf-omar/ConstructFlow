package com.constructflow.boundary.reports.adapter;

/**
 * ADAPTER PATTERN - Third-Party Library Simulation
 * Simulates Crystal Reports third-party library interface.
 * Also has a different interface than our ReportFactory.
 */
public class CrystalReportsEngine {
    public void buildReport(String query, String layout) {
        System.out.println("[CrystalReportsEngine] Building report with query: " + query);
        System.out.println("[CrystalReportsEngine] Using layout: " + layout);
    }
    
    public void formatReport(String style) {
        System.out.println("[CrystalReportsEngine] Formatting report with style: " + style);
    }
    
    public String output(String fileFormat) {
        System.out.println("[CrystalReportsEngine] Final output format: " + fileFormat);
        return "crystal_report_" + System.currentTimeMillis() + "." + fileFormat.toLowerCase();
    }
}
