package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds compression to reports to reduce file size.
 */
public class CompressionDecorator extends ReportDecorator {
    private String compressionLevel;
    
    public CompressionDecorator(ReportFactory factory, String compressionLevel) {
        super(factory);
        this.compressionLevel = compressionLevel;
    }
    
    @Override
    protected void applyDecoration(String reportType) {
        System.out.println("[CompressionDecorator] Compressing " + reportType + " at " + compressionLevel + " level");
        System.out.println("[CompressionDecorator] File size reduction: ~40-60%");
        System.out.println("[CompressionDecorator] Compression completed successfully");
    }
    
    public String getCompressionLevel() {
        return compressionLevel;
    }
}
