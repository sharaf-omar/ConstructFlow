package com.constructflow.boundary.reports.adapter;

import com.constructflow.boundary.reports.ReportFactory;
import com.constructflow.boundary.reports.WorkloadReport;
import com.constructflow.boundary.reports.SummaryReport;

/**
 * ADAPTER PATTERN - Class Adapter
 * Adapts JasperReportEngine to our ReportFactory interface.
 * Allows existing code to work with Jasper Reports without changes.
 */
public class JasperReportAdapter implements ReportFactory {
    private JasperReportEngine jasperEngine;
    
    public JasperReportAdapter() {
        this.jasperEngine = new JasperReportEngine();
    }
    
    @Override
    public WorkloadReport createWorkloadReport() {
        // Adapt Jasper's interface to WorkloadReport
        return new AdaptedJasperWorkloadReport(jasperEngine);
    }
    
    @Override
    public SummaryReport createSummaryReport() {
        // Adapt Jasper's interface to SummaryReport
        return new AdaptedJasperSummaryReport(jasperEngine);
    }
    
    /**
     * Inner class that adapts Jasper WorkloadReport
     */
    private static class AdaptedJasperWorkloadReport implements WorkloadReport {
        private JasperReportEngine jasperEngine;
        
        AdaptedJasperWorkloadReport(JasperReportEngine jasperEngine) {
            this.jasperEngine = jasperEngine;
        }
        
        @Override
        public void generate() {
            System.out.println("[JasperAdapter] Adapting WorkloadReport generation...");
            String report = jasperEngine.generateReportFromTemplate("WorkloadTemplate", "ProjectWorkloadDS");
            jasperEngine.exportToFormat(report, "PDF");
            System.out.println("[JasperAdapter] WorkloadReport successfully generated via Jasper!");
        }
    }
    
    /**
     * Inner class that adapts Jasper SummaryReport
     */
    private static class AdaptedJasperSummaryReport implements SummaryReport {
        private JasperReportEngine jasperEngine;
        
        AdaptedJasperSummaryReport(JasperReportEngine jasperEngine) {
            this.jasperEngine = jasperEngine;
        }
        
        @Override
        public void generate() {
            System.out.println("[JasperAdapter] Adapting SummaryReport generation...");
            String report = jasperEngine.generateReportFromTemplate("SummaryTemplate", "ProjectSummaryDS");
            jasperEngine.exportToFormat(report, "PDF");
            System.out.println("[JasperAdapter] SummaryReport successfully generated via Jasper!");
        }
    }
}
