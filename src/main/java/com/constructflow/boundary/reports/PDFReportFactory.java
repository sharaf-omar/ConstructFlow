package com.constructflow.boundary.reports;

public class PDFReportFactory implements ReportFactory {
    public WorkloadReport createWorkloadReport() { return new PDFWorkloadReport(); }
    public SummaryReport createSummaryReport() { return new PDFSummaryReport(); }
}
