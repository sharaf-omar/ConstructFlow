package com.constructflow.entity; // Ensure this matches your package structure

public class CostCode {

    // Fixed the auto-generated UML pseudo-code into proper Java attributes
    private int codeID; // Primary Key
    private String codeName;
    private double allocatedAmount; // "Real" in UML translates to double in Java

    /**
     * Default constructor
     */
    public CostCode() {
        System.out.println("[Entity] Default CostCode created.");
    }

    /**
     * Parameterized constructor
     * @param codeID
     * @param codeName
     * @param allocatedAmount
     */
    public CostCode(int codeID, String codeName, double allocatedAmount) {
        this.codeID = codeID;
        this.codeName = codeName;
        this.allocatedAmount = allocatedAmount;
        System.out.println("[Entity] CostCode '" + codeName + "' created with amount: " + allocatedAmount);
    }

    // --- GETTERS AND SETTERS ---

    public int getCodeID() {
        return codeID;
    }

    public void setCodeID(int codeID) {
        this.codeID = codeID;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public double getAllocatedAmount() {
        return allocatedAmount;
    }

    public void setAllocatedAmount(double allocatedAmount) {
        this.allocatedAmount = allocatedAmount;
    }

    @Override
    public String toString() {
        return "CostCode{" +
                "codeID=" + codeID +
                ", codeName='" + codeName + '\'' +
                ", allocatedAmount=" + allocatedAmount +
                '}';
    }
}