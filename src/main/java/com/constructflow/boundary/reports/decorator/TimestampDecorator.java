package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds timestamp and audit trail to reports.
 */
public class TimestampDecorator extends ReportDecorator {
    private boolean includeAuditTrail;
    
    public TimestampDecorator(ReportFactory factory) {
        super(factory);
        this.includeAuditTrail = true;
    }
    
    @Override
    protected void applyDecoration(String reportType) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println("[TimestampDecorator] Adding timestamp to " + reportType + ": " + timestamp);
        
        if (includeAuditTrail) {
            System.out.println("[TimestampDecorator] Audit trail:");
            System.out.println("  - Generated: " + timestamp);
            System.out.println("  - Version: 1.0");
            System.out.println("  - Format: PDF/XLSX");
        }
    }
    
    public void setIncludeAuditTrail(boolean includeAuditTrail) {
        this.includeAuditTrail = includeAuditTrail;
    }
}
