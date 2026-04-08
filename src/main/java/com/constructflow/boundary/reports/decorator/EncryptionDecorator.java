package com.constructflow.boundary.reports.decorator;

import com.constructflow.boundary.reports.ReportFactory;

/**
 * DECORATOR PATTERN - Concrete Decorator
 * Adds encryption to reports for sensitive data protection.
 */
public class EncryptionDecorator extends ReportDecorator {
    private String password;
    private String encryptionAlgorithm;
    
    public EncryptionDecorator(ReportFactory factory, String password) {
        super(factory);
        this.password = password;
        this.encryptionAlgorithm = "AES-256";
    }
    
    @Override
    protected void applyDecoration(String reportType) {
        System.out.println("[EncryptionDecorator] Encrypting " + reportType + " with " + encryptionAlgorithm);
        System.out.println("[EncryptionDecorator] Password protection enabled");
        System.out.println("[EncryptionDecorator] Encryption status: COMPLETE");
    }
    
    public String getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }
    
    public void setEncryptionAlgorithm(String algorithm) {
        this.encryptionAlgorithm = algorithm;
    }
}
