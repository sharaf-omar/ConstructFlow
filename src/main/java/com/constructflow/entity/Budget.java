package com.constructflow.entity; // Ensure this matches your package structure

import java.util.Map;

public class Budget {

    // Fixed the auto-generated UML pseudo-code into proper Java attributes
    private int budgetId; // Primary Key
    private double totalAmount;
    private double version;
    private String approvalStatus;

    /**
     * Default constructor
     */
    public Budget() {
        System.out.println("[Entity] Default Budget created.");
    }

    /**
     * Parameterized constructor using a Map (as defined in your DCD)
     * @param details Map containing budget initialization data
     */
    public Budget(Map<String, Object> details) {
        System.out.println("[Entity] Budget created using details map.");

        // Minimal dumb implementation to parse the map safely
        if (details != null) {
            if (details.containsKey("budgetId")) {
                this.budgetId = (Integer) details.get("budgetId");
            }
            if (details.containsKey("totalAmount")) {
                this.totalAmount = (Double) details.get("totalAmount");
            }
            if (details.containsKey("approvalStatus")) {
                this.approvalStatus = (String) details.get("approvalStatus");
            }
        }
    }

    // --- GETTERS AND SETTERS ---

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    // Optional: Useful for testing prints later
    @Override
    public String toString() {
        return "Budget{" +
                "budgetId=" + budgetId +
                ", totalAmount=" + totalAmount +
                ", version=" + version +
                ", approvalStatus='" + approvalStatus + '\'' +
                '}';
    }
}