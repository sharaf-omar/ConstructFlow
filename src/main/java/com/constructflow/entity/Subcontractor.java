package com.constructflow.entity;

public class Subcontractor {

    private int subcontractorID;
    private String companyName;
    private String serviceType;

    public Subcontractor() {
        System.out.println("[Entity] Default Subcontractor created.");
    }

    public Subcontractor(int subcontractorID, String companyName, String serviceType) {
        this.subcontractorID = subcontractorID;
        this.companyName = companyName;
        this.serviceType = serviceType;
        System.out.println("[Entity] Subcontractor '" + companyName + "' registered for " + serviceType);
    }

    public int getSubcontractorID() {
        return subcontractorID;
    }

    public void setSubcontractorID(int subcontractorID) {
        this.subcontractorID = subcontractorID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Subcontractor{" +
                "subcontractorID=" + subcontractorID +
                ", companyName='" + companyName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}