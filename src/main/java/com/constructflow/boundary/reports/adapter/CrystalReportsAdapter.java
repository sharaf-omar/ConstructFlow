package com.constructflow.boundary.reports.adapter;

import com.constructflow.boundary.reports.ReportFactory;
import com.constructflow.boundary.reports.WorkloadReport;
import com.constructflow.boundary.reports.SummaryReport;

/**
 * ADAPTER PATTERN - Class Adapter
 * Adapts CrystalReportsEngine to our ReportFactory interface.
 * Allows seamless integration of Crystal Reports without modifying existing code.
 */
public class CrystalReportsAdapter implements ReportFactory {
    private CrystalReportsEngine crystalEngine;
    
    public CrystalReportsAdapter() {
        this.crystalEngine = new CrystalReportsEngine();
    }
    
    @Override
    public WorkloadReport createWorkloadReport() {
        return new AdaptedCrystalWorkloadReport(crystalEngine);
    }
    
    @Override
    public SummaryReport createSummaryReport() {
        return new AdaptedCrystalSummaryReport(crystalEngine);
    }
    
    /**
     * Inner class that adapts Crystal WorkloadReport
     */
    private static class AdaptedCrystalWorkloadReport implements WorkloadReport {
        private CrystalReportsEngine crystalEngine;
        
        AdaptedCrystalWorkloadReport(CrystalReportsEngine crystalEngine) {
            this.crystalEngine = crystalEngine;
        }
        
        @Override
        public void generate() {
            System.out.println("[CrystalAdapter] Adapting WorkloadReport generation...");
            crystalEngine.buildReport("SELECT * FROM ProjectWorkload", "StandardLayout");
            crystalEngine.formatReport("Professional");
            String output = crystalEngine.output("XLSX");
            System.out.println("[CrystalAdapter] WorkloadReport generated: " + output);
        }
    }
    
    /**
     * Inner class that adapts Crystal SummaryReport
     */
    private static class AdaptedCrystalSummaryReport implements SummaryReport {
        private CrystalReportsEngine crystalEngine;
        
        AdaptedCrystalSummaryReport(CrystalReportsEngine crystalEngine) {
            this.crystalEngine = crystalEngine;
        }
        
        @Override
        public void generate() {
            System.out.println("[CrystalAdapter] Adapting SummaryReport generation...");
            crystalEngine.buildReport("SELECT * FROM ProjectSummary", "ExecutiveLayout");
            crystalEngine.formatReport("Executive");
            String output = crystalEngine.output("PDF");
            System.out.println("[CrystalAdapter] SummaryReport generated: " + output);
        }
    }
}
