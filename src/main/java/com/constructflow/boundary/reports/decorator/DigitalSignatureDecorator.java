package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds digital signature to reports for authentication and compliance.
 */
public class DigitalSignatureDecorator extends ReportDecorator {
    private String certificatePath;
    private String signedBy;
    
    public DigitalSignatureDecorator(ReportFactory factory, String certificatePath, String signedBy) {
        super(factory);
        this.certificatePath = certificatePath;
        this.signedBy = signedBy;
    }
    
    @Override
    protected void applyDecoration(String reportType) {
        System.out.println("[DigitalSignatureDecorator] Applying digital signature to " + reportType);
        System.out.println("[DigitalSignatureDecorator] Certificate: " + certificatePath);
        System.out.println("[DigitalSignatureDecorator] Signed by: " + signedBy);
    }
    
    public String getCertificatePath() {
        return certificatePath;
    }
    
    public String getSignedBy() {
        return signedBy;
    }
}
