package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds watermark to reports (e.g., "DRAFT", "CONFIDENTIAL").
 */
public class WatermarkDecorator extends ReportDecorator {
    private String watermarkText;
    
    public WatermarkDecorator(ReportFactory factory, String watermarkText) {
        super(factory);
        this.watermarkText = watermarkText;
    }
    
    @Override
    protected void applyDecoration(String reportType) {
        System.out.println("[WatermarkDecorator] Adding watermark to " + reportType + ": " + watermarkText);
    }
    
    public String getWatermarkText() {
        return watermarkText;
    }
}
