package com.constructflow.entity;

public class Material extends Resource {

    private String unitOfMeasure;
    private String supplier;

    public Material() {
        super();
        System.out.println("[Entity] Default Material created.");
    }

    public Material(int resourceID, String name, String unitOfMeasure, String supplier) {
        super(resourceID, name);
        this.unitOfMeasure = unitOfMeasure;
        this.supplier = supplier;
        System.out.println("[Entity] Material created: " + name);
    }

    @Override
    public void displayInfo() {
        System.out.println("[Factory Method] Material (Consumable) created: " + getName());
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Material{" +
                "resourceID=" + getResourceID() + ", " +
                "name='" + getName() + "', " +
                "unitOfMeasure='" + unitOfMeasure + '\'' +
                ", supplier='" + supplier + '\'' +
                '}';
    }
}