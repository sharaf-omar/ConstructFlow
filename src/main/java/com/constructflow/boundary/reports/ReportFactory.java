package com.constructflow.boundary.reports;

public interface ReportFactory {
    WorkloadReport createWorkloadReport();
    SummaryReport createSummaryReport();
}
