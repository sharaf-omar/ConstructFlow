package com.constructflow.boundary.reports.adapter;

/**
 * ADAPTER PATTERN - Third-Party Library Simulation
 * Simulates Jasper Reports third-party library interface.
 * This has a different interface than our ReportFactory.
 */
public class JasperReportEngine {
    public String generateReportFromTemplate(String templateName, String dataSource) {
        System.out.println("[JasperReportEngine] Generating report from template: " + templateName);
        System.out.println("[JasperReportEngine] Using datasource: " + dataSource);
        System.out.println("[JasperReportEngine] Report generated in PDF format");
        return "jasper_report_" + System.currentTimeMillis() + ".pdf";
    }
    
    public String exportToFormat(String report, String format) {
        System.out.println("[JasperReportEngine] Exporting report to " + format + " format");
        return report + "." + format.toLowerCase();
    }
}
