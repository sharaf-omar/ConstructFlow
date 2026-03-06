package com.constructflow.boundary.reports;

public class ExcelReportFactory implements ReportFactory {
    public WorkloadReport createWorkloadReport() { return new ExcelWorkloadReport(); }
    public SummaryReport createSummaryReport() { return new ExcelSummaryReport(); }
}