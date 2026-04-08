package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;
import com.constructflow.boundary.reports.WorkloadReport;
import com.constructflow.boundary.reports.SummaryReport;

/**
 * DECORATOR PATTERN - Abstract Decorator for Reports
 * Base class for all report enhancement decorators.
 */
public abstract class ReportDecorator implements ReportFactory {
    protected ReportFactory wrappedFactory;
    
    public ReportDecorator(ReportFactory factory) {
        this.wrappedFactory = factory;
    }
    
    @Override
    public WorkloadReport createWorkloadReport() {
        return new DecoratedWorkloadReport(wrappedFactory.createWorkloadReport());
    }
    
    @Override
    public SummaryReport createSummaryReport() {
        return new DecoratedSummaryReport(wrappedFactory.createSummaryReport());
    }
    
    /**
     * Hook method for subclasses to apply decoration.
     */
    protected abstract void applyDecoration(String reportType);
    
    /**
     * Inner wrapper for WorkloadReport.
     */
    protected class DecoratedWorkloadReport implements WorkloadReport {
        private WorkloadReport wrapped;
        
        DecoratedWorkloadReport(WorkloadReport report) {
            this.wrapped = report;
        }
        
        @Override
        public void generate() {
            wrapped.generate();
            applyDecoration("WorkloadReport");
        }
    }
    
    /**
     * Inner wrapper for SummaryReport.
     */
    protected class DecoratedSummaryReport implements SummaryReport {
        private SummaryReport wrapped;
        
        DecoratedSummaryReport(SummaryReport report) {
            this.wrapped = report;
        }
        
        @Override
        public void generate() {
            wrapped.generate();
            applyDecoration("SummaryReport");
        }
    }
}
