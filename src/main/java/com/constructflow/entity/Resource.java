package com.constructflow.entity;

public abstract class Resource {

    private int resourceID;
    private String resourceName;
    private int quantityInStock;
    private int reorderThreshold;

    public Resource() {
        System.out.println("[Entity] Abstract Resource created.");
    }

    public Resource(int resourceID, String resourceName) {
        this.resourceID = resourceID;
        this.resourceName = resourceName;
        this.quantityInStock = 0;
        this.reorderThreshold = 10;
        System.out.println("[Entity] Resource '" + resourceName + "' initialized.");
    }

    public abstract void displayInfo();

    public void updateStock(double quantityChange) {
        this.quantityInStock += (int) quantityChange;
        System.out.println("[Entity] Stock updated for '" + this.resourceName + "'. New Quantity: " + this.quantityInStock);
    }

    public boolean isBelowThreshold() {
        boolean below = this.quantityInStock < this.reorderThreshold;
        if (below) {
            System.out.println("[Entity] Resource '" + this.resourceName + "' is BELOW threshold!");
        }
        return below;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getName() {
        return resourceName;
    }

    public void setName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getReorderThreshold() {
        return reorderThreshold;
    }

    public void setReorderThreshold(int reorderThreshold) {
        this.reorderThreshold = reorderThreshold;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceID=" + resourceID +
                ", resourceName='" + resourceName + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", reorderThreshold=" + reorderThreshold +
                '}';
    }
}